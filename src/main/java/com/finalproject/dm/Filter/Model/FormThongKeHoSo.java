package com.finalproject.dm.Filter.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class FormThongKeHoSo {

    private int nam;
    private String tinh;
}
