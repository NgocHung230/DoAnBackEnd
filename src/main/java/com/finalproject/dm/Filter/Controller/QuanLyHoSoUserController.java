package com.finalproject.dm.Filter.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Email.EmailService;
import com.finalproject.dm.Filter.Model.FormQuanLyHoSo;
import com.finalproject.dm.Filter.Service.QuanLyHoSoUserService;

import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class QuanLyHoSoUserController {

    @Autowired
    private QuanLyHoSoUserService quanLyHoSoUserService;

    @Autowired
    private EmailService emailService;


    //Lấy hồ sơ đang chờ duyệt
    @GetMapping("/QuanLyHoSoUserChecking/{idUser}")
    public ResponseEntity getHoSoChecking(@PathVariable String idUser) {
        System.out.println(idUser);
        return ResponseEntity.ok(quanLyHoSoUserService.getAllHoSoChecking(idUser));
    }

    //Lấy hồ sơ đang chờ thanh toán
    @GetMapping("/QuanLyHoSoUserPaying/{idUser}")
    public ResponseEntity getHoSoPaying(@PathVariable String idUser) {
        // System.out.println(idUser);
        return ResponseEntity.ok(quanLyHoSoUserService.getAllHoSoChecking(idUser));
    }

    //Lấy hồ sơ đã bị huỷ
    @GetMapping("/QuanLyHoSoUserCancelled/{idUser}")
    public ResponseEntity getHoSoCancelled(@PathVariable String idUser) {
        // System.out.println(idUser);
        return ResponseEntity.ok(quanLyHoSoUserService.getAllHoSoChecking(idUser));
    }

    //Lấy hồ sơ đã hoàn thành
    @GetMapping("/QuanLyHoSoUserDone/{idUser}")
    public ResponseEntity getHoSoDone(@PathVariable String idUser) {
        // System.out.println(idUser);
        return ResponseEntity.ok(quanLyHoSoUserService.getAllHoSoChecking(idUser));
    }
    
    @GetMapping("/QLHSGiaHanTamTru/{idUser}")
    public ResponseEntity getAllGiaHanTamTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllGiaHanTamTru(idUser));
    }
    @GetMapping("/QLHSThongBaoLuuTru/{idUser}")
    public ResponseEntity getAllThongBaoLuuTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllThongBaoLuuTru(idUser));
    }
    @GetMapping("/QLHSKhaiBaoTamTru/{idUser}")
    public ResponseEntity getAllKhaiBaoTamTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllKhaiBaoTamTru(idUser));
    }
    @GetMapping("/QLHSKhaiBaoTamVang/{idUser}")
    public ResponseEntity getAllKhaiBaoTamVang(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllKhaiBaoTamVang(idUser));
    }
    @GetMapping("/QLHSKhaiBaoThuongTru/{idUser}")
    public ResponseEntity getAllKhaiBaoThuongTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllKhaiBaoThuongTru(idUser));
    }
    
    @GetMapping("/QLHSXoaDangKyTamTru/{idUser}")
    public ResponseEntity getAllXoaDangKyTamTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllXoaDangKyTamTru(idUser));
    }

    @GetMapping("/QLHSXoaDangKyThuongTru/{idUser}")
    public ResponseEntity getAllXoaDangKyThuongTru(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllXoaDangKyThuongTru(idUser));
    }

    @GetMapping("/getAllQuanLyHoSoUser/{idUser}")
    public ResponseEntity getAllQuanLyHoSoUser(@PathVariable String idUser) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAll(idUser));
    }

    @GetMapping("/getAllHoSoByCCCD/{cccd}")
    public ResponseEntity getAllQuanLyHoSoUserByCCCD(@PathVariable String cccd) {
        return ResponseEntity.ok(quanLyHoSoUserService.getAllHoSoByCCCD(cccd));
    }

    @GetMapping("/getHoSoTraCuu")
    public ResponseEntity getAllQuanLyHoSoUserByCCCD(@RequestBody FormQuanLyHoSo data) {
        return ResponseEntity.ok(quanLyHoSoUserService.getHoSoByIdHoSo(data));
    }

    @GetMapping("/getMaXacNhanByCCCD/{cccd}")
    public ResponseEntity getMaXacNhanByCCCD(@PathVariable String cccd) {
        System.out.println("Chạy lấy mã xác nhận!!");
        String email = quanLyHoSoUserService.checkCCCDAvailable(cccd);
        if (email==null) return ResponseEntity.ok("CCCD không tồn tại!");
        Random random = new Random();

        // Tạo số ngẫu nhiên có 6 chữ số
        int code = random.nextInt(900000) + 100000;
        sendEmailConfirmLogin(email,code);
        String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
        return ResponseEntity.ok(codeHashed);
    }

    // @PostMapping("/sendEmailLogin")
    // public ResponseEntity<String> sendEmailLogin(@RequestBody FormLogin data) {
    //     //TODO: process POST request

    //     String result = loginService.checkAcount(data.getCccd(), data.getMatKhau());
    //     if (!result.equals("Login Success!"))
    //         return ResponseEntity.badRequest().body(result);
    //     User user = userService.getUserByCCCD(data.getCccd()).get(0);
    //     Random random = new Random();

    //     // Tạo số ngẫu nhiên có 6 chữ số
    //     int code = random.nextInt(900000) + 100000;
    //     sendEmailConfirmLogin(user.getEmail(),code);
    //     String codeHashed = BCrypt.hashpw(Integer.toString(code), BCrypt.gensalt());
    //     System.out.println("*****2");

    //     return ResponseEntity.ok(codeHashed);
    // }

    @Async
    private void sendEmailConfirmLogin(String email,int code) {
        

        String subject = "MÃ XÁC NHẬN TRA CỨU HỒ SƠ!!";
        String body = "Bạn vừa tra cứu hồ sơ vui lòng nhập mã code "+code+" để tiếp tục!";
        emailService.sendEmail(email, subject, body);
    }
    
    // @PutMapping("PayingSuccess/{id}/{email}")
    // public ResponseEntity PayingSuccess(@PathVariable("id") String id,@PathVariable("email") String email) {
    //     //TODO: process PUT request
    //     System.out.println(id+" "+email);
    //     sendEmailPayingSuccess(email);
    //     return quanLyHoSoUserService.updateDoneHoSo(id);
    // }
    @PutMapping("PayingSuccess/{id}/{email}")
    public ResponseEntity PayingSuccess(@PathVariable("id") String id,@PathVariable("email") String email) {
        System.out.println(id+" "+email);
        sendEmailPayingSuccess(email);
        return quanLyHoSoUserService.updateDoneHoSo(id);
    }
    
    
    @Async
    private void sendEmailPayingSuccess(String email) {
        

        String subject = "THANH TOÁN THÀNH CÔNG!!";
        String body = "Bạn đã thanh toán thành công hồ sơ! Vui lòng đợi kết quả trả về! Cảm ơn sự ủng hộ của bạn !!";
        emailService.sendEmail(email, subject, body);
    }
}
