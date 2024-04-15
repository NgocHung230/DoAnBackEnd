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
import com.finalproject.dm.Model.KhaiBaoTamVang;
import com.finalproject.dm.Service.KhaiBaoTamVangService;

@RestController
public class KhaiBaoTamVangController {

    @Autowired
    private KhaiBaoTamVangService khaiBaoTamVangService;

    @PostMapping("/KhaiBaoTamVang/create")
    public ResponseEntity<KhaiBaoTamVang> createKhaiBaoTamVang(@RequestBody KhaiBaoTamVang data) {
        return ResponseEntity.ok(khaiBaoTamVangService.createKhaiBaoTamVang(data));
    }

    @GetMapping("/KhaiBaoTamVang/{id}")
    public ResponseEntity<KhaiBaoTamVang> getKhaiBaoTamVang(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoTamVangService.getKhaiBaoTamVangById(id));
    }
    
    @PutMapping("/KhaiBaoTamVang/update")
    public ResponseEntity<KhaiBaoTamVang> updateKhaiBaoTamVang(@RequestBody KhaiBaoTamVang data) {
        return ResponseEntity.ok(khaiBaoTamVangService.updateKhaiBaoTamVang(data));
    }
    
    @DeleteMapping("/KhaiBaoTamVang/delete/{id}")
    public ResponseEntity<String> deleteKhaiBaoTamVang(@PathVariable String id) {
        return ResponseEntity.ok(khaiBaoTamVangService.deleteKhaiBaoTamVang(id));
    }
}
