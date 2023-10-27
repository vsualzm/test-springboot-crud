package id.ilham.learn.eurekaaccountservice.controller;


import id.ilham.learn.eurekaaccountservice.model.Account;
import id.ilham.learn.eurekaaccountservice.repository.AccountRepositories;
import id.ilham.learn.eurekaaccountservice.response.CommonResponse;
import id.ilham.learn.eurekaaccountservice.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountRepositories accountRepositories;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;


    @GetMapping(value = "cekapi")
    public CommonResponse<String> cekapi(){
        return commonResponseGenerator.successResponse("hello api", "Success");
    }

    @PostMapping(value = "addaccount")
    public CommonResponse<Account> addHuman(@RequestBody Account param){
        accountRepositories.save(param);
        return commonResponseGenerator.successResponse(param, "success add new Account ");
    }

    @GetMapping(value = "getallaccount")
    public CommonResponse<List<Account>> getAllCar(){
        return commonResponseGenerator.successResponse(accountRepositories.findAll(), "Success get all");
    }

    @GetMapping(value = "getbyid")
    public CommonResponse<List<Account>> getbyid(@RequestParam int id){
        return commonResponseGenerator.successResponse(accountRepositories.findById(id).get(), "Success get by id");
    }

    @PutMapping(value = "updateaccount")
    public CommonResponse<Account> updateHuman(@RequestBody Account param){
        return commonResponseGenerator.successResponse(accountRepositories.save(param), "success Update data id " + param.getId());
    }

    @DeleteMapping(value = "deleteaccount")
    public CommonResponse<List<Account>> delete(@RequestParam int id){
//        Human human = humanRepositories.findById(id).get();
        accountRepositories.deleteById(id);
        // menampilkan islist yg ada saja
        List<Account> humanList = accountRepositories.findAll();
        return commonResponseGenerator.successResponse(humanList, "Success delete id ");
    }





}
