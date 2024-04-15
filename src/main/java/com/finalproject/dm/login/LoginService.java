package com.finalproject.dm.login;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.finalproject.dm.Model.User;
import com.finalproject.dm.Service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Service
public class LoginService {

    @Autowired
    private UserService userService;
    
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String idUser, String hoTen, String role) {
        // Thời gian hết hạn của token
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
    
        // Tạo secret key với độ dài an toàn
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        // System.out.println(secretKey);
    
        return Jwts.builder()
                .setSubject(idUser) // Trường subject của token
                .claim("hoTen", hoTen) // Thêm một trường dữ liệu tùy chỉnh vào token
                .claim("role", role)   // Thêm một trường dữ liệu tùy chỉnh khác vào token
                .setExpiration(expirationDate) // Thiết lập thời gian hết hạn của token
                .signWith(secretKey) // Ký token bằng secret key
                .compact();
    }


    public String checkAcount(String cccd, String matKhau)
    {
        List<User> L = userService.getUserByCCCD(cccd);
        if (L.size()==0) return "Tài khoản chưa đăng ký!";
        // System.out.println(user.getIdUser());
        // System.out.println(matKhau);
        // System.out.println(hashedPassword);
        User user=L.get(0);
        if (!BCrypt.checkpw(matKhau, user.getMatKhau())) return "Mật khẩu không đúng!";
        if (user.getTinhTrangTK().equals("Locked")) return "Tài khoản đã bị khoá!";
        if (user.getTinhTrangTK().equals("Checking")) return "Tài khoản đang chờ nhân viên xác nhận!";
        System.out.println(user.getTinhTrangTK().equals("Active"));
        if (!user.getTinhTrangTK().equals("Active")) return "Login fail!";
        return "Login Success!";


    }

    public boolean isValidUser(String username, String password) {
        // Add your logic to validate the username and password, for example:
        // return userRepository.findByUsername(username)
        //         .map(user -> passwordEncoder.matches(password, user.getPassword()))
        //         .orElse(false);
        return username.equals("admin") && password.equals("password");
    }

    public Map<String,String> getDataUserFromToken(String token) {
        // JSONObject data = new JSONObject();
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
        Map<String,String> data = new HashMap<>();
        data.put("idUser", claims.getSubject());
        data.put("hoTen",(String) claims.get("hoTen"));
        data.put("role",(String) claims.get("role"));
        return data;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        Claims claims = Jwts.parserBuilder()
                            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                            .build()
                            .parseClaimsJws(token)
                            .getBody();
    
        // Lấy thông tin từ token
        String idUser = claims.getSubject();
        String hoTen = claims.get("hoTen", String.class);
        String role = claims.get("role", String.class);
    
        // Cập nhật thời gian hết hạn mới cho token
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
    
        // Tạo lại token mới với thông tin cũ và thời gian hết hạn mới
        return Jwts.builder()
                    .setSubject(idUser)
                    .claim("hoTen", hoTen)
                    .claim("role", role)
                    .setExpiration(expirationDate)
                    .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .compact();
    }
}
