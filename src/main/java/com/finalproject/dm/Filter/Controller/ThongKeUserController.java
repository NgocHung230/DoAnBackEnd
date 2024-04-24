package com.finalproject.dm.Filter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Filter.Service.ThongKeUserSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ThongKeUserController {

    @Autowired
    private ThongKeUserSerivce thongKeUserSerivce;

    @GetMapping("/ThongKeUser")
    public ResponseEntity getThongKeUser() {
        return ResponseEntity.ok(thongKeUserSerivce.ThongKeUser());
    }
    @GetMapping("/ThongKeUserGiamDan")
    public ResponseEntity getThongKeUserGiamDan() {
        return ResponseEntity.ok(thongKeUserSerivce.ThongKeUserGiamDan());
    }
    @GetMapping("/ThongKeUserTangDan")
    public ResponseEntity getThongKeUserTangDan() {
        return ResponseEntity.ok(thongKeUserSerivce.ThongKeUserTangDan());
    }

    @PostMapping("/ThongKeUserFilter/{filter}")
    public ResponseEntity getThongKeUserFilter(@PathVariable String filter) {
        //TODO: process POST request
        System.out.println(filter);
        System.out.println(thongKeUserSerivce.TimKiemTinhThongKe(filter));
        return ResponseEntity.ok(thongKeUserSerivce.TimKiemTinhThongKe(filter));
    }
    
    @GetMapping("/ThongKeUser/{tinh}")
    public ResponseEntity getThongKeUserHuyen(@PathVariable String tinh) {
        return ResponseEntity.ok(thongKeUserSerivce.thongKeUserHuyen(tinh));
    }

    @GetMapping("/ThongKeUser/{tinh}/{huyen}")
    public ResponseEntity getThongKeUserXa(@PathVariable String tinh,@PathVariable String huyen) {
        return ResponseEntity.ok(thongKeUserSerivce.thongKeUserXa(tinh,huyen));
    }
    
}
