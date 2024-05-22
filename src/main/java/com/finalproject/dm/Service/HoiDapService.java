package com.finalproject.dm.Service;

import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.HoiDap;
import com.finalproject.dm.Repository.HoiDapRepo;

@Service
public class HoiDapService {

    @Autowired
    private HoiDapRepo hoiDapRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public HoiDap createHoiDap(HoiDap data){
        data.setId(UUID.randomUUID().toString().split("-")[0]);
        data.setCreated_at(LocalDateTime.now());
        return hoiDapRepo.save(data);
    }

    public HoiDap updateHoiDap(HoiDap data){
        if (data.getPhanHoi()==null||data.getPhanHoi()=="") return null;
        data.setUpdated_at(LocalDateTime.now());
        return hoiDapRepo.save(data);
    }

    public List<HoiDap> getAllHoiDap(){
        return hoiDapRepo.findAll();
    }

    public List<HoiDap> getAllHoiDapByIdUser(String idUser){
        return hoiDapRepo.findAllByIdUser(idUser);
    }

    public List<HoiDap> filterHoiDap(String filter) {
        // Chuyển filter thành chuỗi không phân biệt chữ hoa chữ thường
        String caseInsensitiveFilter = filter.toLowerCase();

        Criteria criteria = new Criteria().orOperator(
                Criteria.where("tenUser").regex(caseInsensitiveFilter, "i"),
                Criteria.where("tenNguoiPhanHoi").regex(caseInsensitiveFilter, "i")
        );
        Query query = new Query(criteria);
        return mongoTemplate.find(query, HoiDap.class);
    }
}
