package com.example.hoang.Controller;

import com.example.hoang.DTO.BranchAndType;
import com.example.hoang.Service.CreateToCheckEntity;
import com.example.hoang.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HeaderController {
    @Autowired
    public CreateToCheckEntity ck;
    @Autowired
    public ProductService ps;
    @GetMapping("/homePage")
    public String showHomePage(){

        return "Page/homePage";
    }

    @GetMapping("/product")
    public String showProduct( Model model){
        //ck.check();
        List<BranchAndType> branchAndTypesList = ps.getMenuProductPage();
        model.addAttribute("listProduct",branchAndTypesList);
        return "Page/productTest";
    }
    @GetMapping("/aboutUS")
    public String showAboutUsPape(){
        return "Page/aboutUsPage";
    }
}
