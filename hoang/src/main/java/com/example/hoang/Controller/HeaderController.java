package com.example.hoang.Controller;

import com.example.hoang.DTO.BranchAndTypeDTO;
import com.example.hoang.Service.CreateToCheckEntity;
import com.example.hoang.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showProduct(@RequestParam(name = "pdID", required = false) String productID,@RequestParam(name = "bID", required = false) String brandID , Model model){
        //ck.check();
        List<BranchAndTypeDTO> branchAndTypesList = ps.getMenuProductPage();
        model.addAttribute("listProduct",branchAndTypesList);

        ps.showRequestProduct(productID,brandID);
        model.addAttribute("displayProduct",null);
        model.addAttribute("ProductTitle",null);
        return "Page/product";
    }
    @GetMapping("/aboutUS")
    public String showAboutUsPape(){
        return "Page/aboutUsPage";
    }
}
