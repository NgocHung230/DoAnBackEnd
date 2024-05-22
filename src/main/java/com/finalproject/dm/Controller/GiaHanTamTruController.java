package com.finalproject.dm.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Service.GiaHanTamTruService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class GiaHanTamTruController {

    @Autowired
    GiaHanTamTruService giaHanTamTruService;

    @PostMapping("/GiaHanTamTru/create")
    public ResponseEntity<GiaHanTamTru> createGiaHanTamTru(@RequestBody GiaHanTamTru data) {
        return ResponseEntity.ok(giaHanTamTruService.createGiaHanTamTru(data));
    }

    @GetMapping("/GiaHanTamTru/{id}")
    public ResponseEntity<GiaHanTamTru> getGiaHanTamTru(@PathVariable String id) {
        return ResponseEntity.ok(giaHanTamTruService.getGiaHanTamTruById(id));
    }  
    
    @PutMapping("/GiaHanTamTru/update")
    public ResponseEntity<GiaHanTamTru> updateGiaHanTamTru(@RequestBody GiaHanTamTru data) {
        System.out.println(data);
        return ResponseEntity.ok(giaHanTamTruService.updateGiaHanTamTru(data));
    }
    
    @DeleteMapping("/GiaHanTamTru/delete/{id}")
    public ResponseEntity<String> deleteGiaHanTamTru(@PathVariable String id) {
        return ResponseEntity.ok(giaHanTamTruService.deleteGiaHanTamTru(id));
    }
}
