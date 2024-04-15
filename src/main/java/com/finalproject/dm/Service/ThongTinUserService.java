package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.ThongTinUser;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.ThongTinUserRepo;

@Service
public class ThongTinUserService {


    @Autowired
    ThongTinUserRepo repo;
    public String getTimeString()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Định dạng thời gian hiện tại theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public ThongTinUser createTTUser(ThongTinUser TTUser)
    {
        // System.out.println(user.toString());
        
        TTUser.setIdTTUser(UUID.randomUUID().toString().split("-")[0]);
        String formattedTime = getTimeString();
        TTUser.setCreated_at(formattedTime);
        
        return repo.save(TTUser);
    }

    public ThongTinUser getTTUserByIdUser(String idUser)
    {
        List<ThongTinUser> data = repo.findByIdUser(idUser);
        // System.out.println(data.get(0));

        if (data.size()!=0)
        return data.get(0);
        return null;
    }

    public ThongTinUser updateThongTinUser(ThongTinUser TTUserRq)
    {
        ThongTinUser TTUser=repo.findById(TTUserRq.getIdTTUser()).get();
        TTUser.setHoTen(TTUserRq.getHoTen());
        TTUser.setDanToc(TTUserRq.getDanToc());
        TTUser.setDiaChiTTCuThe(TTUserRq.getDiaChiTTCuThe());
        TTUser.setGioiTinh(TTUserRq.getGioiTinh());
        TTUser.setNgaySinh(TTUserRq.getNgaySinh());
        TTUser.setQuocTich(TTUserRq.getQuocTich());
        TTUser.setTonGiao(TTUserRq.getTonGiao());
        TTUser.setNoiDKKhaiSinh(TTUserRq.getNoiDKKhaiSinh());
        TTUser.setQueQuan(TTUserRq.getQueQuan());
        TTUser.setThuongTru(TTUserRq.getThuongTru());
        TTUser.setTamTru(TTUserRq.getTamTru());
        TTUser.setThoiHanTamTru(TTUserRq.getThoiHanTamTru());
        TTUser.setNoiOHienTai(TTUserRq.getNoiOHienTai());
        TTUser.setNoiKhaiBaoTamVang(TTUserRq.getNoiKhaiBaoTamVang());
        TTUser.setTTGiaDinh(TTUserRq.getTTGiaDinh());
        TTUser.setUpdated_at(getTimeString());
        return repo.save(TTUser);
    }

    public String deleteTTUser(String idUser)
    {
        repo.deleteAllByIdUser(idUser);
        return "Xoá thông tin User thành công!";
    }

}
