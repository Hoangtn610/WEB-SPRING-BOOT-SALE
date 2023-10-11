package com.example.hoang.Controller;

import com.example.hoang.Entity.Product;
import com.example.hoang.Repository.Product.ProductRepository;
import com.example.hoang.Service.ProductService;
import com.example.hoang.Utils.CommonFuntion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private ProductService pds;
    @Autowired
    private ProductRepository pdr;
    @GetMapping("/product/{id}")
    public String showSingleProductView(@PathVariable String id , Model model){
        Product eachpd = new Product();
        eachpd = pdr.findProductsByProductID(CommonFuntion.convertToLong(id));
        model.addAttribute("eachProduct",eachpd);
        return "Page/singleProduct";
    }
}
