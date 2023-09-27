package com.example.hoang.Controller;

import com.example.hoang.DTO.LoginInfo;
import com.example.hoang.Entity.Users;
import com.example.hoang.Repository.UserRepository;
import com.example.hoang.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    public LoginService loginService;

    @GetMapping("/index")
    public String showLoginPage( Model model) {
        model.addAttribute("loginInfo", new LoginInfo(null, null));
//        List<Users> usersList = new ArrayList<>();
//        usersList = userRepository.findAllByName("hoang");
        return "index";
    }
    @PostMapping("/index")
    public String checkPassword(@ModelAttribute("loginInfo") LoginInfo logInf,Model model){
        model.addAttribute("messageLogin",null);
    switch (loginService.checkServiceLogin(logInf)){
        case 1:
            model.addAttribute("messageLogin","Please fill");
            break;
        case 2:
            model.addAttribute("messageLogin","Please fill");
            break;
        case 3:
            break;
        case 4:
            model.addAttribute("messageLogin","Your u or p is fail");
            break;
    }
       if(loginService.checkServiceLogin(logInf) ==3){
           return "Page/homePage";
       }
        return "index";
    }
    @GetMapping("/index/register")
    public String showRegisterPage() {
        //model.addAttribute("loginInfo", new LoginInfo(null, null));
//        loginService.hoang();
        return "registerForm";
    }
}
