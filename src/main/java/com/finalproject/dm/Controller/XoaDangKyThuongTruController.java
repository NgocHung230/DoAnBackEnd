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

import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;
import com.finalproject.dm.Service.XoaDangKyThuongTruService;

@RestController
public class XoaDangKyThuongTruController {

    @Autowired
    private XoaDangKyThuongTruService xoaDangKyThuongTruService;

    @PostMapping("/XoaDangKyThuongTru/create")
    public ResponseEntity<XoaDangKyThuongTru> createXoaDangKyThuongTru(@RequestBody XoaDangKyThuongTru data) {
        return ResponseEntity.ok(xoaDangKyThuongTruService.createXoaDangKyThuongTru(data));
    }

    @GetMapping("/XoaDangKyThuongTru/{id}")
    public ResponseEntity<XoaDangKyThuongTru> getXoaDangKyThuongTru(@PathVariable String id) {
        return ResponseEntity.ok(xoaDangKyThuongTruService.getXoaDangKyThuongTruById(id));
    }
    
    @PutMapping("/XoaDangKyThuongTru/update")
    public ResponseEntity<XoaDangKyThuongTru> updateXoaDangKyThuongTru(@RequestBody XoaDangKyThuongTru data) {
        return ResponseEntity.ok(xoaDangKyThuongTruService.updateXoaDangKyThuongTru(data));
    }
    
    @DeleteMapping("/XoaDangKyThuongTru/delete/{id}")
    public ResponseEntity<String> deleteXoaDangKyThuongTru(@PathVariable String id) {
        return ResponseEntity.ok(xoaDangKyThuongTruService.deleteXoaDangKyThuongTru(id));
    }
}
