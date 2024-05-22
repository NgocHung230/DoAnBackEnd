package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.KhaiBaoTamVang;
import com.finalproject.dm.Repository.KhaiBaoTamVangRepo;

@Service
public class KhaiBaoTamVangService {

    @Autowired
    private KhaiBaoTamVangRepo repo;

    public KhaiBaoTamVang createKhaiBaoTamVang(KhaiBaoTamVang data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }



    public List<KhaiBaoTamVang> getAllKhaiBaoTamVang(){
        return repo.findAll();
    }

    public KhaiBaoTamVang getKhaiBaoTamVangById(String id){
        return repo.findById(id).get();
    }

    public KhaiBaoTamVang updateKhaiBaoTamVang(KhaiBaoTamVang data){
        KhaiBaoTamVang kbtv = repo.findById(data.getId()).get();
        kbtv.setCoQuanThucHien(data.getCoQuanThucHien());
        kbtv.setDiaChi(data.getDiaChi()); 
        kbtv.setDiaChiCuThe(data.getDiaChiCuThe());
        kbtv.setNgayVang(data.getNgayVang());
        kbtv.setNgayVe(data.getNgayVe());
        kbtv.setLyDoTamVang(data.getLyDoTamVang());
        kbtv.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        kbtv.setLePhi(data.getLePhi());
        kbtv.setTrangThai(data.getTrangThai());
        kbtv.setIdNguoiDuyet(data.getIdNguoiDuyet());
        kbtv.setCreated_at(LocalDateTime.now());
        kbtv.setNote(data.getNote());
        return repo.save(kbtv);
    }

    public KhaiBaoTamVang update_TrangThai_Paying(KhaiBaoTamVang data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public KhaiBaoTamVang update_TrangThai_Cancelled(KhaiBaoTamVang data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public KhaiBaoTamVang update_TrangThai_Done(KhaiBaoTamVang data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteKhaiBaoTamVang(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
