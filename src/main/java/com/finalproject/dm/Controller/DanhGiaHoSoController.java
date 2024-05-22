package com.finalproject.dm.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.DanhGiaHoSo;
import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Service.DanhGiaHoSoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class DanhGiaHoSoController {

    @Autowired
    private DanhGiaHoSoService danhGiaHoSoService;

    @GetMapping("/DanhGiaHoSoByIdHoSo/{idHoSo}")
    public ResponseEntity getDanhGiaHoSoByIdHoso(@PathVariable String idHoSo) {
        return ResponseEntity.ok(danhGiaHoSoService.getDanhGiaHoSoByIdHoSo(idHoSo));
    }

    @PostMapping("/createDanhGiaHoSo")
    public ResponseEntity createDanhGiaHoSo(@RequestBody DanhGiaHoSo data) {
        //TODO: process POST request
        
        return ResponseEntity.ok(danhGiaHoSoService.createDanhGiaHoSo(data));
    }
    
    @PostMapping("/getAllDanhGiaHoSo")
    public ResponseEntity getAllDanhGiaHoSo(@RequestBody DiaChi coQuanThucHien) {
        System.out.println("Chạy getAllDanhGiaHoSo");
        
        // System.out.println(danhGiaHoSoService.getAllDanhGiaHoSo(coQuanThucHien));
        return ResponseEntity.ok(danhGiaHoSoService.getAllDanhGiaHoSo(coQuanThucHien));
    }

    @GetMapping("/getHoSoByDanhGiaForm")
    public ResponseEntity getHoSoByDanhGiaForm(@RequestBody DanhGiaHoSo data) {
        return ResponseEntity.ok(danhGiaHoSoService.getHoSoByDanhGia(data));
    }
    
    
}
