package com.shafiul.alam.eshop.service.CrudService;

import com.shafiul.alam.eshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudService extends CrudRepository<Product,Long> {
}
