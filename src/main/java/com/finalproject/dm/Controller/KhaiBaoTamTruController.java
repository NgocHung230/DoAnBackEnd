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
import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Service.KhaiBaoTamTruService;

@RestController
public class KhaiBaoTamTruController {

    @Autowired
    private KhaiBaoTamTruService khaiBaoTamTruService;

    @PostMapping("/KhaiBaoTamTru/create")
    public ResponseEntity<KhaiBaoTamTru> createKhaiBaoTamTru(@RequestBody KhaiBaoTamTru data) {
        return ResponseEntity.ok(khaiBaoTamTruService.createKhaiBaoTamTru(data));
    }

    @GetMapping("/KhaiBaoTamTru/{id}")
    public ResponseEntity<KhaiBaoTamTru> getKhaiBaoTamTru(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoTamTruService.getKhaiBaoTamTruById(id));
    }
    
    @PutMapping("/KhaiBaoTamTru/update")
    public ResponseEntity<KhaiBaoTamTru> updateKhaiBaoTamTru(@RequestBody KhaiBaoTamTru data) {
        return ResponseEntity.ok(khaiBaoTamTruService.updateKhaiBaoTamTru(data));
    }
    
    @DeleteMapping("/KhaiBaoTamTru/delete/{id}")
    public ResponseEntity<String> deleteKhaiBaoTamTru(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoTamTruService.deleteKhaiBaoTamTru(id));
    }
}
