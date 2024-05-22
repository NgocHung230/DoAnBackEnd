package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DanhGiaHoSo;
import com.finalproject.dm.Model.DiaChi;

public interface DanhGiaHoSoRepo extends MongoRepository<DanhGiaHoSo,String>{

    DanhGiaHoSo getByIdHoSo(String idHoSo);

    @Query("{'coQuanThucHien':?0}")
    List<DanhGiaHoSo> findAllByCoQuanThucHien(DiaChi coQuanThucHien);

    // List<DanhGiaHoSo> findAllByDiaChi();

}
