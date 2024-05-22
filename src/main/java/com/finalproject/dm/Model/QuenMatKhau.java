package com.finalproject.dm.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class QuenMatKhau {

    private String idUser;
    private String oldPass;
    private String newPass;

}
