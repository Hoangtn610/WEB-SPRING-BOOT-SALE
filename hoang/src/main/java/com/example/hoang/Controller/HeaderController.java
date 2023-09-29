package com.example.hoang.Controller;

import com.example.hoang.Service.CreateToCheckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {
    @Autowired
    public CreateToCheckEntity ck;
    @GetMapping("/homePage")
    public String showHomePage(){
        //ck.check();
        return "Page/homePage";
    }

    @GetMapping("/product")
    public String showProduct(){
        return "Page/product";
    }
    @GetMapping("/aboutUS")
    public String showAboutUsPape(){
        return "Page/aboutUsPage";
    }
}
