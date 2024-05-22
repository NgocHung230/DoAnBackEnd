package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.KhaiBaoThuongTru;

public interface KhaiBaoThuongTruRepo extends MongoRepository<KhaiBaoThuongTru,String>{

    @Query("{'idUser': ?0,'trangThai': ?1}")
    List<KhaiBaoThuongTru> getAllCheckingByIdUser(String idUser, String string, Sort sort);

    @Query("{'idUser': ?0}")
    List<KhaiBaoThuongTru> getAllByIdUser(String idUser, Sort sort);

    @Query("{'trangThai': ?0,'coQuanThucHien':?1}")
    List<KhaiBaoThuongTru> getAllByPheDuyetByDiaChiIdUser(String trangThai, DiaChi coQuanThucHien, Sort sort);

}
