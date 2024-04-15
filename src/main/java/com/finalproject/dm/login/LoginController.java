package com.finalproject.dm.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Email.EmailService;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody FormLogin data) {
        //TODO: process POST request
        System.out.println(userService.getUserByCCCD(data.getCccd()));
        User user = userService.getUserByCCCD(data.getCccd()).get(0);
        String token = loginService.generateToken(user.getIdUser(),user.getHoTen(),user.getRole());
        System.out.println(token);
        JSONObject doc = new JSONObject();


        doc.put("token", token);
        doc.put("role", user.getRole());
        doc.put("hoTen", user.getHoTen());
        return ResponseEntity.ok(doc.toString());
    }


    @PostMapping("/sendEmailLogin")
    public ResponseEntity<String> sendEmailLogin(@RequestBody FormLogin data) {
        //TODO: process POST request
        System.out.println("*****1");
        String result = loginService.checkAcount(data.getCccd(), data.getMatKhau());
        if (!result.equals("Login Success!"))
            return ResponseEntity.badRequest().body(result);
        User user = userService.getUserByCCCD(data.getCccd()).get(0);
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;
        sendEmailConfirmLogin(user.getEmail(),code);
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        System.out.println("*****2");

        return ResponseEntity.ok(codeHashed);
    }

    @PostMapping("/sendEmailLoginAgain")
    public ResponseEntity<String> sendEmailLoginAgain(@RequestBody FormLogin data) {
        //TODO: process POST request
        User user = userService.getUserByCCCD(data.getCccd()).get(0);
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;
        sendEmailConfirmLogin(user.getEmail(),code);
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        return ResponseEntity.ok(codeHashed);
    }
    
    //Lấy thông tin user từ token
    @GetMapping("/getUserFromToken/{token}")
    public ResponseEntity<Map> getUserFromToken(@PathVariable String token) {
        if(loginService.validateToken(token))
        {
            Map<String,String> data = loginService.getDataUserFromToken(token);
        return ResponseEntity.ok(data);
        }
        return ResponseEntity.badRequest().body(null);
    }


    @Async
    private void sendEmailConfirmLogin(String email,int code) {
        

        String subject = "LOGIN CONFIRM!";
        String body = "Tài khoản của bạn vừa được đăng nhập, vui lòng nhập mã code "+code+" để tiếp tục trình duyệt!";
        emailService.sendEmail(email, subject, body);
    }
    
    // Kiểm tra token hết hạn chưa
    @GetMapping("/checkAvailedToken/{token}")
    public ResponseEntity checkToken(@PathVariable String token) {
        //TODO: process POST request
        
        return ResponseEntity.ok(loginService.validateToken(token));
    }
    
}
