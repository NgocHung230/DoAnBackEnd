package com.finalproject.dm.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    public UserRepo repo;

    public String getTimeString()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        
        // Định dạng thời gian hiện tại theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss:mm:HH dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public User addUser(User user)
    {
        // System.out.println(user.toString());

        user.setIdUser(UUID.randomUUID().toString().split("-")[0]);
        String formattedTime = getTimeString();
        user.setCreated_at(formattedTime);
        user.setMatKhau(BCrypt.hashpw(user.getMatKhau(), BCrypt.gensalt()));
        user.setRole("User");
        user.setTinhTrangTK("Checking");
        return repo.save(user);
    }

    public List<User> findAllUser(){
        return repo.findAll();
    }

    public List<User> findAllUserNotAdmin(){
        Sort sort= Sort.by(Sort.Direction.ASC,"role");
        return repo.findAllNotAdmin("Admin",sort);
    }

    public User getUserByIDUser(String id){
        // System.out.println(repo.findById(id).get());
        return repo.findById(id).get();
    }


    public List<User> getUserByCCCD(String CCCD){
        return repo.findByCCCD(CCCD);
    }

    public List<User> getUserByEmail(String email){
        return repo.findByEmail(email);
    }
    public List<User> findAllUserRole(String role){
        return repo.findAllUserRole(role);
    }

    public User updateUser(User userRequest)
    {
        User user=repo.findById(userRequest.getIdUser()).get();
        user.setRole(userRequest.getRole());
        user.setTinhTrangTK(userRequest.getTinhTrangTK());
        user.setSdt(userRequest.getSdt());
        user.setUpdated_at(getTimeString());
        return repo.save(user);
    }

    public String deleteUser(String id)
    {
        repo.deleteById(id);
        return "Delete successfuly!";
    }

    public String pheDuyetUser(String idNguoiDuyet,String idUser)
    {
        User user=repo.findById(idUser).get();
        user.setTinhTrangTK("Active");
        user.setUpdated_at(getTimeString());
        user.setIdNguoiDuyet(idNguoiDuyet);
        repo.save(user);
        return "Phê duyệt thành công!";
    }

    public List<User> getUserChoPheDuyet()
    {
        return repo.getChoPheDuyet("Checking");

    }
    // public User updateTinhTrangTKUser(User user){
    //     User exitsUser = repo.findById(user.getIdUser()).get();
    //     exitsUser.setEmail(null);
    // }

    public User addManager(User user){
        user.setIdUser(UUID.randomUUID().toString().split("-")[0]);
        String formattedTime = getTimeString();
        user.setCreated_at(formattedTime);
        user.setMatKhau(BCrypt.hashpw(user.getMatKhau(), BCrypt.gensalt()));
        user.setRole("Manager");
        user.setTinhTrangTK("Active");
        return repo.save(user);
    }
}
