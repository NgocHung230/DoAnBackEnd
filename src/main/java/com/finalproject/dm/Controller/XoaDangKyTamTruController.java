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

import com.finalproject.dm.Model.XoaDangKyTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;
import com.finalproject.dm.Service.XoaDangKyTamTruService;

@RestController
public class XoaDangKyTamTruController {

    @Autowired
    private XoaDangKyTamTruService xoaDangKyTamTruService;

    @PostMapping("/XoaDangKyTamTru/create")
    public ResponseEntity<XoaDangKyTamTru> createXoaDangKyTamTru(@RequestBody XoaDangKyTamTru data) {
        return ResponseEntity.ok(xoaDangKyTamTruService.createXoaDangKyTamTru(data));
    }

    @GetMapping("/XoaDangKyTamTru/{id}")
    public ResponseEntity<XoaDangKyTamTru> getXoaDangKyTamTru(@PathVariable String id) {
        return ResponseEntity.ok(xoaDangKyTamTruService.getXoaDangKyTamTruById(id));
    }
    
    @PutMapping("/XoaDangKyTamTru/update")
    public ResponseEntity<XoaDangKyTamTru> updateXoaDangKyTamTru(@RequestBody XoaDangKyTamTru data) {
        return ResponseEntity.ok(xoaDangKyTamTruService.updateXoaDangKyTamTru(data));
    }
    
    @DeleteMapping("/XoaDangKyTamTru/delete/{id}")
    public ResponseEntity<String> deleteXoaDangKyTamTru(@PathVariable String id) {
        return ResponseEntity.ok(xoaDangKyTamTruService.deleteXoaDangKyTamTru(id));
    }
}
