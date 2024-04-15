package com.finalproject.dm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Service.ThongBaoLuuTruService;

@RestController
public class ThongBaoLuuTruController {

    @Autowired
    private ThongBaoLuuTruService thongBaoLuuTruService;

    @PostMapping("/ThongBaoLuuTru/create")
    public ResponseEntity<ThongBaoLuuTru> createThongBaoLuuTru(@RequestBody ThongBaoLuuTru data) {
        return ResponseEntity.ok(thongBaoLuuTruService.createThongBaoLuuTru(data));
    }

    @GetMapping("/ThongBaoLuuTru/{id}")
    public ResponseEntity<ThongBaoLuuTru> getThongBaoLuuTru(@PathVariable String id) {
        return ResponseEntity.ok(thongBaoLuuTruService.getThongBaoLuuTruById(id));
    }
    
    @PutMapping("/ThongBaoLuuTru/update")
    public ResponseEntity<ThongBaoLuuTru> updateThongBaoLuuTru(@RequestBody ThongBaoLuuTru data) {
        return ResponseEntity.ok(thongBaoLuuTruService.updateThongBaoLuuTru(data));
    }
    
    @DeleteMapping("/ThongBaoLuuTru/delete/{id}")
    public ResponseEntity<String> deleteThongBaoLuuTru(@PathVariable String id) {
        return ResponseEntity.ok(thongBaoLuuTruService.deleteThongBaoLuuTru(id));
    }
}
