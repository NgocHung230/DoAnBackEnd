package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.XoaDangKyTamTru;

public interface XoaDangKyTamTruRepo extends MongoRepository<XoaDangKyTamTru,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<XoaDangKyTamTru> getAllCheckingByIdUser(String idUser, String string, Sort sort);

    @Query("{'idUser': ?0}")
    List<XoaDangKyTamTru> getAllByIdUser(String idUser, Sort sort);

}
