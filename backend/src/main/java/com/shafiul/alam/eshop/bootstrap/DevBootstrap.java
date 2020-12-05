package com.shafiul.alam.eshop.bootstrap;

import com.shafiul.alam.eshop.model.Product;
import com.shafiul.alam.eshop.service.CrudService.CustomerCrudService;
import com.shafiul.alam.eshop.service.CrudService.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProductCrudService productCrudService;
    private CustomerCrudService customerCrudService;

    @Autowired
    public DevBootstrap(ProductCrudService productCrudService, CustomerCrudService customerCrudService) {
        this.productCrudService = productCrudService;
        this.customerCrudService = customerCrudService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        init();
    }

    public void init(){
        Product p1 = new Product("Phone", "Android Phone", 12000);
        Product p2 = new Product("Keyboard", "Logitech Wireless keyboard", 1200);
        Product p3 = new Product("Laptop", "HP 4440s", 55000);
        Product p4 = new Product("HDD", "External 750GB HDD", 4000);

        productCrudService.save(p1);
        productCrudService.save(p2);
        productCrudService.save(p3);
        productCrudService.save(p4);
    }
}
