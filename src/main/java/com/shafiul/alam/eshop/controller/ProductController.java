package com.shafiul.alam.eshop.controller;

import com.shafiul.alam.eshop.service.CrudService.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    private ProductCrudService productCrudService;

    @Autowired
    public ProductController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @RequestMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productCrudService.findAll() );
        return "products";
    }
}
