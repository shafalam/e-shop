package com.shafiul.alam.eshop.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;
    Product p1;
    Product p2;
    ArrayList<Product> products;
    @Before
    public void setUp() throws Exception {
        customer = new Customer();
        p1 = new Product();
        p2 = new Product();
        products = new ArrayList<Product>();
    }

    @Test
    public void getId() {
        Long idValue = 4L;
        customer.setId(idValue);
        assertEquals(idValue, customer.getId());
    }


    @Test
    public void getName() {
        String name = "Shafi";
        customer.setName(name);
        assertEquals(name, customer.getName());
    }


    @Test
    public void getEmail() {
        String email = "sha@gmail.com";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }


    @Test
    public void getPaymentMethod() {
        String paymentMethod = "Debit Card";
        customer.setPaymentMethod(paymentMethod);
        assertEquals(paymentMethod, customer.getPaymentMethod());
    }



    @Test
    public void getBalance() {
        Integer balance = 400;
        customer.setBalance(balance);
        assertEquals(customer.getBalance(), balance);
    }


    @Test
    public void getBuyingHistory() {
        products.add(p1);
        customer.setBuyingHistory(products);
        assertEquals(customer.getBuyingHistory(), products);
    }


    @Test
    public void addBuyingHistory() {
        products.add(p1);
        customer.setBuyingHistory(products);
        products.add(p2);
        customer.addBuyingHistory(p2);

        assertEquals(customer.getBuyingHistory(), products);
    }

    @Test
    public void getPassword() {
        String pass = "habijabi";
        customer.setPassword(pass);
        assertEquals(customer.getPassword(), pass);
    }

}
