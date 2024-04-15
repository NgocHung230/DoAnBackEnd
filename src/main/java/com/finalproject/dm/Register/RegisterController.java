package com.finalproject.dm.Register;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Email.EmailService;
import com.finalproject.dm.Model.ThongTinUser;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Service.ThongTinUserService;
import com.finalproject.dm.Service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ThongTinUserService thongTinUserService;

    private ResponseEntity<String> checkUserAvailability(User user) {
        List<User> exitsUser = userService.getUserByCCCD(user.getCCCD());
        List<User> emailExits = userService.getUserByEmail(user.getEmail());
        if (exitsUser.size() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CCCD đã được kích hoạt!!");
        }
        if (emailExits.size() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email đã được sử dụng!!");
        }
        return ResponseEntity.ok("Thông tin khả dụng");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // if (!BCrypt.checkpw(user.getCode(), user.getCodeHashed())) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã xác nhận không đúng!");
        userService.addUser(user);
        sendEmailRegisterSuccess(user.getEmail());
        ThongTinUser ttUser = new ThongTinUser();
        ttUser.setCccd(user.getCCCD());
        ttUser.setHoTen(user.getHoTen());
        ttUser.setIdUser(user.getIdUser());
        thongTinUserService.createTTUser(ttUser);
        return ResponseEntity.ok("Đăng ký thành công !!");
    }

    

    @PostMapping("/registerCheck")
    public ResponseEntity<String> checkRegister(@RequestBody User user) {

        // System.out.println("***************************************");

        ResponseEntity<String> checkResult = checkUserAvailability(user);
        if ( checkResult.getStatusCode()!=HttpStatus.OK) return checkResult;
        // Khởi tạo đối tượng Random
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;
        confirmEmailRegister(user.getEmail(),code);
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        user.setCodeHashed(codeHashed);
        // System.out.println("123");
        return ResponseEntity.ok(codeHashed);
    }

    @PostMapping("/registerConfirmAgain")
    public ResponseEntity<String> confirmAgain(@RequestBody User user) {
        //TODO: process POST request
        // Khởi tạo đối tượng Random
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;
        confirmEmailRegister(user.getEmail(),code);
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        user.setCodeHashed(codeHashed);
        // System.out.println("123");
        return ResponseEntity.ok(codeHashed);
    }
    
    @Async
    public void confirmEmailRegister(String email,int code) {
        

        String subject = "CONFIRM REGISTER...";
        String body = "Mã xác nhận đăng ký tài khoản của bạn là " + code + ". Vui lòng xác nhận ở trang đăng ký... Xin cảm ơn !!";

        emailService.sendEmail(email, subject, body);
        
    }

    private void sendEmailRegisterSuccess(String email) {
        String subject = "REGISTER SUCCESSFULLY!";
        String body = "Tài khoản của bạn đã được đăng ký thành công, vui lòng chờ nhân viên xác nhận thông tin và kích hoạt tài khoản. Thời gian kích hoạt từ 3 đến 8 tiếng. Xin cảm ơn!!";
        emailService.sendEmail(email, subject, body);
    }
}

