package com.finalproject.dm.Model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VanBanPhapLuat {

    @Id
    private String id;
    private String tenThuTuc;
    private String coQuanThucHien;
    private String cachThucThucHien;
    private String trinhTuThucHien;
    private String thoiHanGiaiQuyet;
    private BigDecimal lePhi;
    private String thanhPhanHoSo;
    private String yeuCauDieuKien;
    private String canCuPhapLy;
    private String ketQuaThucHien;
    private String idNguoiThayDoi;
    private String created_at;
    private String updated_at;

    

}
