package com.finalproject.dm.Filter.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Filter.Model.FormThongKeHoSo;
import com.finalproject.dm.Filter.Model.QuanLyHoSoUser;
import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Model.KhaiBaoTamVang;
import com.finalproject.dm.Model.KhaiBaoThuongTru;
import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Model.XoaDangKyTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;

@Service
public class ThongKeHoSoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Map<Integer, Map<String,Integer> > getHoSoThongKe(FormThongKeHoSo data) {
        // Tính ngày bắt đầu và ngày kết thúc của năm nhập vào
        // System.out.println(data);
        int year = 2024;
        if (data.getNam()!=0) year= data.getNam(); 
        // System.out.println(year);
        LocalDate startDate = LocalDate.of(year, 1, 1); // Ngày đầu tiên của năm nhập vào
        LocalDate endDate = LocalDate.of(year+1, 1, 31);   // Ngày đầu tiên của năm sau năm nhập vào

        // System.out.println(startDate);
        // Truy vấn MongoDB để lấy các tài liệu có trường 'ngayThang' nằm trong năm nhập vào

        Map<Integer, Map<String,Integer> > res = new HashMap<>();
        if (data.getTinh()==""){
            List<GiaHanTamTru> giaHanTamTrus = mongoTemplate.find(
                
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                GiaHanTamTru.class
            );
            // System.out.println("data*******************"+giaHanTamTrus);
            List<KhaiBaoTamTru> khaiBaoTamTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoTamTru.class
            );
            List<KhaiBaoTamVang> khaiBaoTamVangs = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoTamVang.class
            );
            List<KhaiBaoThuongTru> khaiBaoThuongTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoThuongTru.class
            );
            List<ThongBaoLuuTru> thongBaoLuuTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                ThongBaoLuuTru.class
            );
            List<XoaDangKyTamTru> xoaDangKyTamTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                XoaDangKyTamTru.class
            );
            List<XoaDangKyThuongTru> xoaDangKyThuongTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                XoaDangKyThuongTru.class
            );
            
            for (GiaHanTamTru giaHanTamTru : giaHanTamTrus) {
                
                int thang = giaHanTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(giaHanTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(giaHanTamTru.getCreated_at().getMonthValue());
                if (temp.get(giaHanTamTru.getTrangThai())==null) temp.put(giaHanTamTru.getTrangThai(), 1);
                else temp.put(giaHanTamTru.getTrangThai(), temp.get(giaHanTamTru.getTrangThai())+1);
                res.put(giaHanTamTru.getCreated_at().getMonthValue(), temp);
            }
            for (KhaiBaoTamTru khaiBaoTamTru : khaiBaoTamTrus) {
                int thang = khaiBaoTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoTamTru.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoTamTru.getTrangThai())==null) temp.put(khaiBaoTamTru.getTrangThai(), 1);
                else temp.put(khaiBaoTamTru.getTrangThai(), temp.get(khaiBaoTamTru.getTrangThai())+1);
                res.put(khaiBaoTamTru.getCreated_at().getMonthValue(), temp);
            }
            for (KhaiBaoTamVang khaiBaoTamVang : khaiBaoTamVangs) {
                int thang = khaiBaoTamVang.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoTamVang.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoTamVang.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoTamVang.getTrangThai())==null) temp.put(khaiBaoTamVang.getTrangThai(), 1);
                else temp.put(khaiBaoTamVang.getTrangThai(), temp.get(khaiBaoTamVang.getTrangThai())+1);
                res.put(khaiBaoTamVang.getCreated_at().getMonthValue(), temp);
            }
            for (KhaiBaoThuongTru khaiBaoThuongTru : khaiBaoThuongTrus) {
                int thang = khaiBaoThuongTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoThuongTru.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoThuongTru.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoThuongTru.getTrangThai())==null) temp.put(khaiBaoThuongTru.getTrangThai(), 1);
                else temp.put(khaiBaoThuongTru.getTrangThai(), temp.get(khaiBaoThuongTru.getTrangThai())+1);
                res.put(khaiBaoThuongTru.getCreated_at().getMonthValue(), temp);
            }
            for (ThongBaoLuuTru thongBaoLuuTru : thongBaoLuuTrus) {
                int thang = thongBaoLuuTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(thongBaoLuuTru.getCreated_at().getMonthValue())!=null) temp = res.get(thongBaoLuuTru.getCreated_at().getMonthValue());
                if (temp.get(thongBaoLuuTru.getTrangThai())==null) temp.put(thongBaoLuuTru.getTrangThai(), 1);
                else temp.put(thongBaoLuuTru.getTrangThai(), temp.get(thongBaoLuuTru.getTrangThai())+1);
                res.put(thongBaoLuuTru.getCreated_at().getMonthValue(), temp);
            }
            for (XoaDangKyTamTru xoaDangKyTamTru : xoaDangKyTamTrus) {
                int thang = xoaDangKyTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(xoaDangKyTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(xoaDangKyTamTru.getCreated_at().getMonthValue());
                if (temp.get(xoaDangKyTamTru.getTrangThai())==null) temp.put(xoaDangKyTamTru.getTrangThai(), 1);
                else temp.put(xoaDangKyTamTru.getTrangThai(), temp.get(xoaDangKyTamTru.getTrangThai())+1);
                res.put(xoaDangKyTamTru.getCreated_at().getMonthValue(), temp);
            }
            for (XoaDangKyThuongTru xoaDangKyThuongTru : xoaDangKyThuongTrus) {
                int thang = xoaDangKyThuongTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(xoaDangKyThuongTru.getCreated_at().getMonthValue())!=null) temp = res.get(xoaDangKyThuongTru.getCreated_at().getMonthValue());
                if (temp.get(xoaDangKyThuongTru.getTrangThai())==null) temp.put(xoaDangKyThuongTru.getTrangThai(), 1);
                else temp.put(xoaDangKyThuongTru.getTrangThai(), temp.get(xoaDangKyThuongTru.getTrangThai())+1);
                res.put(xoaDangKyThuongTru.getCreated_at().getMonthValue(), temp);
            }
        }
        else{
            // System.out.println("Chạy");
            List<GiaHanTamTru> giaHanTamTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                GiaHanTamTru.class
            );
            // System.out.println("data*******************"+giaHanTamTrus);
            List<KhaiBaoTamTru> khaiBaoTamTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoTamTru.class
            );
            List<KhaiBaoTamVang> khaiBaoTamVangs = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoTamVang.class
            );
            List<KhaiBaoThuongTru> khaiBaoThuongTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                KhaiBaoThuongTru.class
            );
            List<ThongBaoLuuTru> thongBaoLuuTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                ThongBaoLuuTru.class
            );
            List<XoaDangKyTamTru> xoaDangKyTamTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                XoaDangKyTamTru.class
            );
            List<XoaDangKyThuongTru> xoaDangKyThuongTrus = mongoTemplate.find(
                Query.query(Criteria.where("created_at").gte(startDate).lt(endDate)),
                XoaDangKyThuongTru.class
            );
            
            for (GiaHanTamTru giaHanTamTru : giaHanTamTrus) {
                if (giaHanTamTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = giaHanTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(giaHanTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(giaHanTamTru.getCreated_at().getMonthValue());
                if (temp.get(giaHanTamTru.getTrangThai())==null) temp.put(giaHanTamTru.getTrangThai(), 1);
                else temp.put(giaHanTamTru.getTrangThai(), temp.get(giaHanTamTru.getTrangThai())+1);
                res.put(giaHanTamTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (KhaiBaoTamTru khaiBaoTamTru : khaiBaoTamTrus) {
                if (khaiBaoTamTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = khaiBaoTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoTamTru.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoTamTru.getTrangThai())==null) temp.put(khaiBaoTamTru.getTrangThai(), 1);
                else temp.put(khaiBaoTamTru.getTrangThai(), temp.get(khaiBaoTamTru.getTrangThai())+1);
                res.put(khaiBaoTamTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (KhaiBaoTamVang khaiBaoTamVang : khaiBaoTamVangs) {
                if (khaiBaoTamVang.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = khaiBaoTamVang.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoTamVang.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoTamVang.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoTamVang.getTrangThai())==null) temp.put(khaiBaoTamVang.getTrangThai(), 1);
                else temp.put(khaiBaoTamVang.getTrangThai(), temp.get(khaiBaoTamVang.getTrangThai())+1);
                res.put(khaiBaoTamVang.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (KhaiBaoThuongTru khaiBaoThuongTru : khaiBaoThuongTrus) {
                if (khaiBaoThuongTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = khaiBaoThuongTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(khaiBaoThuongTru.getCreated_at().getMonthValue())!=null) temp = res.get(khaiBaoThuongTru.getCreated_at().getMonthValue());
                if (temp.get(khaiBaoThuongTru.getTrangThai())==null) temp.put(khaiBaoThuongTru.getTrangThai(), 1);
                else temp.put(khaiBaoThuongTru.getTrangThai(), temp.get(khaiBaoThuongTru.getTrangThai())+1);
                res.put(khaiBaoThuongTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (ThongBaoLuuTru thongBaoLuuTru : thongBaoLuuTrus) {
                if (thongBaoLuuTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = thongBaoLuuTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(thongBaoLuuTru.getCreated_at().getMonthValue())!=null) temp = res.get(thongBaoLuuTru.getCreated_at().getMonthValue());
                if (temp.get(thongBaoLuuTru.getTrangThai())==null) temp.put(thongBaoLuuTru.getTrangThai(), 1);
                else temp.put(thongBaoLuuTru.getTrangThai(), temp.get(thongBaoLuuTru.getTrangThai())+1);
                res.put(thongBaoLuuTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (XoaDangKyTamTru xoaDangKyTamTru : xoaDangKyTamTrus) {
                if (xoaDangKyTamTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = xoaDangKyTamTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(xoaDangKyTamTru.getCreated_at().getMonthValue())!=null) temp = res.get(xoaDangKyTamTru.getCreated_at().getMonthValue());
                if (temp.get(xoaDangKyTamTru.getTrangThai())==null) temp.put(xoaDangKyTamTru.getTrangThai(), 1);
                else temp.put(xoaDangKyTamTru.getTrangThai(), temp.get(xoaDangKyTamTru.getTrangThai())+1);
                res.put(xoaDangKyTamTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
            for (XoaDangKyThuongTru xoaDangKyThuongTru : xoaDangKyThuongTrus) {
                if (xoaDangKyThuongTru.getCoQuanThucHien().getTinh().equals(data.getTinh())){
                    int thang = xoaDangKyThuongTru.getCreated_at().getMonthValue();
                Map<String,Integer> temp = new HashMap<>();
                if (res.get(xoaDangKyThuongTru.getCreated_at().getMonthValue())!=null) temp = res.get(xoaDangKyThuongTru.getCreated_at().getMonthValue());
                if (temp.get(xoaDangKyThuongTru.getTrangThai())==null) temp.put(xoaDangKyThuongTru.getTrangThai(), 1);
                else temp.put(xoaDangKyThuongTru.getTrangThai(), temp.get(xoaDangKyThuongTru.getTrangThai())+1);
                res.put(xoaDangKyThuongTru.getCreated_at().getMonthValue(), temp);
                }
                
            }
        }
        // List<QuanLyHoSoUser> documents = mongoTemplate.find(
        //     Query.query(Criteria.where("ngayThang").gte(startDate).lt(endDate)),
        //     QuanLyHoSoUser.class
        // );

        return res;
    }
}
