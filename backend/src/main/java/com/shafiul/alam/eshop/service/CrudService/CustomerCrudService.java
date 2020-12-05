package com.shafiul.alam.eshop.service.CrudService;

import com.shafiul.alam.eshop.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CustomerCrudService extends CrudRepository<Customer,Long> {

}
