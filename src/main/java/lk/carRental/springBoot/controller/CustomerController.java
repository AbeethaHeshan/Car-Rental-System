package lk.carRental.springBoot.controller;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController{


    @Autowired
     CustomerServiceImpl customerService;


       public  void registerCustomer(){

       }

       public  void updateCustomer(){

       }

       public  void deleteCustomer(){

       }

       public void getCustomerIsVerified(){

       }

       public  void getAllCustomer(){

       }

       public void searchCustomer(){


       }






}
