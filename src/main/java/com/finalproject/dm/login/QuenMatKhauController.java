package com.finalproject.dm.login;

import java.util.List;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Email.EmailService;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class QuenMatKhauController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;


    @PostMapping("/checkAcount")
    public ResponseEntity<String> sendCode(@RequestBody FormQuenMatKhau data) {
        //TODO: process POST request
        List<User> L = userService.getUserByCCCD(data.getCccd());
        if (L.size()==0) return ResponseEntity.badRequest().body("Không tìm thấy tài khoản!");
        User user=L.get(0);
        int code =sendCodeQuenMatKhau(user.getEmail()); 
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        data.setCodeHashed(codeHashed);
        return ResponseEntity.ok(codeHashed);
    }

    @PostMapping("/sendEmailAgainForgotPass")
    public ResponseEntity<String> sendEmailAgain(@RequestBody FormQuenMatKhau data) {
        //TODO: process POST request
        
        List<User> L = userService.getUserByCCCD(data.getCccd());
        if (L.size()==0) return ResponseEntity.badRequest().body("Không tìm thấy tài khoản!");
        User user=L.get(0);
        int code =sendCodeQuenMatKhau(user.getEmail()); 
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        data.setCodeHashed(codeHashed);
        return ResponseEntity.ok(codeHashed);
    }
    
    @PostMapping("/checkCode")
    public ResponseEntity<String> checkCode(@RequestBody FormQuenMatKhau data) {
        //TODO: process POST request
        if (!BCrypt.checkpw(data.getCode(), data.getCodeHashed())) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã xác nhận không đúng!");
        return ResponseEntity.ok("Mã xác nhận đúng!");
    }

    @PostMapping("/setNewPassword")
    public ResponseEntity<String> setNewPassword(@RequestBody FormQuenMatKhau data) {
        //TODO: process POST request
        List<User> L = userService.getUserByCCCD(data.getCccd());
        System.out.println(data);
        if (L.size()==0) return ResponseEntity.badRequest().body("Không tìm thấy tài khoản!");
        System.out.println(data.getMatKhauMoi());
        User user=L.get(0);
        System.out.println(user);
        String newPw = BCrypt.hashpw(data.getMatKhauMoi(), BCrypt.gensalt());
        user.setMatKhau(newPw);
        userService.updateUser(user);
        return ResponseEntity.ok("Thay đổi mật khẩu thành công!!");
    }
    public int sendCodeQuenMatKhau(String email) {
        // Khởi tạo đối tượng Random
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;

        String subject = "CONFIRM EMAIL...";
        String body = "Mã xác nhận quên mật khẩu của bạn là " + code + ". Vui lòng xác nhận ở trang quên mật khẩu... Xin cảm ơn !!";

        emailService.sendEmail(email, subject, body);
        return code;
    }
    
}
