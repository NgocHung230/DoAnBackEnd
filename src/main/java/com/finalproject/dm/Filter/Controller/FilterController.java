package com.finalproject.dm.Filter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.dm.Filter.Model.FormFilterUser;
import com.finalproject.dm.Filter.Service.FilterUserService;
import com.finalproject.dm.Model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class FilterController {

    @Autowired
    private FilterUserService filterUserService;
    
    @PostMapping("/FilterUser")
    public ResponseEntity<List<User>> filterUser(@RequestBody FormFilterUser data) {
        //TODO: process POST request
        
        return ResponseEntity.ok(filterUserService.searchUsers(data));
    }
    
}
