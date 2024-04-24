package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.KhaiBaoTamTru;

public interface KhaiBaoTamTruRepo extends MongoRepository<KhaiBaoTamTru,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<KhaiBaoTamTru> getAllCheckingByIdUser(String idUser, String string, Sort sort);
    @Query("{'idUser': ?0}")
    List<KhaiBaoTamTru> getAllByIdUser(String idUser, Sort sort);

}
