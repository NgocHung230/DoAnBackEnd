package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.XoaDangKyTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;
import com.finalproject.dm.Repository.XoaDangKyTamTruRepo;

@Service
public class XoaDangKyTamTruService {

    @Autowired
    private XoaDangKyTamTruRepo repo;

    public XoaDangKyTamTru createXoaDangKyTamTru(XoaDangKyTamTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<XoaDangKyTamTru> getAllXoaDangKyTamTru(){
        return repo.findAll();
    }

    public XoaDangKyTamTru getXoaDangKyTamTruById(String id){
        return repo.findById(id).get();
    }

    public XoaDangKyTamTru updateXoaDangKyTamTru(XoaDangKyTamTru data){
        XoaDangKyTamTru xdktt = repo.findById(data.getId()).get();
        xdktt.setCoQuanThucHien(data.getCoQuanThucHien());

        xdktt.setNoiDungDeNghi(data.getNoiDungDeNghi());
        xdktt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        xdktt.setLePhi(data.getLePhi());
        xdktt.setTrangThai(data.getTrangThai());
        xdktt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        xdktt.setNote(data.getNote());
        xdktt.setCreated_at(LocalDateTime.now());
        return repo.save(xdktt);
    }

    public XoaDangKyTamTru update_TrangThai_Paying(XoaDangKyTamTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public XoaDangKyTamTru update_TrangThai_Cancelled(XoaDangKyTamTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public XoaDangKyTamTru update_TrangThai_Done(XoaDangKyTamTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteXoaDangKyTamTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
