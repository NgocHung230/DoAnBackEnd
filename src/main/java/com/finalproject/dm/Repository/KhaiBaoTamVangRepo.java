package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.KhaiBaoTamVang;

public interface KhaiBaoTamVangRepo extends MongoRepository<KhaiBaoTamVang,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<KhaiBaoTamVang> getAllCheckingByIdUser(String idUser, String string, Sort sort);
    @Query("{'idUser': ?0}")
    List<KhaiBaoTamVang> getAllByIdUser(String idUser, Sort sort);

    @Query("{'trangThai': ?0,'coQuanThucHien':?1}")
    List<KhaiBaoTamVang> getAllByPheDuyetByDiaChiIdUser(String trangThai, DiaChi coQuanThucHien, Sort sort);

}
