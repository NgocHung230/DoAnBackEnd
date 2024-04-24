package com.finalproject.dm.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class DanhGiaHoSo {

    @Id
    private String id;
    private String idUser;
    private String idHoSo;
    private String tenThuTuc;
    private int mucDoDanhGia;
    private DiaChi coQuanThucHien;
    private String noiDung;
    private LocalDateTime created_at;
}
