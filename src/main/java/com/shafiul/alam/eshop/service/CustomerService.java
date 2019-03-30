package com.shafiul.alam.eshop.service;

import com.shafiul.alam.eshop.model.Customer;
import com.shafiul.alam.eshop.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void buyProduct(Product product){
        customer.addBuyingHistory(product);
        customer.setBalance(customer.getBalance() - product.getPrice());

    }
}
