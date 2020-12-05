package com.shafiul.alam.eshop.controller;

import com.shafiul.alam.eshop.model.Product;
import com.shafiul.alam.eshop.service.CrudService.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private ProductCrudService productCrudService;

    @Autowired
    public ProductController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts(Model model){
        List<Product> products = new ArrayList<Product>();
        productCrudService.findAll().forEach(product -> products.add(product));
        return products;
    }
}
