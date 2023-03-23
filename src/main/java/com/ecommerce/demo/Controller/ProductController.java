package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Common.ApiResponse;
import com.ecommerce.demo.Repo.CategoryRepo;
import com.ecommerce.demo.Service.ProductService;
import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto)
    {
        Optional<Category>optionalCategory=categoryRepo.findById(productDto.getCategoryId());
        if(optionalCategory.isPresent()==false)
        {
            return new ResponseEntity<>(new ApiResponse(false,"Category Not Exist"), HttpStatus.BAD_REQUEST);
        }
            productService.createProduct(productDto,optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"Product Added"),HttpStatus.CREATED);

    }
    @GetMapping("/getList")
    public ResponseEntity<List<ProductDto>> getProduct()
    {
        List<ProductDto>productDtoList=productService.getAllProducts();
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }
    //create An Api to edit an Product
    @PostMapping("/update{product_id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("product_id") int productId,@RequestBody ProductDto productDto) throws Exception
    {
        Optional<Category>optionalCategory=categoryRepo.findById(productDto.getCategoryId());
        if(optionalCategory.isPresent()==false)
        {
            return new ResponseEntity<>(new ApiResponse(false,"Category Not Exist"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new ApiResponse(true,"Product Added"),HttpStatus.CREATED);
    }

}
