package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.ThongTinUser;

public interface ThongTinUserRepo extends MongoRepository<ThongTinUser,String> {

    ThongTinUser findAllByIdUser(String idUser);

    void deleteAllByIdUser(String idUser);
    
    // @Query("select * from thongTinUser where idUser=?")
    List<ThongTinUser> findByIdUser(String idUser);

    @Query("{'idUser':?0}")
    ThongTinUser getByIdUser(String idUser);

}
