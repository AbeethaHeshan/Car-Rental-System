package lk.carRental.springBoot.controller;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.CustomerRAWDataDTO;
import lk.carRental.springBoot.dto.OrderDTO;
import lk.carRental.springBoot.service.CustomerService;
import lk.carRental.springBoot.service.fileStoreService.StorageService;
import lk.carRental.springBoot.service.impl.CustomerServiceImpl;
import lk.carRental.springBoot.util.ResponseUtil;
import lk.carRental.springBoot.util.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController{


     @Autowired
     CustomerService customerService;

     @Autowired
     StorageService service;


     @Autowired
    StorageProperties properties;


       @ResponseStatus(HttpStatus.CREATED)
       @PostMapping(path = "/post",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
       public ResponseUtil registerCustomer(@RequestBody CustomerDTO customer) throws IOException {
            //if not ,  get image names and set to dto



           //set to service  file / db


           return new ResponseUtil(200,"Save",null);

       }


       @PostMapping("/post/photos")
       public  void registerPhotos(@RequestParam("id") String id , @RequestParam("idBack") MultipartFile idBack , @RequestParam("lisFront") MultipartFile lisFront , @RequestParam("lisBack") MultipartFile lisBack){

               System.out.println(id);
               service.store(service.createDirectory("Customer","2"),idBack,lisFront);


       }



       @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
       public  ResponseUtil updateCustomer(@RequestBody CustomerDTO customer , @RequestParam("file") ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes){
               return new ResponseUtil(200,"Update",customerService.update(customer));
       }

       @DeleteMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
       public  ResponseUtil deleteCustomer( @PathVariable String id){
             return new ResponseUtil(200,"Delete",customerService.delete(id));
       }

       @GetMapping(path = "verified" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil getCustomerIsVerified(String id){






            return new ResponseUtil(200,"getVerified/Not",customerService.IsVerified(id));

       }


       @GetMapping(path = "all" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil getAllCustomer() {


        return new ResponseUtil(200,"GetAll", customerService.getAll());
       }



       @GetMapping(path = "/search" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil searchCustomer(String id){
           return  new ResponseUtil(200,"Search",customerService.search(id));
       }


}
