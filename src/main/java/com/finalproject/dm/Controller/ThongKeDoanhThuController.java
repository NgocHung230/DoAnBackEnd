package com.finalproject.dm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Filter.Model.FormThongKeHoSoCoQuan;
import com.finalproject.dm.Model.FormThongKeDoanhThu;
import com.finalproject.dm.Service.ThongKeDoanhThuService;

@RestController
public class ThongKeDoanhThuController {

    @Autowired
    private ThongKeDoanhThuService thongKeDoanhThuService;
    @PostMapping("/getThongKeDoanhThu")
    public ResponseEntity getThongKeDoanhThu(@RequestBody FormThongKeDoanhThu form){
        System.out.println(form);
        return thongKeDoanhThuService.getThongKeTheoNam(form);
    }

    @PostMapping("/getThongKeDoanhThuByCoQuan")
    public ResponseEntity getThongKeDoanhThuByCoQuan(@RequestBody FormThongKeHoSoCoQuan form){
        System.out.println(form);
        return thongKeDoanhThuService.getThongKeDoanhThuByCoQuan(form);
    }
}
