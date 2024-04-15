package com.finalproject.dm.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnhCCCD {

    @Id
    private String id;

    private String anhMat;
    private String anhMatTruoc;
    private String anhMatSau;

}
