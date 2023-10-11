package com.example.hoang.Controller;

import com.example.hoang.DTO.BrandAndTypeDTO;
import com.example.hoang.Entity.Product;
import com.example.hoang.Service.CreateToCheckEntity;
import com.example.hoang.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showProduct(@RequestParam(name = "pdID", required = false) String productTypeID,@RequestParam(name = "bID", required = false) String brandID , Model model){
        //ck.check();
        List<BrandAndTypeDTO> branchAndTypesList = ps.getMenuProductPage();
        model.addAttribute("listProduct",branchAndTypesList);

        String productTitle = ps.showProductTittle(productTypeID,brandID);
        model.addAttribute("productTitle",productTitle);

        List<Product> requestProductList = new ArrayList<>();
        requestProductList = ps.showRequestProduct(productTypeID,brandID);

        model.addAttribute("displayProduct",requestProductList);

        return "Page/product";
    }
    @GetMapping("/aboutUS")
    public String showAboutUsPape(){
        return "Page/aboutUsPage";
    }
}
