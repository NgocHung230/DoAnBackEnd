package com.finalproject.dm.Filter.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Filter.Model.FormQuanLyHoSo;
import com.finalproject.dm.Filter.Model.QuanLyHoSoUser;
import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Model.KhaiBaoTamVang;
import com.finalproject.dm.Model.KhaiBaoThuongTru;
import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Model.ThongKeDoanhThu;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Model.XoaDangKyTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;
import com.finalproject.dm.Repository.GiaHanTamTruRepo;
import com.finalproject.dm.Repository.KhaiBaoTamTruRepo;
import com.finalproject.dm.Repository.KhaiBaoTamVangRepo;
import com.finalproject.dm.Repository.KhaiBaoThuongTruRepo;
import com.finalproject.dm.Repository.ThongBaoLuuTruRepo;
import com.finalproject.dm.Repository.ThongKeDoanhThuRepo;
import com.finalproject.dm.Repository.UserRepo;
import com.finalproject.dm.Repository.XoaDangKyTamTruRepo;
import com.finalproject.dm.Repository.XoaDangKyThuongTruRepo;
import com.finalproject.dm.Service.ThongKeDoanhThuService;

@Service
public class QuanLyHoSoUserService {

    @Autowired
    private GiaHanTamTruRepo giaHanTamTruRepo;
    @Autowired
    private ThongBaoLuuTruRepo thongBaoLuuTruRepo;
    @Autowired
    private XoaDangKyThuongTruRepo xoaDangKyThuongTruRepo;
    @Autowired
    private XoaDangKyTamTruRepo xoaDangKyTamTruRepo;
    @Autowired
    private KhaiBaoTamTruRepo khaiBaoTamTruRepo;
    @Autowired
    private KhaiBaoThuongTruRepo khaiBaoThuongTruRepo;
    @Autowired
    private KhaiBaoTamVangRepo khaiBaoTamVangRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ThongKeDoanhThuRepo thongKeDoanhThuRepo;
    @Autowired
    private ThongKeDoanhThuService thongKeDoanhThuService;

