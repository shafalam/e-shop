package com.shafiul.alam.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/home","/index"})
    public String getIndexPage(){
        return "index";
    }
}
