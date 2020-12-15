package com.shafiul.alam.eshop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String paymentMethod;
    private Integer balance;
    private String password;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Product> buyingHistory;

    public Customer(){
        this.buyingHistory = new ArrayList<Product>();
    }

    public Customer(String name, String email, String paymentMethod) {
        this.name = name;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.buyingHistory = new ArrayList<Product>();
    }

    public Customer(String name, String email, String paymentMethod, Integer balance, String password) {
        this.name = name;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.balance = balance;
        this.password = password;
        this.buyingHistory = new ArrayList<Product>();
    }

    public String toString(){
        return "id: " + id + " email: " + email + " products: " + buyingHistory.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Product> getBuyingHistory() {
        return this.buyingHistory;
    }

    public void setBuyingHistory(ArrayList<Product> buyingHistory) {
        this.buyingHistory = buyingHistory;
    }

    public void addBuyingHistory(Product product){
        this.buyingHistory.add(product);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
