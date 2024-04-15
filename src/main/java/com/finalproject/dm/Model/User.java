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
public class User {

    @Id
    private String idUser;

    private String CCCD;
    private String matKhau;
    private String hoTen;
    private String email;
    private String sdt;
    private String role;
    private AnhCCCD anhCCCD;
    private String tinhTrangTK;
    private String idNguoiDuyet;
    private String created_at;
    private String updated_at;
    private String codeHashed;
    private String code;
    private DiaChi diaChiDKTK;




}
