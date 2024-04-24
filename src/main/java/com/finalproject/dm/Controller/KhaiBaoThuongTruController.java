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

import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Model.KhaiBaoThuongTru;
import com.finalproject.dm.Service.KhaiBaoThuongTruService;

@RestController
public class KhaiBaoThuongTruController {

    @Autowired
    private KhaiBaoThuongTruService khaiBaoThuongTruService;

    @PostMapping("/KhaiBaoThuongTru/create")
    public ResponseEntity<KhaiBaoThuongTru> createKhaiBaoThuongTru(@RequestBody KhaiBaoThuongTru data) {
        System.out.println("Chạy****");
        return ResponseEntity.ok(khaiBaoThuongTruService.createKhaiBaoThuongTru(data));
    }

    @GetMapping("/KhaiBaoThuongTru/{id}")
    public ResponseEntity<KhaiBaoThuongTru> getKhaiBaoThuongTru(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoThuongTruService.getKhaiBaoThuongTruById(id));
    }
    
    @PutMapping("/KhaiBaoThuongTru/update")
    public ResponseEntity<KhaiBaoThuongTru> updateKhaiBaoThuongTru(@RequestBody KhaiBaoThuongTru data) {
        return ResponseEntity.ok(khaiBaoThuongTruService.updateKhaiBaoThuongTru(data));
    }
    
    @DeleteMapping("/KhaiBaoThuongTru/delete/{id}")
    public ResponseEntity<String> deleteKhaiBaoThuongTru(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoThuongTruService.deleteKhaiBaoThuongTru(id));
    }
}
