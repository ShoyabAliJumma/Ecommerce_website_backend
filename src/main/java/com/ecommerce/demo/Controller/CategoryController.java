package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Common.ApiResponse;
import com.ecommerce.demo.Service.CategoryService;
import com.ecommerce.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String  createCategory(@RequestBody Category category)
    {
       categoryService.createCategory(category);
       return "Success";

    }
    @GetMapping("/categoryList")
    public List<Category> categoryList()
    {
        return categoryService.categoryList();
    }



    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category category)
    {
        if(categoryService.getById(categoryId)==false)
        {
            return new ResponseEntity<>(new ApiResponse(false,"id not found"),HttpStatus.BAD_REQUEST);
        }
        categoryService.editCategory(categoryId,category);
        return new ResponseEntity<>(new ApiResponse(true,"updated SuccessFully"), HttpStatus.CREATED);
    }
}
