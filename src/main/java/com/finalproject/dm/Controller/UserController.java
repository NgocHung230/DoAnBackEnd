package com.finalproject.dm.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Email.EmailService;
import com.finalproject.dm.Model.ThongTinNhanVien;
import com.finalproject.dm.Model.ThongTinUser;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.UserRepo;
import com.finalproject.dm.Service.ThongTinNhanVienService;
import com.finalproject.dm.Service.ThongTinUserService;
import com.finalproject.dm.Service.UserService;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;







@RestController
public class UserController {



    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    private ThongTinNhanVienService thongTinNhanVienService;

    @GetMapping("/admin/getAlluser")
    public ResponseEntity<List<User>> getUser() {
        List<User> userList = userService.findAllUserNotAdmin();
        // System.out.println("Chạy");
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/admin/getUser/{role}")
    public ResponseEntity<List<User>> getUserByRole(@PathVariable String role) {
        //TODO: process POST request
        
        return ResponseEntity.ok(userService.findAllUserRole(role));
    }
    
    @PutMapping("/admin/updateUser")
    public ResponseEntity updateUser(@RequestBody User user) {
        //TODO: process POST request
        userService.updateUser(user);
        return ResponseEntity.ok("Updated Successfully!");
    }
    
    @DeleteMapping("/admin/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable String id)
    {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
    
    @PutMapping("employee/{idNguoiDuyet}/{idUser}")
    public ResponseEntity pheDuyetUser(@PathVariable String idNguoiDuyet, @PathVariable String idUser) {
        //TODO: process PUT request
        User user = userService.getUserByIDUser(idUser);
        sendEmailPheDuyet(user.getEmail());
        return ResponseEntity.ok(userService.pheDuyetUser(idNguoiDuyet, idUser));
    }

    @Async
    public void sendEmailPheDuyet(String email){
        String subject = "THÔNG BÁO PHÊ DUYỆT!!";
        String body = "Tài khoản của bạn đã được phê duyệt!!";
        emailService.sendEmail(email, subject, body);
    }
    
    @GetMapping("employee/donPheDuyet")
    public ResponseEntity<List> getDonPheDuyet() {
        return ResponseEntity.ok(userService.getUserChoPheDuyet());
    }
    
    @GetMapping("/getUserByCCCD/{cccd}")
    public ResponseEntity<List> getUserByCccd(@PathVariable String cccd) {
        //TODO: process POST request
        return ResponseEntity.ok(userService.getUserByCCCD(cccd));
    }
    
    @GetMapping("/getUserById/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable String idUser) {
        //TODO: process POST request
        // ThongTinUser ttUser = ttUserService.getTTUserByIdUser(idUser);
        User user = userService.getUserByIDUser(idUser);
        // System.out.println(user);
        // JSONObject data = new JSONObject();
        // data.append("user", user);
        // data.append("ThongTinUser", ttUser);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/admin/createManager")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        //TODO: process POST request
        if (userService.getUserByCCCD(user.getCCCD()).size()!=0) {
            
            return ResponseEntity.badRequest().body("CCCD đã tồn tại!");
        }
        if (userService.getUserByEmail(user.getEmail()).size()!=0) {
            return ResponseEntity.badRequest().body("Email đã tồn tại!");
        }
        User data = userService.addManager(user);
        ThongTinNhanVien ttnv = new ThongTinNhanVien();
        ttnv.setCccd(data.getCCCD());
        ttnv.setHoTen(data.getHoTen());
        ttnv.setIdUser(data.getIdUser());
        ttnv.setSdt(data.getSdt());
        ttnv.setEmail(data.getEmail());
        thongTinNhanVienService.createTTNhanVien(ttnv);
        return ResponseEntity.ok("Thêm thành công");
    }
}
