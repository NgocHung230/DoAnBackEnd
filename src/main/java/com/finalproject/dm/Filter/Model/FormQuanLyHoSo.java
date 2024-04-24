package com.finalproject.dm.Filter.Model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class FormQuanLyHoSo {

    private String id;
    private String tenThuTuc;
    private LocalDateTime ngayTao;
    private String trangThai;
}
