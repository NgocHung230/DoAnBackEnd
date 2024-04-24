package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.GiaHanTamTru;

public interface GiaHanTamTruRepo extends MongoRepository<GiaHanTamTru,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<GiaHanTamTru> getAllCheckingByIdUser(String idUser,String trangThai,Sort sort);
    @Query("{'idUser': ?0}")
    List<GiaHanTamTru> getAllByIdUserOrderByCreatedAt(String idUser);
    
    @Query("{'idUser': ?0}")
    List<GiaHanTamTru> getAllByIdUser(String idUser,Sort sort);

}
