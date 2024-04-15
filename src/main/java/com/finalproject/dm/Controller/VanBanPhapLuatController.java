package com.finalproject.dm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.VanBanPhapLuat;
import com.finalproject.dm.Service.VanBanPhapLuatService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VanBanPhapLuatController {

    @Autowired
    private VanBanPhapLuatService VBPLService;

    @GetMapping("/getAllVBPL")
    public ResponseEntity<List> getAllVBPL() {
        return ResponseEntity.ok(VBPLService.findAllVBPL());
    }

    @PostMapping("/createVBPL")
    public ResponseEntity<VanBanPhapLuat> createVBPL(@RequestBody VanBanPhapLuat vbpl) {
        //TODO: process POST request
        
        return ResponseEntity.ok(VBPLService.create_VBPL(vbpl));
    }
    
    @PutMapping("/updateVBPL")
    public ResponseEntity<VanBanPhapLuat> updateVBPL(@RequestBody VanBanPhapLuat vbpl) {
        //TODO: process POST request
        
        return ResponseEntity.ok(VBPLService.updateBanPhapLuat(vbpl));
    }

    @DeleteMapping("/deleteVBPL/{id}")
    public ResponseEntity<String> deleteVBPL(@PathVariable String id){
        return ResponseEntity.ok(VBPLService.deleteVanBanPhapLuat(id));
    }

    @GetMapping("/getVBPL/{id}")
    public ResponseEntity<VanBanPhapLuat> getVBPL(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(VBPLService.getVBPLById(id));
    }
    
    
}
