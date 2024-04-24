package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.ThongKeDoanhThu;

public interface ThongKeDoanhThuRepo extends MongoRepository<ThongKeDoanhThu,String>{

    @Query("{'thang':?0, 'nam':?1,'diaChiCoQuan':?2}")
    ThongKeDoanhThu findByThangNamCoQuan(int thang, int nam, DiaChi diaChiCoQuan);

    @Query("{'diaChiCoQuan':?0}")
    ThongKeDoanhThu findByCoQuan(DiaChi diaChiCoQuan);

    List<ThongKeDoanhThu> findAllByNam(int nam);

}
