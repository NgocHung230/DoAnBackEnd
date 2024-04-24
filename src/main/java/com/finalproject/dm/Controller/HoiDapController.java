package com.finalproject.dm.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Model.HoiDap;
import com.finalproject.dm.Service.HoiDapService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class HoiDapController {


    @Autowired
    private HoiDapService hoiDapService;

    @GetMapping("/getAllHoiDap")
    public List<HoiDap> getAllHoiDap() {
        return hoiDapService.getAllHoiDap();
    }

    @GetMapping("/getAllHoiDapByIdUser/{idUser}")
    public List<HoiDap> getAllHoiDapByIdUser(@PathVariable String idUser) {
        return hoiDapService.getAllHoiDapByIdUser(idUser);
    }

    @PostMapping("/createHoiDap")
    public HoiDap createHoiDap(@RequestBody HoiDap data) {
        //TODO: process POST request
        
        return hoiDapService.createHoiDap(data);
    }

    @PutMapping("updateHoiDap")
    public HoiDap updateHoiDap(@RequestBody HoiDap data) {
        //TODO: process PUT request
        
        return hoiDapService.updateHoiDap(data);
    }
    
    
}
