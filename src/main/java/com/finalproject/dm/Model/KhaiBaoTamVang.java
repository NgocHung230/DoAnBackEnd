package com.finalproject.dm.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhaiBaoTamVang {

    @Id
    private String id;
    private String tenThuTuc;
    private DiaChi coQuanThucHien;
    private DiaChi diaChi;
    private String diaChiCuThe;
    private FileHoSo fileHoSoLienQuan;
    private String ngayVang;
    private String ngayVe;
    private String lyDoTamVang;
    private BigDecimal lePhi;
    private String idUser;
    private String trangThai;
    private String idNguoiDuyet;
    private String note;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
