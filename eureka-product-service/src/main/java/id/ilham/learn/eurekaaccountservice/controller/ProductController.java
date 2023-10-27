package id.ilham.learn.eurekaaccountservice.controller;


import id.ilham.learn.eurekaaccountservice.model.Product;
import id.ilham.learn.eurekaaccountservice.repository.ProductRepositories;
import id.ilham.learn.eurekaaccountservice.response.CommonResponse;
import id.ilham.learn.eurekaaccountservice.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient("/product")
public class ProductController {

    @Autowired
    ProductRepositories productRepositories;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @GetMapping(value = "cekapi")
    public CommonResponse<String> cekapi(){
        return commonResponseGenerator.successResponse("hello api", "Success");
    }

    @PostMapping(value = "addproduct")
    public CommonResponse<Product> addProduct(@RequestBody Product param){
        productRepositories.save(param);
        return commonResponseGenerator.successResponse(param, "success add new product ");
    }

    @GetMapping(value = "getallproduct")
    public CommonResponse<List<Product>> getAllProduct(){
        return commonResponseGenerator.successResponse(productRepositories.findAll(), "Success get all product");
    }

    @GetMapping(value = "getbyid")
    public CommonResponse<List<Product>> getByID(@RequestParam int id){
        return commonResponseGenerator.successResponse(productRepositories.findById(id).get(), "Success get by id");
    }

    @PutMapping(value = "updateproduct")
    public CommonResponse<Product> updateProduct(@RequestBody Product param){
        return commonResponseGenerator.successResponse(productRepositories.save(param), "success Update product id " + param.getId());
    }

    @DeleteMapping(value = "deleteproduct")
    public CommonResponse<List<Product>> deleteProduct(@RequestParam int id){
//        Human human = humanRepositories.findById(id).get();
        productRepositories.deleteById(id);
        List<Product> humanList = productRepositories.findAll();
        return commonResponseGenerator.successResponse(humanList, "Success delete product id ");
    }





}
