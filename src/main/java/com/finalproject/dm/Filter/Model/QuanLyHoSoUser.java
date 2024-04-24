package com.finalproject.dm.Filter.Model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.finalproject.dm.Model.GiaHanTamTru;
import com.finalproject.dm.Model.KhaiBaoTamTru;
import com.finalproject.dm.Model.KhaiBaoTamVang;
import com.finalproject.dm.Model.KhaiBaoThuongTru;
import com.finalproject.dm.Model.ThongBaoLuuTru;
import com.finalproject.dm.Model.XoaDangKyTamTru;
import com.finalproject.dm.Model.XoaDangKyThuongTru;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class QuanLyHoSoUser {

    private List<GiaHanTamTru> giaHanTamTrus;
    private List<ThongBaoLuuTru> thongBaoLuuTrus;
    private List<XoaDangKyTamTru> xoaDangKyTamTrus;
    private List<XoaDangKyThuongTru> xoaDangKyThuongTrus;
    private List<KhaiBaoTamVang> khaiBaoTamVangs;
    private List<KhaiBaoThuongTru> khaiBaoThuongTrus;
    private List<KhaiBaoTamTru> khaiBaoTamTrus;
}
