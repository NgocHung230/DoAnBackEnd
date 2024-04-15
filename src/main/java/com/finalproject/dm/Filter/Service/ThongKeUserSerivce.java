package com.finalproject.dm.Filter.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.UserRepo;

@Service
public class ThongKeUserSerivce {

    @Autowired
    private UserRepo userRepo;

    private List<String> provinces = Arrays.asList(
        "Tỉnh Hà Nội", "Thành phố Hồ Chí Minh", "Thành phố Hải Phòng","Tỉnh Hưng Yên", "Thành phố Đà Nẵng", "Thành phố Cần Thơ", 
        "Tỉnh Hải Dương", "Tỉnh Bà Rịa - Vũng Tàu", "Tỉnh Vĩnh Phúc", "Tỉnh Thanh Hóa", "Tỉnh Nghệ An", 
        "Tỉnh Hà Tĩnh", "Tỉnh Quảng Ninh", "Tỉnh Nam Định", "Tỉnh Thái Bình", "Tỉnh Hải Dương", "Tỉnh Ninh Bình",
        "Tỉnh Hà Nam", "Tỉnh Thái Nguyên", "Tỉnh Lạng Sơn", "Tỉnh Bắc Giang", "Tỉnh Phú Thọ", "Tỉnh Bắc Ninh", 
        "Tỉnh Quảng Ninh", "Tỉnh Hà Giang", "Tỉnh Tuyên Quang", "Tỉnh Lào Cai", "Tỉnh Yên Bái", "Tỉnh Lai Châu",
        "Tỉnh Sơn La", "Tỉnh Điện Biên", "Tỉnh Hòa Bình", "Tỉnh Thanh Hóa", "Tỉnh Nghệ An", "Tỉnh Hà Tĩnh", 
        "Tỉnh Quảng Bình", "Tỉnh Quảng Trị", "Tỉnh Thừa Thiên Huế", "Tỉnh Quảng Nam", "Tỉnh Quảng Ngãi", 
        "Tỉnh Bình Định", "Tỉnh Phú Yên", "Tỉnh Khánh Hòa", "Tỉnh Ninh Thuận", "Tỉnh Bình Thuận", "Tỉnh Kon Tum",
        "Tỉnh Gia Lai", "Tỉnh Đắk Lắk", "Tỉnh Đắk Nông", "Tỉnh Lâm Đồng", "Tỉnh Bình Phước", "Tỉnh Tây Ninh",
        "Tỉnh Bình Dương", "Tỉnh Đồng Nai", "Tỉnh Bà Rịa - Vũng Tàu", "Tỉnh Long An", "Tỉnh Tiền Giang", 
        "Tỉnh Bến Tre", "Tỉnh Trà Vinh", "Tỉnh Vĩnh Long", "Tỉnh Đồng Tháp", "Tỉnh An Giang", "Tỉnh Kiên Giang"
    );
    
    public Map<String, Map<String, Integer>> ThongKeUser(){

        Map<String, Map<String, Integer>> data= new LinkedHashMap<>();
        // System.out.println(provinces.size());
        for (String key : provinces) {
            Map<String, Integer> tk = new LinkedHashMap<>();
            tk.put("Tổng", 0);
            tk.put("Manager", 0);
            tk.put("Employee", 0);
            tk.put("User", 0);
            data.put(key, tk);
        }
        // return data;
        List<User> userL = userRepo.findAll();
        // for (User user : userL) {
        //     if (user.getDiaChiDKTK()!=null&&user.getRole()!=null) {
        //         Map<String, Integer> temp = data.get(user.getDiaChiDKTK().getTinh());
        //         temp.put("Tổng", temp.get("Tổng")==null?1:temp.get("Tổng")+1);
        //         temp.put(user.getRole(), temp.get(user.getRole())+1);
        //         data.put(user.getDiaChiDKTK().getTinh(), temp);
        //     }
            
        // }
        for (User user : userL) {
            if (user.getDiaChiDKTK() != null && user.getRole() != null) {
                String province = user.getDiaChiDKTK().getTinh();
                Map<String, Integer> temp = data.get(province);
        
                // Kiểm tra xem temp có tồn tại không
                if (temp == null) {
                    temp = new HashMap<>();
                    temp.put("Tổng", 1);
                    data.put(province, temp);
                } else {
                    // Tăng giá trị "Tổng" lên 1
                    Integer totalCount = temp.get("Tổng");
                    temp.put("Tổng", totalCount == null ? 1 : totalCount + 1);
                }
        
                // Tăng giá trị của vai trò (role) của user lên 1
                Integer roleCount = temp.get(user.getRole());
                temp.put(user.getRole(), roleCount == null ? 1 : roleCount + 1);
        
                // Cập nhật lại temp vào data
                data.put(province, temp);
            }
        }
        return data;
    }
}
