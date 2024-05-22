package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Model.KhaiBaoThuongTru;
import com.finalproject.dm.Repository.KhaiBaoThuongTruRepo;

@Service
public class KhaiBaoThuongTruService {

    @Autowired
    private KhaiBaoThuongTruRepo repo;

    public KhaiBaoThuongTru createKhaiBaoThuongTru(KhaiBaoThuongTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<KhaiBaoThuongTru> getAllKhaiBaoThuongTru(){
        return repo.findAll();
    }

    public KhaiBaoThuongTru getKhaiBaoThuongTruById(String id){
        return repo.findById(id).get();
    }

    public KhaiBaoThuongTru updateKhaiBaoThuongTru(KhaiBaoThuongTru data){
        KhaiBaoThuongTru kbtt = repo.findById(data.getId()).get();
        kbtt.setCoQuanThucHien(data.getCoQuanThucHien());
        kbtt.setDiaChiThuongTru(data.getDiaChiThuongTru());
        kbtt.setDiaChiCuThe(data.getDiaChiCuThe());
        kbtt.setTenChuHo(data.getTenChuHo());
        kbtt.setQuanHeChuHo(data.getQuanHeChuHo());
        kbtt.setCccdChuHo(data.getCccdChuHo());
        kbtt.setNoiDungDeNghi(data.getNoiDungDeNghi());
        kbtt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        kbtt.setLePhi(data.getLePhi());
        kbtt.setTrangThai(data.getTrangThai());
        kbtt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        kbtt.setCreated_at(LocalDateTime.now());
        kbtt.setNote(data.getNote());
        return repo.save(kbtt);
    }

    public KhaiBaoThuongTru update_TrangThai_Paying(KhaiBaoThuongTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public KhaiBaoThuongTru update_TrangThai_Cancelled(KhaiBaoThuongTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public KhaiBaoThuongTru update_TrangThai_Done(KhaiBaoThuongTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteKhaiBaoThuongTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
