package com.example.hoang.Service;

import com.example.hoang.DTO.LoginInfoDTO;
import com.example.hoang.DTO.SignUpDTO;
import com.example.hoang.Entity.Users;
import com.example.hoang.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class LoginService {
    @Autowired
    public UserRepository userRepository;
    public boolean checkLoginInfo(LoginInfoDTO logInf){
        if(logInf.getUserName().contains("123")&& logInf.getPassWord().contains("123")){
            return true;
        }
        return false;
    }
    public Integer checkServiceLogin(LoginInfoDTO logInf){
        if(logInf==null){
            return 1;
        } else if (logInf.getUserName().isEmpty() || logInf.getPassWord().isEmpty() ) {
            return 2;
        } else if ( userRepository.findByUserNameAndPasdsWord(logInf.getUserName(),logInf.getPassWord()) !=null
        && !userRepository.findByUserNameAndPasdsWord(logInf.getUserName(),logInf.getPassWord()).isEmpty()){
            return 3;
        } else {
            return 4;
        }
    }
    public String LoginEncode(LoginInfoDTO loginInf){
        //data da có trong db
        //1 check password
        //get salt tu db
        Users u1 = new Users();
        u1 = userRepository.findUsersByUserName(loginInf.getUserName());
        if(u1 == null){
            return "Error not found u";
        }
        String saltStr = u1.getSalt();
        //chuyen salt sang byte[]
        byte[] salt = Base64.getDecoder().decode(saltStr);
        //covert password sang hashcode vs salt co san
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(salt);
        byte[] hashedPassword = md.digest(loginInf.getPassWord().getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword)
            sb.append(String.format("%02x", b));
        System.out.println(sb);
        String sb1 = sb.toString();
        //check password dc hashed and salted vs passw dc luu o database
        if (sb1.compareTo(u1.getPasdsWord())==0){
            return "Success Pass";
        } else{
            return "Fail";
        }
    }

    public String Signup(SignUpDTO sudto){
        // trong data chua co j

        //logic
        // 1) check u ton tai chua -> neu ton tại throw
        if(userRepository.findUsersByUserName(sudto.getUserName()) != null){
            return "Error user already exist";
        }
        if(!sudto.getEmail().contains("@") ) {
            return "Error please input correct email";
        }
        // 2) Xử lý phan passwword
        //I)) Tạo salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        //II) Chuyen salt thanh String
        String saltStr = Base64.getEncoder().encodeToString(salt);
        ///III) hash password
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(salt);
        byte[] hashedPassword = md.digest(sudto.getPassWord().getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword)
            sb.append(String.format("%02x", b));
        System.out.println(sb);
        /// IV) Save password và salt vao database(tinh sau)
        Users u = new Users();
        u.setUserName(sudto.getUserName());
        u.setEmail(sudto.getEmail());
        u.setSalt(saltStr);
        u.setPasdsWord(sb.toString());
        u.setRoleID(BigInteger.valueOf(1));
        u.setStatus(1);
        u.setFullName(sudto.getFullName());
        userRepository.save(u);
//        return "pw: "+ sb +" salt: " + saltStr;
        return "Success check DB";
    }

}
