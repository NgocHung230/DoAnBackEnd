package com.finalproject.dm.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finalproject.dm.Model.DiaChi;
import com.finalproject.dm.Model.User;

public interface UserRepo extends MongoRepository<User,String> {

    @Query(value = "{'role': {$ne : ?0}}")
    List<User> findAllNotAdmin(String role,Sort sort);

    @Query("{ 'CCCD' : ?0 }")
    List<User> findByCCCD(String CCCD);

    @Query("{ 'email' : ?0 }")
    List<User> findByEmail(String email);

    // List<User> findAllUserRoleAdmin(String role);

    @Query("{ 'role' : ?0 }")
    List<User> findAllUserRole(String role);
    
    @Query("{ 'tinhTrangTK' : ?0 }")
    List<User> getChoPheDuyet(String tinhTrang);

    @Query("{ 'tinhTrangTK' : ?0 ,'diaChiDKTK' : ?1,'role':?2}")
    List<User> getChoPheDuyetDiaChi(String tinhTrangTK,DiaChi diaChiDKTK,String role);

    @Query("{ 'diaChiDKTK' : ?0 ,'role' : ?1}")
    List<User> findAllByDiaChiDKTK(DiaChi diaChiDKTK,String role);

    

}
