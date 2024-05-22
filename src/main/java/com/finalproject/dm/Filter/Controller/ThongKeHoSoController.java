package com.finalproject.dm.Filter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Filter.Model.FormThongKeHoSo;
import com.finalproject.dm.Filter.Model.FormThongKeHoSoCoQuan;
import com.finalproject.dm.Filter.Service.ThongKeHoSoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ThongKeHoSoController {

    @Autowired
    private ThongKeHoSoService thongKeHoSoService;

    @PostMapping("/getThongKeHoSo")
    public ResponseEntity getThongKeHoSo(@RequestBody FormThongKeHoSo form) {
        return ResponseEntity.ok(thongKeHoSoService.getHoSoThongKe(form));
    }

    @PostMapping("/getThongKeHoSoCoQuan")
    public ResponseEntity getThongKeHoSoCoQuan(@RequestBody FormThongKeHoSoCoQuan form) {
        return ResponseEntity.ok(thongKeHoSoService.getThongKeCoQuan(form));
    }
    
}
