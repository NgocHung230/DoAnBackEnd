package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.ThongTinNhanVien;

public interface ThongTinNhanVienRepo extends MongoRepository<ThongTinNhanVien,String>{

    ThongTinNhanVien findAllByIdUser(String idUser);

    void deleteAllByIdUser(String idUser);

    @Query("{'idUser': ?0}")
    ThongTinNhanVien findByIdUser(String idUser);

    @Query("{'idUser': ?0}")
    void deleteByIdUser(String idUser);

    List<ThongTinNhanVien> findAllByCoQuan(DiaChi coQuan);

}
