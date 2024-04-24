package com.finalproject.dm.Filter.Service;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.User;
import com.finalproject.dm.Repository.UserRepo;

@Service
public class ThongKeUserSerivce {

    @Autowired
    private UserRepo userRepo;

    private List<String> provinces = Arrays.asList(
        "Thành phố Hà Nội", "Thành phố Hồ Chí Minh", "Thành phố Hải Phòng","Tỉnh Hưng Yên", "Thành phố Đà Nẵng", "Thành phố Cần Thơ", 
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

    public Map<String, Map<String, Integer>> ThongKeUserGiamDan(){

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
        Map<String, Map<String, Integer>> data2= new LinkedHashMap<>();
        while (data.size()!=0){
            Integer t=-1;
            String tmpKey ="";
            Map<String, Integer> tmpVL = new HashMap<String,Integer>();
            for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
                if (entry.getValue().get("Tổng")>t){
                    tmpKey = entry.getKey();
                    tmpVL = entry.getValue();
                    t=entry.getValue().get("Tổng");
                }
            }
            data2.put(tmpKey, tmpVL);
            data.remove(tmpKey);
        }
        

        return data2;
    }

    public Map<String, Map<String, Integer>> ThongKeUserTangDan(){

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
        Map<String, Map<String, Integer>> data2= new LinkedHashMap<>();
        while (data.size()!=0){
            Integer t=Integer.MAX_VALUE;
            String tmpKey ="";
            Map<String, Integer> tmpVL = new HashMap<String,Integer>();
            for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
                if (entry.getValue().get("Tổng")<=t){
                    tmpKey = entry.getKey();
                    tmpVL = entry.getValue();
                    t=entry.getValue().get("Tổng");
                }
            }
            data2.put(tmpKey, tmpVL);
            data.remove(tmpKey);
        }
        

        return data2;
    }

    // Hàm loại bỏ các ký tự tiếng việt có dấu
    private String removeAccents(String input) {
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d").replaceAll("Đ", "D");
    }
    
    public Map<String, Map<String, Integer>> TimKiemTinhThongKe(String filter){

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
        Map<String, Map<String, Integer>> res = new LinkedHashMap<>();
        String input = removeAccents(filter).toLowerCase();
        for (Map.Entry<String, Map<String, Integer>> entry : data.entrySet()) {
            String tinh = removeAccents(entry.getKey()).toLowerCase();
            // System.out.println(tinh+" "+ input);
            if (tinh.contains(input)) res.put(entry.getKey(), entry.getValue());
        }
        
        return res;
    }

    public Map<String, Map<String, Integer>> thongKeUserHuyen(String tinh){
        // System.out.println(tinh);
        Map<String, Map<String, Integer>> data = new LinkedHashMap<>();
        List<User> userL = userRepo.findAll();
        for (User user : userL) {
            if (user.getDiaChiDKTK().getTinh().equals(tinh))
            if (user.getDiaChiDKTK() != null && user.getRole() != null) {
                String district = user.getDiaChiDKTK().getHuyen();
                Map<String, Integer> temp = data.get(district);
        
                // Kiểm tra xem temp có tồn tại không
                if (temp == null) {
                    temp = new HashMap<>();
                    temp.put("Tổng", 1);
                    data.put(district, temp);
                } else {
                    // Tăng giá trị "Tổng" lên 1
                    Integer totalCount = temp.get("Tổng");
                    temp.put("Tổng", totalCount == null ? 1 : totalCount + 1);
                }
        
                // Tăng giá trị của vai trò (role) của user lên 1
                Integer roleCount = temp.get(user.getRole());
                temp.put(user.getRole(), roleCount == null ? 1 : roleCount + 1);
        
                // Cập nhật lại temp vào data
                data.put(district, temp);
            }
        }

        return data;
    }

    public Map<String, Map<String, Integer>> thongKeUserXa(String tinh, String huyen){
        // System.out.println(tinh);
        Map<String, Map<String, Integer>> data = new LinkedHashMap<>();
        List<User> userL = userRepo.findAll();
        for (User user : userL) {
            if (user.getDiaChiDKTK().getTinh().equals(tinh)&&user.getDiaChiDKTK().getHuyen().equals(huyen))
            if (user.getDiaChiDKTK() != null && user.getRole() != null) {
                String ward = user.getDiaChiDKTK().getXa();
                Map<String, Integer> temp = data.get(ward);
        
                // Kiểm tra xem temp có tồn tại không
                if (temp == null) {
                    temp = new HashMap<>();
                    temp.put("Tổng", 1);
                    data.put(ward, temp);
                } else {
                    // Tăng giá trị "Tổng" lên 1
                    Integer totalCount = temp.get("Tổng");
                    temp.put("Tổng", totalCount == null ? 1 : totalCount + 1);
                }
        
                // Tăng giá trị của vai trò (role) của user lên 1
                Integer roleCount = temp.get(user.getRole());
                temp.put(user.getRole(), roleCount == null ? 1 : roleCount + 1);
        
                // Cập nhật lại temp vào data
                data.put(ward, temp);
            }
        }

        return data;
    }
}
