package com.ecommerce.demo.Repo;

import com.ecommerce.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
