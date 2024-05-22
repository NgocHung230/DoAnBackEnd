package com.finalproject.dm.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Filter.Model.FormThongKeHoSoCoQuan;
import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.FormThongKeDoanhThu;
import com.finalproject.dm.Model.ThongKeDoanhThu;
import com.finalproject.dm.Repository.ThongKeDoanhThuRepo;

@Service
public class ThongKeDoanhThuService {

    @Autowired
    private ThongKeDoanhThuRepo thongKeDoanhThuRepo;
    
    public ThongKeDoanhThu createThongKeDoanhThu(ThongKeDoanhThu data){

        data.setId(UUID.randomUUID().toString().split("-")[0]);
        return thongKeDoanhThuRepo.save(data);
    }

    public ThongKeDoanhThu updateDoanhThu(ThongKeDoanhThu data){

        
        return thongKeDoanhThuRepo.save(data);
    }

    public ThongKeDoanhThu getDoanhThuByThangNamCoQuan(int thang, int nam, DiaChi diaChiCoQuan){

        ThongKeDoanhThu dt = thongKeDoanhThuRepo.findByThangNamCoQuan(thang,nam,diaChiCoQuan);
        return dt;
    }

    public ThongKeDoanhThu getDoanhThuByCoQuan(DiaChi diaChiCoQuan){

        ThongKeDoanhThu dt = thongKeDoanhThuRepo.findByCoQuan(diaChiCoQuan);
        return dt;
    }

    public ResponseEntity getThongKeTheoNam(FormThongKeDoanhThu form){

        if (form.getNam()==0) form.setNam(LocalDateTime.now().getYear());
        List<ThongKeDoanhThu> dt=thongKeDoanhThuRepo.findAllByNam(form.getNam());
        Map<Integer,BigDecimal> res = new TreeMap<>();
        for(int i=1;i<=12;i++)
            res.put(i, new BigDecimal(0));
        if (form.getTinh().equals("")){
            for (ThongKeDoanhThu thongKeDoanhThu : dt) {
                res.put(thongKeDoanhThu.getThang(), res.get(thongKeDoanhThu.getThang()).add(thongKeDoanhThu.getDoanhThu()));
            }
        }else{
            for (ThongKeDoanhThu thongKeDoanhThu : dt) {
                if (thongKeDoanhThu.getDiaChiCoQuan().getTinh().equals(form.getTinh()))
                    res.put(thongKeDoanhThu.getThang(), res.get(thongKeDoanhThu.getThang()).add(thongKeDoanhThu.getDoanhThu()));
            }
        }
        return ResponseEntity.ok(res);
    }

    public ResponseEntity getThongKeDoanhThuByCoQuan(FormThongKeHoSoCoQuan form){

        List<ThongKeDoanhThu> dt=thongKeDoanhThuRepo.findAllByCoQuanAndNam(form.getCoQuan(),form.getNam());
        Map<Integer,BigDecimal> res = new TreeMap<>();
        for(int i=1;i<=12;i++)
            res.put(i, new BigDecimal(0));
        for (ThongKeDoanhThu thongKeDoanhThu : dt) {
            res.put(thongKeDoanhThu.getThang(), res.get(thongKeDoanhThu.getThang()).add(thongKeDoanhThu.getDoanhThu()));
        }
        return ResponseEntity.ok(res);
    }
}
