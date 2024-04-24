package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.HoiDap;

public interface HoiDapRepo extends MongoRepository<HoiDap,String>{

    @Query("{'idUser': ?0}")
    List<HoiDap> findAllByIdUser(String idUser);

}
