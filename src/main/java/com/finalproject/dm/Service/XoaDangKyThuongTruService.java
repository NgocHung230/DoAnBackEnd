package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;
import com.finalproject.dm.Repository.XoaDangKyThuongTruRepo;

@Service
public class XoaDangKyThuongTruService {

    @Autowired
    private XoaDangKyThuongTruRepo repo;

    public XoaDangKyThuongTru createXoaDangKyThuongTru(XoaDangKyThuongTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<XoaDangKyThuongTru> getAllXoaDangKyThuongTru(){
        return repo.findAll();
    }

    public XoaDangKyThuongTru getXoaDangKyThuongTruById(String id){
        return repo.findById(id).get();
    }

    public XoaDangKyThuongTru updateXoaDangKyThuongTru(XoaDangKyThuongTru data){
        XoaDangKyThuongTru xdktt = repo.findById(data.getId()).get();
        xdktt.setCoQuanThucHien(data.getCoQuanThucHien());

        xdktt.setNoiDungDeNghi(data.getNoiDungDeNghi());
        xdktt.setYKien(data.getYKien());
        xdktt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        xdktt.setLePhi(data.getLePhi());
        xdktt.setTrangThai("Checking");
        xdktt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        xdktt.setCreated_at(LocalDateTime.now());
        return repo.save(xdktt);
    }

    public XoaDangKyThuongTru update_TrangThai_Paying(XoaDangKyThuongTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public XoaDangKyThuongTru update_TrangThai_Cancelled(XoaDangKyThuongTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public XoaDangKyThuongTru update_TrangThai_Done(XoaDangKyThuongTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteXoaDangKyThuongTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }
}
