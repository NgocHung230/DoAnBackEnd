package com.finalproject.dm.Filter.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.finalproject.dm.Model.DiaChi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class FormThongKeHoSoCoQuan {

    private int nam;
    private DiaChi coQuan;
}
