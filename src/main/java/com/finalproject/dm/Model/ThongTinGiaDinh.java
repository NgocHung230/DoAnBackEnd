package com.finalproject.dm.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThongTinGiaDinh {

    @Id
    private String id;
    private String tenChuHo;
    private String TV1;
    private String nsTV1;
    private String TV2;
    private String nsTV2;
    private String TV3;
    private String nsTV3;
    private String TV4;
    private String nsTV4;
    private String TV5;
    private String nsTV5;
    private String TV6;
    private String nsTV6;
    private String TV7;
    private String nsTV7;
    private String TV8;
    private String nsTV8;
    private String TV9;
    private String nsTV9;
    private String TV10;
    private String nsTV10;

}
