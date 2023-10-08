package com.example.hoang.Controller;

import com.example.hoang.DTO.LoginInfoDTO;
import com.example.hoang.DTO.SignUpDTO;
import com.example.hoang.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    public LoginService loginService;

    @GetMapping("/index")
    public ModelAndView  showLoginPage(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("loginInfo",new LoginInfoDTO(null, null));

        //model.addAttribute("loginInfo", new LoginInfo(null, null));
        return mav;
    }
    @PostMapping("/loginEncode")
    public String checkPassword(@ModelAttribute("loginInfo") LoginInfoDTO logInf, Model model, ModelAndView mav){
        model.addAttribute("messageLogin",null);
//    switch (loginService.checkServiceLogin(logInf)){
//        case 1:
//            model.addAttribute("messageLogin","Please fill");
//            break;
//        case 2:
//            model.addAttribute("messageLogin","Please fill");
//            break;
//        case 3:
//            break;
//        case 4:
//            model.addAttribute("messageLogin","Your u or p is fail");
//            break;
//    }
        String result = loginService.LoginEncode(logInf);
       if(result.contains("Success")){
           model.addAttribute("messageLogin","Pass");
           return "redirect:/homePage";
       }
        return "index";
    }
    @GetMapping("/index/register")
    public String showRegisterPage( Model model) {
        model.addAttribute("SignUpInfo", new SignUpDTO());
        return "registerForm";
    }
    @PostMapping("/Signup")
    public String Signup(@ModelAttribute("SignUpInfo") SignUpDTO signupDTO) {
        String rs = loginService.Signup(signupDTO);
        if (rs.contains("Error")){
            return "registerForm";
        } else{
            return "index";
        }
    }



}
