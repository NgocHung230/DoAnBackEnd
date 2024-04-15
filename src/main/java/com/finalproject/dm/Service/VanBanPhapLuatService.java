package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.VanBanPhapLuat;
import com.finalproject.dm.Repository.VanBanPhapLuatRepo;

@Service
public class VanBanPhapLuatService {

    @Autowired
    public VanBanPhapLuatRepo repo;


    public String getTimeString()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Định dạng thời gian hiện tại theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public VanBanPhapLuat create_VBPL(VanBanPhapLuat vbpl){
        vbpl.setId(UUID.randomUUID().toString().split("-")[0]);
        String formattedTime = getTimeString();
        vbpl.setCreated_at(formattedTime);
        vbpl.setUpdated_at(formattedTime);
        
        return repo.save(vbpl);
    }

    public List<VanBanPhapLuat> findAllVBPL(){
        return repo.findAll();
    }

    public VanBanPhapLuat getVBPLById(String id){
        return repo.findById(id).get();
    }

    public VanBanPhapLuat updateBanPhapLuat(VanBanPhapLuat data){
        VanBanPhapLuat vbpl = repo.findById(data.getId()).get();

        vbpl.setTenThuTuc(data.getTenThuTuc());
        vbpl.setCoQuanThucHien(data.getCoQuanThucHien());
        vbpl.setCachThucThucHien(data.getCachThucThucHien());
        vbpl.setTrinhTuThucHien(data.getTrinhTuThucHien());
        vbpl.setThoiHanGiaiQuyet(data.getThoiHanGiaiQuyet());
        vbpl.setLePhi(data.getLePhi());
        vbpl.setThanhPhanHoSo(data.getThanhPhanHoSo());
        vbpl.setYeuCauDieuKien(data.getYeuCauDieuKien());
        vbpl.setCanCuPhapLy(data.getCanCuPhapLy());
        vbpl.setKetQuaThucHien(data.getKetQuaThucHien());
        vbpl.setIdNguoiThayDoi(data.getIdNguoiThayDoi());
        vbpl.setUpdated_at(getTimeString());
        return repo.save(vbpl);
    }

    public String deleteVanBanPhapLuat(String id){
        try{
            repo.deleteById(id);
            return "Đã xoá Văn Bản Pháp Luật thành công!";
        } catch (Exception e) {
            return "Xoá thất bại!";
        }
    }
}
