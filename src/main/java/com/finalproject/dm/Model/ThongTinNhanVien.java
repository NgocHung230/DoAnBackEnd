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
public class ThongTinNhanVien {

    @Id
    private String idTTNV;
    private String chucVu;
    private String hoTen;
    private String cccd;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private DiaChi coQuan;
    private String idUser;
    private String created_at;
    private String updated_at;


}
