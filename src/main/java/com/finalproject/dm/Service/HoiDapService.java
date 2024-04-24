package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.HoiDap;
import com.finalproject.dm.Repository.HoiDapRepo;

@Service
public class HoiDapService {

    @Autowired
    private HoiDapRepo hoiDapRepo;

    public HoiDap createHoiDap(HoiDap data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        return hoiDapRepo.save(data);
    }

    public HoiDap updateHoiDap(HoiDap data){
        data.setUpdated_at(LocalDateTime.now());
        return hoiDapRepo.save(data);
    }

    public List<HoiDap> getAllHoiDap(){
        return hoiDapRepo.findAll();
    }

    public List<HoiDap> getAllHoiDapByIdUser(String idUser){
        return hoiDapRepo.findAllByIdUser(idUser);
    }
}
