package com.example.hoang.Service;

import com.example.hoang.DTO.LoginInfo;
import com.example.hoang.Entity.ProductPicture;
import com.example.hoang.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    public UserRepository userRepository;
    public boolean checkLoginInfo(LoginInfo logInf){
        if(logInf.getUserName().contains("123")&& logInf.getPassWord().contains("123")){
            return true;
        }
        return false;
    }
    public Integer checkServiceLogin(LoginInfo logInf){
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
//    @Autowired
//    public ProductRepo productRepo;

//    public void hoang(){
////        List<ProductPicture> proPic = productRepo.findAll();
////        System.out.println(proPic);
//
//    }

}
