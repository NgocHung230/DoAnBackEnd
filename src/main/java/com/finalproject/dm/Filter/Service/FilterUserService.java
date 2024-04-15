package com.finalproject.dm.Filter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Filter.Model.FormFilterUser;
import com.finalproject.dm.Filter.Repository.FilterUserRepo;
import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.UserRepo;

@Service    
public class FilterUserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FilterUserRepo filterRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> searchUsers(FormFilterUser data) {
        Query query = new Query();
        if (data.getFilterText()=="" && data.getFilterRole()=="" && data.getFilterTinhTrangTK()!="")
            query.addCriteria(
                new Criteria().andOperator(
                    Criteria.where("tinhTrangTK").is(data.getFilterTinhTrangTK())
                )
            );
        if (data.getFilterText()=="" && data.getFilterRole()!="" && data.getFilterTinhTrangTK()=="")
        query.addCriteria(
            new Criteria().andOperator(
                Criteria.where("role").is(data.getFilterRole())
                
                )
            );
        if (data.getFilterText()!="" && data.getFilterRole()=="" && data.getFilterTinhTrangTK()=="")
        query.addCriteria(
            new Criteria().andOperator(
                new Criteria().orOperator(
                    Criteria.where("hoTen").regex(data.getFilterText(), "i"),
                    Criteria.where("cccd").regex(data.getFilterText(), "i"),
                    Criteria.where("email").regex(data.getFilterText(), "i")
                )
            )
        );
        if (data.getFilterText()!="" && data.getFilterRole()=="" && data.getFilterTinhTrangTK()!="")
        query.addCriteria(
            new Criteria().andOperator(
                Criteria.where("tinhTrangTK").is(data.getFilterTinhTrangTK()),
                new Criteria().orOperator(
                    Criteria.where("hoTen").regex(data.getFilterText(), "i"),
                    Criteria.where("cccd").regex(data.getFilterText(), "i"),
                    Criteria.where("email").regex(data.getFilterText(), "i")
                )
            )
        );
        if (data.getFilterText()!="" && data.getFilterRole()!="" && data.getFilterTinhTrangTK()=="")
        query.addCriteria(
            new Criteria().andOperator(
                Criteria.where("role").is(data.getFilterRole()),
                new Criteria().orOperator(
                    Criteria.where("hoTen").regex(data.getFilterText(), "i"),
                    Criteria.where("cccd").regex(data.getFilterText(), "i"),
                    Criteria.where("email").regex(data.getFilterText(), "i")
                )
            )
        );
        if (data.getFilterText()=="" && data.getFilterRole()!="" && data.getFilterTinhTrangTK()!="")
        query.addCriteria(
            new Criteria().andOperator(
                Criteria.where("role").is(data.getFilterRole()),
                Criteria.where("tinhTrangTK").is(data.getFilterTinhTrangTK())
            )
        );
        if (data.getFilterText()!="" && data.getFilterRole()!="" && data.getFilterTinhTrangTK()!="")
        query.addCriteria(
            new Criteria().andOperator(
                Criteria.where("role").is(data.getFilterRole()),
                Criteria.where("tinhTrangTK").is(data.getFilterTinhTrangTK()),
                new Criteria().orOperator(
                    Criteria.where("hoTen").regex(data.getFilterText(), "i"),
                    Criteria.where("cccd").regex(data.getFilterText(), "i"),
                    Criteria.where("email").regex(data.getFilterText(), "i")
                )
            )
        );
        
        return mongoTemplate.find(query, User.class);
    }
}
