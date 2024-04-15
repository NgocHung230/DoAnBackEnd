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
public class FileHoSo {

        @Id
        private String id;
        private String HS1;
        private String HS2;
        private String HS3;
        private String HS4;
        private String HS5;
        private String HS6;
        private String HS7;
        private String HS8;

}
