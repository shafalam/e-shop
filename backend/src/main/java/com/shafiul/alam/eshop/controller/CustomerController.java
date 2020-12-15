package com.shafiul.alam.eshop.controller;

import com.shafiul.alam.eshop.model.Customer;
import com.shafiul.alam.eshop.model.Product;
import com.shafiul.alam.eshop.service.CrudService.CustomerCrudService;
import com.shafiul.alam.eshop.service.CrudService.ProductCrudService;
import com.shafiul.alam.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    private CustomerCrudService customerCrudService;
    private ProductCrudService productCrudService;
    private CustomerService customerService;

    private Customer customer;

    @Autowired
    public CustomerController(CustomerCrudService customerCrudService, ProductCrudService productCrudService,
            CustomerService customerService) {
        this.customerCrudService = customerCrudService;
        this.productCrudService = productCrudService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public Customer getSign(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email + " " + password);
        findAndMatch(email, password);
        return this.customer;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public Customer addUser(@RequestBody Customer customer) {
        this.customer = customer;
        System.out.println(customer.getName());
        return customerCrudService.save(customer);
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public Customer buyProducts(HttpServletRequest request) {
        Long productId = Long.parseLong(request.getParameter("product_id"));
        Long customerId = Long.parseLong(request.getParameter("customer_id"));
        Customer customer = customerCrudService.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("invalid id: " + customerId));
        Product product = productCrudService.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("invalid product: " + productId));
        System.out.println("Customer's name: " + customer.getName());
        System.out.println("Product's name: " + product.getName());
        customerService.setCustomer(customer);
        customerService.buyProduct(product);

        customerCrudService.save(customer);
        return customer;
    }

    private boolean findAndMatch(String email, String password) {
        Iterator<Customer> iterator = customerCrudService.findAll().iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getEmail().equals(email)) {
                if (customer.getPassword().equals(password)) {
                    System.out.println("Sign In");
                    this.customer = customer;
                    return true;
                }
            }
        }
        System.out.println("Couldn't sign in");
        return false;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
