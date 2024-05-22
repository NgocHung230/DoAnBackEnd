package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.ThongTinNhanVien;
import com.finalproject.dm.Repository.ThongTinNhanVienRepo;

@Service
public class ThongTinNhanVienService {

    @Autowired
    ThongTinNhanVienRepo repo;
    public String getTimeString()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Định dạng thời gian hiện tại theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public ThongTinNhanVien createTTNhanVien(ThongTinNhanVien TTNV)
    {
        // System.out.println(user.toString());

        TTNV.setIdTTNV(UUID.randomUUID().toString().split("-")[0]);
        String formattedTime = getTimeString();
        TTNV.setCreated_at(formattedTime);
        
        return repo.save(TTNV);
    }

    public ThongTinNhanVien getTTNVByIdUser(String idUser)
    {
        return repo.findByIdUser(idUser);
    }

    public ThongTinNhanVien updateThongTinNhanVien(ThongTinNhanVien TTNVrq)
    {
        ThongTinNhanVien TTNV=repo.findById(TTNVrq.getIdTTNV()).get();
        TTNV.setChucVu(TTNVrq.getChucVu());
        TTNV.setGioiTinh(TTNVrq.getGioiTinh());
        TTNV.setNgaySinh(TTNVrq.getNgaySinh());
        TTNV.setSdt(TTNVrq.getSdt());
        TTNV.setEmail(TTNVrq.getEmail());
        TTNV.setDiaChi(TTNVrq.getDiaChi());
        TTNV.setCoQuan(TTNVrq.getCoQuan());
        
        return repo.save(TTNV);
    }

    public String deleteTTNV(String idUser)
    {
        repo.deleteByIdUser(idUser);
        return "Xoá thông tin Nhân viên thành công!";
    }

    public ResponseEntity getAllEmployeeByCoQuan(DiaChi coQuan){

        return ResponseEntity.ok(repo.findAllByCoQuan(coQuan));
    }

}
