package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.DanhGiaHoSo;
import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Repository.DanhGiaHoSoRepo;
import com.finalproject.dm.Repository.GiaHanTamTruRepo;
import com.finalproject.dm.Repository.KhaiBaoTamTruRepo;
import com.finalproject.dm.Repository.KhaiBaoTamVangRepo;
import com.finalproject.dm.Repository.KhaiBaoThuongTruRepo;
import com.finalproject.dm.Repository.ThongBaoLuuTruRepo;
import com.finalproject.dm.Repository.XoaDangKyTamTruRepo;
import com.finalproject.dm.Repository.XoaDangKyThuongTruRepo;

@Service
public class DanhGiaHoSoService {

    @Autowired
    private DanhGiaHoSoRepo danhGiaHoSoRepo;

    @Autowired
    private GiaHanTamTruRepo giaHanTamTruRepo;
    @Autowired
    private ThongBaoLuuTruRepo thongBaoLuuTruRepo;
    @Autowired
    private XoaDangKyThuongTruRepo xoaDangKyThuongTruRepo;
    @Autowired
    private XoaDangKyTamTruRepo xoaDangKyTamTruRepo;
    @Autowired
    private KhaiBaoTamTruRepo khaiBaoTamTruRepo;
    @Autowired
    private KhaiBaoThuongTruRepo khaiBaoThuongTruRepo;
    @Autowired
    private KhaiBaoTamVangRepo khaiBaoTamVangRepo;


    public DanhGiaHoSo createDanhGiaHoSo(DanhGiaHoSo data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        return danhGiaHoSoRepo.save(data);
    }

    public DanhGiaHoSo getDanhGiaHoSoByIdHoSo(String idHoSo){

        return danhGiaHoSoRepo.getByIdHoSo(idHoSo);
    }

    public List<DanhGiaHoSo> getAllDanhGiaHoSo(DiaChi coQuanThucHien){

        return danhGiaHoSoRepo.findAllByCoQuanThucHien(coQuanThucHien);
    }

    public DanhGiaHoSo getDanhGiaHoSoById(String id){

        return danhGiaHoSoRepo.findById(id).get();
    }

    public ResponseEntity getHoSoByDanhGia(DanhGiaHoSo data){

        if (data.getTenThuTuc().equals("Gia hạn tạm trú"))
            return ResponseEntity.ok(giaHanTamTruRepo.findById(data.getIdHoSo()).get());
        else if (data.getTenThuTuc().equals("Khai báo tạm trú"))
        return ResponseEntity.ok(khaiBaoTamTruRepo.findById(data.getIdHoSo()).get()); 
        else if (data.getTenThuTuc().equals("Khai báo tạm vắng"))
        return ResponseEntity.ok(khaiBaoTamVangRepo.findById(data.getIdHoSo()).get()); 
        else if (data.getTenThuTuc().equals("Khai báo thường trú"))
        return ResponseEntity.ok(khaiBaoThuongTruRepo.findById(data.getIdHoSo()).get()); 
        else if (data.getTenThuTuc().equals("Xoá đăng ký tạm trú"))
        return ResponseEntity.ok(xoaDangKyTamTruRepo.findById(data.getIdHoSo()).get()); 
        else if (data.getTenThuTuc().equals("Thông báo lưu trú"))
        return ResponseEntity.ok(xoaDangKyTamTruRepo.findById(data.getIdHoSo()).get()); 
        
        return ResponseEntity.ok(xoaDangKyThuongTruRepo.findById(data.getIdHoSo()).get());
    }
}
