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
public class HoiDap {

    @Id
    private String id;
    private String idUser;
    private String tenUser;
    private String noiDung;
    private String idNguoiPhanHoi;
    private String tenNguoiPhanHoi;
    private String phanHoi;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