    public List<GiaHanTamTru> getAllGiaHanTamTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<GiaHanTamTru> data = giaHanTamTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<ThongBaoLuuTru> getAllThongBaoLuuTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<ThongBaoLuuTru> data = thongBaoLuuTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<KhaiBaoTamTru> getAllKhaiBaoTamTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<KhaiBaoTamTru> data = khaiBaoTamTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<KhaiBaoTamVang> getAllKhaiBaoTamVang(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<KhaiBaoTamVang> data = khaiBaoTamVangRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<KhaiBaoThuongTru> getAllKhaiBaoThuongTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<KhaiBaoThuongTru> data = khaiBaoThuongTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<XoaDangKyTamTru> getAllXoaDangKyTamTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<XoaDangKyTamTru> data = xoaDangKyTamTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public List<XoaDangKyThuongTru> getAllXoaDangKyThuongTru(String idUser){

        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        List<XoaDangKyThuongTru> data = xoaDangKyThuongTruRepo.getAllByIdUser(idUser,sort);
        return data;
    }
    public QuanLyHoSoUser getAllHoSoChecking(String idUser){
        Sort sort= Sort.by(Sort.Direction.ASC,"created_at");
        QuanLyHoSoUser data = new QuanLyHoSoUser();
        data.setGiaHanTamTrus(giaHanTamTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setKhaiBaoTamTrus(khaiBaoTamTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setKhaiBaoTamVangs(khaiBaoTamVangRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setKhaiBaoThuongTrus(khaiBaoThuongTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setThongBaoLuuTrus(thongBaoLuuTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setXoaDangKyTamTrus(xoaDangKyTamTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        data.setXoaDangKyThuongTrus(xoaDangKyThuongTruRepo.getAllCheckingByIdUser(idUser,"Checking",sort));
        
        return data;
    }

    public QuanLyHoSoUser getAllHoSoPaying(String idUser){
        Sort sort= Sort.by(Sort.Direction.ASC,"created_at");
        QuanLyHoSoUser data = new QuanLyHoSoUser();
        data.setGiaHanTamTrus(giaHanTamTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setKhaiBaoTamTrus(khaiBaoTamTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setKhaiBaoTamVangs(khaiBaoTamVangRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setKhaiBaoThuongTrus(khaiBaoThuongTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setThongBaoLuuTrus(thongBaoLuuTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setXoaDangKyTamTrus(xoaDangKyTamTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        data.setXoaDangKyThuongTrus(xoaDangKyThuongTruRepo.getAllCheckingByIdUser(idUser,"Paying",sort));
        return data;
    }

    public QuanLyHoSoUser getAllHoSoDone(String idUser){
        Sort sort= Sort.by(Sort.Direction.ASC,"created_at");
        QuanLyHoSoUser data = new QuanLyHoSoUser();
        data.setGiaHanTamTrus(giaHanTamTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setKhaiBaoTamTrus(khaiBaoTamTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setKhaiBaoTamVangs(khaiBaoTamVangRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setKhaiBaoThuongTrus(khaiBaoThuongTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setThongBaoLuuTrus(thongBaoLuuTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setXoaDangKyTamTrus(xoaDangKyTamTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        data.setXoaDangKyThuongTrus(xoaDangKyThuongTruRepo.getAllCheckingByIdUser(idUser,"Done",sort));
        return data;
    }

    public QuanLyHoSoUser getAllHoSoCancel(String idUser){
        Sort sort= Sort.by(Sort.Direction.ASC,"created_at");
        QuanLyHoSoUser data = new QuanLyHoSoUser();
        data.setGiaHanTamTrus(giaHanTamTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setKhaiBaoTamTrus(khaiBaoTamTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setKhaiBaoTamVangs(khaiBaoTamVangRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setKhaiBaoThuongTrus(khaiBaoThuongTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setThongBaoLuuTrus(thongBaoLuuTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setXoaDangKyTamTrus(xoaDangKyTamTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        data.setXoaDangKyThuongTrus(xoaDangKyThuongTruRepo.getAllCheckingByIdUser(idUser,"Cancelled",sort));
        return data;
    }

    public QuanLyHoSoUser getAll(String idUser){
        Sort sort= Sort.by(Sort.Direction.ASC,"trangThai").and(Sort.by(Sort.Direction.ASC, "created_at"));;
        System.out.println(idUser);
        QuanLyHoSoUser data = new QuanLyHoSoUser();
        data.setGiaHanTamTrus(giaHanTamTruRepo.getAllByIdUser(idUser,sort));
        data.setKhaiBaoTamTrus(khaiBaoTamTruRepo.getAllByIdUser(idUser,sort));
        data.setKhaiBaoTamVangs(khaiBaoTamVangRepo.getAllByIdUser(idUser,sort));
        data.setKhaiBaoThuongTrus(khaiBaoThuongTruRepo.getAllByIdUser(idUser,sort));
        data.setThongBaoLuuTrus(thongBaoLuuTruRepo.getAllByIdUser(idUser,sort));
        data.setXoaDangKyTamTrus(xoaDangKyTamTruRepo.getAllByIdUser(idUser,sort));
        data.setXoaDangKyThuongTrus(xoaDangKyThuongTruRepo.getAllByIdUser(idUser,sort));
        return data;
    }

    public String checkCCCDAvailable(String cccd){

        List<User> data = userRepo.findByCCCD(cccd);
        if (data.size()!=0) return data.get(0).getEmail();
        return null;
    }
    public List<FormQuanLyHoSo> getAllHoSoByCCCD(String cccd){

        List<User> data = userRepo.findByCCCD(cccd);
        // System.out.println(data.get(0));
        String idUser="";
        if (data.size()!=0)  idUser = data.get(0).getIdUser();
        QuanLyHoSoUser temp = getAll(idUser);
        List<FormQuanLyHoSo> dt= new ArrayList<FormQuanLyHoSo>();
        for (GiaHanTamTru t : temp.getGiaHanTamTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (KhaiBaoTamTru t : temp.getKhaiBaoTamTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (KhaiBaoTamVang t : temp.getKhaiBaoTamVangs()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (KhaiBaoThuongTru t : temp.getKhaiBaoThuongTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (ThongBaoLuuTru t : temp.getThongBaoLuuTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (XoaDangKyTamTru t : temp.getXoaDangKyTamTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        for (XoaDangKyThuongTru t : temp.getXoaDangKyThuongTrus()) {
            FormQuanLyHoSo tm = new FormQuanLyHoSo();
            tm.setId(t.getId());
            tm.setTenThuTuc(t.getTenThuTuc());
            tm.setNgayTao(t.getCreated_at());
            tm.setTrangThai(t.getTrangThai());
            dt.add(tm);
        }
        return dt;
    }

    public ResponseEntity getHoSoByIdHoSo(FormQuanLyHoSo data){
        

        if (data.getTenThuTuc().equals("Gia hạn tạm trú"))
            return ResponseEntity.ok(giaHanTamTruRepo.findById(data.getId()).get());
        else if (data.getTenThuTuc().equals("Khai báo tạm trú"))
        return ResponseEntity.ok(khaiBaoTamTruRepo.findById(data.getId()).get()); 
        else if (data.getTenThuTuc().equals("Khai báo tạm vắng"))
        return ResponseEntity.ok(khaiBaoTamVangRepo.findById(data.getId()).get()); 
        else if (data.getTenThuTuc().equals("Khai báo thường trú"))
        return ResponseEntity.ok(khaiBaoThuongTruRepo.findById(data.getId()).get()); 
        else if (data.getTenThuTuc().equals("Xoá đăng ký tạm trú"))
        return ResponseEntity.ok(xoaDangKyTamTruRepo.findById(data.getId()).get()); 
        else if (data.getTenThuTuc().equals("Thông báo lưu trú"))
        return ResponseEntity.ok(xoaDangKyTamTruRepo.findById(data.getId()).get()); 
        
        return ResponseEntity.ok(xoaDangKyThuongTruRepo.findById(data.getId()).get());
    }

    public ResponseEntity updateDoneHoSo(String id){

        if (giaHanTamTruRepo.findById(id).isPresent()){
            GiaHanTamTru dt = giaHanTamTruRepo.findById(id).get();
            System.out.println(dt);
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            giaHanTamTruRepo.save(dt);
            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (thongBaoLuuTruRepo.findById(id).isPresent()){
            ThongBaoLuuTru dt = thongBaoLuuTruRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            thongBaoLuuTruRepo.save(dt);
            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (khaiBaoTamTruRepo.findById(id).isPresent()){
            KhaiBaoTamTru dt = khaiBaoTamTruRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            khaiBaoTamTruRepo.save(dt);

            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (khaiBaoTamVangRepo.findById(id).isPresent()){
            KhaiBaoTamVang dt = khaiBaoTamVangRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            khaiBaoTamVangRepo.save(dt);

            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (khaiBaoThuongTruRepo.findById(id).isPresent()){
            KhaiBaoThuongTru dt = khaiBaoThuongTruRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            khaiBaoThuongTruRepo.save(dt);

            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (xoaDangKyTamTruRepo.findById(id).isPresent()){
            XoaDangKyTamTru dt = xoaDangKyTamTruRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            xoaDangKyTamTruRepo.save(dt);
            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }else
        if (xoaDangKyThuongTruRepo.findById(id).isPresent()){
            XoaDangKyThuongTru dt = xoaDangKyThuongTruRepo.findById(id).get();
            dt.setTrangThai("Done");
            dt.setUpdated_at(LocalDateTime.now());
            xoaDangKyThuongTruRepo.save(dt);

            int thang = LocalDateTime.now().getMonthValue();
            int nam = LocalDateTime.now().getYear();
            ThongKeDoanhThu tk = thongKeDoanhThuService.getDoanhThuByThangNamCoQuan(thang, nam, dt.getCoQuanThucHien());
            if (tk==null){
                ThongKeDoanhThu tknew = new ThongKeDoanhThu();
                tknew.setDiaChiCoQuan(dt.getCoQuanThucHien());
                tknew.setDoanhThu(dt.getLePhi());
                tknew.setNam(nam);
                tknew.setThang(thang);
                thongKeDoanhThuService.createThongKeDoanhThu(tknew);
            }
            else{
                tk.setDoanhThu(tk.getDoanhThu().add(dt.getLePhi()));
                thongKeDoanhThuService.updateDoanhThu(tk);
            }
        }
        return ResponseEntity.ok("Lỗi dcmm");
    }
}
