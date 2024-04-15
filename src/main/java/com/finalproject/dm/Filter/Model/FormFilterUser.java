package com.finalproject.dm.Filter.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormFilterUser {

    @Id
    private String id;
    private String filterText;
    private String filterRole;
    private String filterTinhTrangTK;
}
