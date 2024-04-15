package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Repository.GiaHanTamTruRepo;

@Service
public class GiaHanTamTruService {

    @Autowired
    private GiaHanTamTruRepo repo;

    public String getTimeString()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Định dạng thời gian hiện tại theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }

    public GiaHanTamTru createGiaHanTamTru(GiaHanTamTru data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        data.setTrangThai("Checking");
        return repo.save(data);
    }
    public List<GiaHanTamTru> getAllGiaHanTamTru(){
        return repo.findAll();
    }

    public GiaHanTamTru getGiaHanTamTruById(String id){
        return repo.findById(id).get();
    }

    public GiaHanTamTru updateGiaHanTamTru(GiaHanTamTru data){
        GiaHanTamTru ghtt = repo.findById(data.getId()).get();
        ghtt.setCoQuanThucHien(data.getCoQuanThucHien());
        ghtt.setDiaChiTamTru(data.getDiaChiTamTru());
        ghtt.setDiaChiCuThe(data.getDiaChiCuThe());
        ghtt.setNoiDungDeNghi(data.getNoiDungDeNghi());
        ghtt.setYKien(data.getYKien());
        ghtt.setFileHoSoLienQuan(data.getFileHoSoLienQuan());
        ghtt.setLePhi(data.getLePhi());
        ghtt.setTrangThai("Checking");
        ghtt.setIdNguoiDuyet(data.getIdNguoiDuyet());
        ghtt.setCreated_at(LocalDateTime.now());
        return repo.save(ghtt);
    }

    public GiaHanTamTru update_TrangThai_Paying(GiaHanTamTru data){
        data.setTrangThai("Paying");
        return repo.save(data);
    }
    public GiaHanTamTru update_TrangThai_Cancelled(GiaHanTamTru data){
        data.setTrangThai("Cancelled");
        return repo.save(data);
    }
    public GiaHanTamTru update_TrangThai_Done(GiaHanTamTru data){
        data.setTrangThai("Done");
        return repo.save(data);
    }
    public String deleteGiaHanTamTru(String id){
        try {
            repo.deleteById(id);
            return "Đã xoá Gia Hạn Tạm Trú thành công!";
        } catch (Exception e) {
            // TODO: handle exception
            return "Xoá thất bại!";
        }
    }

}
