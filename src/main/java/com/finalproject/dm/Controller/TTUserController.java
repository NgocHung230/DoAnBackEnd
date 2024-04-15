package com.finalproject.dm.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.ThongTinUser;
import com.finalproject.dm.Service.ThongTinUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class TTUserController {

    @Autowired
    ThongTinUserService ttUserService;

    @PostMapping("/TTUser/create")
    public ResponseEntity createThongTinUser(@RequestBody ThongTinUser TTUser) {
        //TODO: process POST request
        try {
            return ResponseEntity.ok(ttUserService.createTTUser(TTUser));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Thêm mới thất bại!!");
        }
    }

    @GetMapping("/TTUser/{idUser}")
    public ResponseEntity getThongTinUser(@PathVariable String idUser) {
        
            return ResponseEntity.ok(ttUserService.getTTUserByIdUser(idUser));
        
            // return ResponseEntity.badRequest().body("Không tìm thấy dữ liệu!");
    }
    
    @PutMapping("/TTUser/update")
    public ResponseEntity updateThongTinUser(@RequestBody ThongTinUser ttUser) {
        //TODO: process PUT request
        
        return ResponseEntity.ok(ttUserService.updateThongTinUser(ttUser));
    }

    @DeleteMapping("/TTUser/delete/{idUser}")
    public ResponseEntity deleteThongTinUser(@PathVariable String idUser){

        return ResponseEntity.ok(ttUserService.deleteTTUser(idUser));
    } 
    
}
