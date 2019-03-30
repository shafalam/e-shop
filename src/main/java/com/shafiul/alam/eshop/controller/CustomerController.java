package com.shafiul.alam.eshop.controller;

import com.shafiul.alam.eshop.model.Customer;
import com.shafiul.alam.eshop.model.Product;
import com.shafiul.alam.eshop.service.CrudService.CustomerCrudService;
import com.shafiul.alam.eshop.service.CrudService.ProductCrudService;
import com.shafiul.alam.eshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Iterator;

@Controller
public class CustomerController {
      private CustomerCrudService customerCrudService;
      private ProductCrudService productCrudService;
      private CustomerService customerService;

      private Customer customer;

      @Autowired
      public CustomerController(CustomerCrudService customerCrudService, ProductCrudService productCrudService, CustomerService customerService) {
          this.customerCrudService = customerCrudService;
          this.productCrudService = productCrudService;
          this.customerService = customerService;
      }

      @RequestMapping("/signup")
      public String getSignUpForm(Customer customer){
          return "add-user";
      }

      @RequestMapping("/signin")
      public String getSign(HttpServletRequest request, Model model){
          String email = request.getParameter("email");
          String password = request.getParameter("password");
          System.out.println(email + " " + password);
          findAndMatch(email, password, model);
          return "sign-in";
      }

      @RequestMapping("/adduser")
      public String addUser(@Valid Customer customer, Model model){
          customerCrudService.save(customer);
          this.customer = customer;
          model.addAttribute("customer", customer);
          return "sign-in";
      }

      @RequestMapping("/buy/{id}")
      public String buyProducts(@PathVariable Long id, Model model){
          Product product = productCrudService.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id: " + id));
          System.out.println("Customer's name: " + customer.getName());
          System.out.println("Product's name: " + product.getName());

          customerService.setCustomer(customer);
          customerService.buyProduct(product);
          model.addAttribute("customer", customer);
          return "sign-in";
      }

      private boolean findAndMatch(String email, String password, Model model){
          //Iterable<Customer> iterable = customerCrudService.findAll();
          Iterator<Customer> iterator = customerCrudService.findAll().iterator();
          while(iterator.hasNext()){
              Customer customer = iterator.next();
              if(customer.getEmail().equals(email)){
                  if(customer.getPassword().equals(password)){
                      System.out.println("Sign In");
                      this.customer = customer;
                      model.addAttribute("customer", customer);
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

    //    @RequestMapping(value = "/customer", method = RequestMethod.GET)
//    public String helloCustomer(HttpServletRequest request, Model model){
//        String name = request.getParameter("name");
//
//        if (name == null || name == ""){
//            name = "World";
//        }
//
//        model.addAttribute("name",name);
//        return "hello";
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public String newCustomer(HttpServletRequest request, Model model){
//        String name = request.getParameter("name");
//        model.addAttribute("name",name);
//        return "hello";
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.GET)
//    public String newCustomer(){
//        return "new";
//    }
}
