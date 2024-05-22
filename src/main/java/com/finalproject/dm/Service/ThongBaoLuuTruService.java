package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Repository.ThongBaoLuuTruRepo;

@Service
public class ThongBaoLuuTruService {

    @Autowired
    private ThongBaoLuuTruRepo repo;

    public ThongBaoLuuTru createThongBaoLuuTru(ThongBaoLuuTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<ThongBaoLuuTru> getAllThongBaoLuuTru(){
        return repo.findAll();
    }

    public ThongBaoLuuTru getThongBaoLuuTruById(String id){
        return repo.findById(id).get();
    }

    public ThongBaoLuuTru updateThongBaoLuuTru(ThongBaoLuuTru data){
        ThongBaoLuuTru tblt = repo.findById(data.getId()).get();
        tblt.setCoQuanThucHien(data.getCoQuanThucHien());
        tblt.setLoaiHinhCoSo(data.getLoaiHinhCoSo());
        tblt.setTenCoSo(data.getTenCoSo());
        tblt.setDiaChiLuuTru(data.getDiaChiLuuTru());
        tblt.setDiaChiCuThe(data.getDiaChiCuThe());
        tblt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        tblt.setLePhi(data.getLePhi());
        tblt.setTrangThai(data.getTrangThai());
        tblt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        tblt.setNote(tblt.getNote());
        tblt.setCreated_at(LocalDateTime.now());
        return repo.save(tblt);
    }

    public ThongBaoLuuTru update_TrangThai_Paying(ThongBaoLuuTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public ThongBaoLuuTru update_TrangThai_Cancelled(ThongBaoLuuTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public ThongBaoLuuTru update_TrangThai_Done(ThongBaoLuuTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteThongBaoLuuTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
