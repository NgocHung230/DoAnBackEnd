package com.finalproject.dm.Filter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Filter.Service.ThongKeUserSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ThongKeUserController {

    @Autowired
    private ThongKeUserSerivce thongKeUserSerivce;

    @GetMapping("/ThongKeUser")
    public ResponseEntity getMethodName() {
        return ResponseEntity.ok(thongKeUserSerivce.ThongKeUser());
    }
    
}
