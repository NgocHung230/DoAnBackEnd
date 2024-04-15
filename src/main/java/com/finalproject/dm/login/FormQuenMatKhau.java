package com.finalproject.dm.login;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormQuenMatKhau {

    @Id
    private String id;
    private String cccd;
    private String code;
    private String codeHashed;
    private String matKhauMoi;
}
