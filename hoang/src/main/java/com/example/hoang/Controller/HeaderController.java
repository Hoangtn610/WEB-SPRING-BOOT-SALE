package com.example.hoang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {
    @GetMapping("/homePage")
    public String showHomePage(){
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
