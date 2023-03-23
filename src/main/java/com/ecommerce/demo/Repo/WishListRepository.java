package com.ecommerce.demo.Repo;

import com.ecommerce.demo.model.User;
import com.ecommerce.demo.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Integer> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
