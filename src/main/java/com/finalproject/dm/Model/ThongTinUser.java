package com.finalproject.dm.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinUser {

    @Id
    private String idTTUser;
    private String hoTen;
    private String cccd;
    private String ngaySinh;
    private String gioiTinh;
    private String quocTich;
    private String danToc;
    private String tonGiao;
    private DiaChi noiDKKhaiSinh;
    private DiaChi queQuan;
    private DiaChi thuongTru;
    private DiaChi tamTru;
    private String diaChiTTCuThe;
    private String thoiHanTamTru;
    private String noiOHienTai;
    private DiaChi noiKhaiBaoTamVang;
    private ThongTinGiaDinh TTGiaDinh;
    private String idUser;
    private String created_at;
    private String updated_at;
    
}
