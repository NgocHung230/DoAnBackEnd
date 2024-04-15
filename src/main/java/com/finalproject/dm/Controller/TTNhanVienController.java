package com.finalproject.dm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.ThongTinNhanVien;
import com.finalproject.dm.Service.ThongTinNhanVienService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class TTNhanVienController {

    @Autowired
    ThongTinNhanVienService ttnvService;


    //Lấy thông tin cá nhân bằng idUser
    @GetMapping("/TTNV/get/{idUser}")
    public ResponseEntity<ThongTinNhanVien> getTTNV(@PathVariable String idUser) {
        return ResponseEntity.ok(ttnvService.getTTNVByIdUser(idUser));
    }

    @PostMapping("/TTNV/create")
    public ResponseEntity<ThongTinNhanVien> createTTNV(@RequestBody ThongTinNhanVien data) {
        //TODO: process POST request
        
        return ResponseEntity.ok(ttnvService.createTTNhanVien(data));
    }

    @PutMapping("/TTNV/update")
    public ResponseEntity<ThongTinNhanVien> updateTTNV(@RequestBody ThongTinNhanVien data) {
        //TODO: process PUT request
        
        return ResponseEntity.ok(ttnvService.updateThongTinNhanVien(data));
    }

    @DeleteMapping("/TTNV/delete/{idUser}")
    public ResponseEntity<String> deleteTTNV(@PathVariable String idUser){
        return ResponseEntity.ok(ttnvService.deleteTTNV(idUser));
    }
    
    
}
