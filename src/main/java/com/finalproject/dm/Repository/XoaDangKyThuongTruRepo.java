package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.XoaDangKyThuongTru;

public interface XoaDangKyThuongTruRepo extends MongoRepository<XoaDangKyThuongTru,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<XoaDangKyThuongTru> getAllCheckingByIdUser(String idUser, String string, Sort sort);

    @Query("{'idUser': ?0}")
    List<XoaDangKyThuongTru> getAllByIdUser(String idUser, Sort sort);

}
