package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Repository.KhaiBaoTamTruRepo;

@Service
public class KhaiBaoTamTruService {

    @Autowired
    private KhaiBaoTamTruRepo repo;

    public KhaiBaoTamTru createKhaiBaoTamTru(KhaiBaoTamTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<KhaiBaoTamTru> getAllKhaiBaoTamTru(){
        return repo.findAll();
    }

    public KhaiBaoTamTru getKhaiBaoTamTruById(String id){
        return repo.findById(id).get();
    }

    public KhaiBaoTamTru updateKhaiBaoTamTru(KhaiBaoTamTru data){
        KhaiBaoTamTru kbtt = repo.findById(data.getId()).get();
        kbtt.setCoQuanThucHien(data.getCoQuanThucHien());
        kbtt.setDiaChiTamTru(data.getDiaChiTamTru());
        kbtt.setDiaChiCuThe(data.getDiaChiCuThe());
        kbtt.setTenChuHo(data.getTenChuHo());
        kbtt.setQuanHeChuHo(data.getQuanHeChuHo());
        kbtt.setCccdChuHo(data.getCccdChuHo());
        kbtt.setNoiDungDeNghi(data.getNoiDungDeNghi());
        kbtt.setYKien(data.getYKien());
        kbtt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        kbtt.setLePhi(data.getLePhi());
        kbtt.setTrangThai(data.getTrangThai());
        kbtt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        kbtt.setCreated_at(LocalDateTime.now());
        kbtt.setNote(data.getNote());
        return repo.save(kbtt);
    }

    public KhaiBaoTamTru update_TrangThai_Paying(KhaiBaoTamTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public KhaiBaoTamTru update_TrangThai_Cancelled(KhaiBaoTamTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public KhaiBaoTamTru update_TrangThai_Done(KhaiBaoTamTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteKhaiBaoTamTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
