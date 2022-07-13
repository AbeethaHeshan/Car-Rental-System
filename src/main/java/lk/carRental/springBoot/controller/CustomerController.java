package lk.carRental.springBoot.controller;

import lk.carRental.springBoot.dto.OrderDTO;
import lk.carRental.springBoot.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController{


     @Autowired
     CustomerServiceImpl customerService;

       @PostMapping(path = "/post",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
       public  void registerCustomer(@RequestBody OrderDTO  orderDTO , @RequestParam("file") ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes){

             System.out.println("post workig");
       }

       @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
       public  void updateCustomer(@RequestBody OrderDTO  orderDTO , @RequestParam("file") ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes){

       }

       @DeleteMapping
       public  void deleteCustomer(String id){

       }

       @GetMapping(path = "verified")
       public void getCustomerIsVerified(String id){

       }

       @GetMapping(path = "/")
       public String getAllCustomer(){
        return  "SuyyyySS";
       }

       @GetMapping(path = "/search")
       public void searchCustomer(String id){

       }






}
