package com.finalproject.dm.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ThongKeDoanhThu {

    @Id
    private String id;
    private BigDecimal doanhThu;
    private int nam;
    private int thang;
    private DiaChi diaChiCoQuan;
}
