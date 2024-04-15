package com.finalproject.dm.Filter.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Filter.Model.FormFilterUser;
import com.finalproject.dm.Model.User;

public interface FilterUserRepo extends MongoRepository<FormFilterUser,String>{

    
    // List<User> getAllUserByData(FormFilterUser data);

}
