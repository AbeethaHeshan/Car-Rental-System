package lk.carRental.springBoot.controller;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.OrderDTO;
import lk.carRental.springBoot.service.CustomerService;
import lk.carRental.springBoot.service.impl.CustomerServiceImpl;
import lk.carRental.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController{


     @Autowired
     CustomerService customerService;


       @ResponseStatus(HttpStatus.CREATED)
       @PostMapping(path = "/post",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
       public ResponseUtil registerCustomer(@RequestBody CustomerDTO customer , @RequestParam("file") ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes) throws IOException {
         byte[] bytes;
         int c = 0;
         for (MultipartFile file:files) {
            bytes = file.getBytes();
            switch (c){
              case 1:  customer.setNicFront(bytes);break;
              case 2:  customer.setNicBack(bytes);break;
              case 3:  customer.setLicenseFront(bytes);break;
              case 4:  customer.setLicenseBack(bytes);break;
              default:
                System.out.println("ex ++++");
            }
            c++;
         }

            customerService.save(customer);
            return new ResponseUtil(200,"Save",null);

       }


       @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
       public  ResponseUtil updateCustomer(@RequestBody CustomerDTO customer , @RequestParam("file") ArrayList<MultipartFile> files, RedirectAttributes redirectAttributes){
               return new ResponseUtil(200,"Update",customerService.update(customer));
       }

       @DeleteMapping(path = "/{id}")
       public  ResponseUtil deleteCustomer( @PathVariable String id){
             return new ResponseUtil(200,"Delete",customerService.delete(id));
       }

       @GetMapping(path = "verified")
       public ResponseUtil getCustomerIsVerified(String id){

            return new ResponseUtil(200,"getVerified/Not",customerService.IsVerified(id));

       }

       @GetMapping(path = "/")
       public ResponseUtil getAllCustomer() {
        return new ResponseUtil(200,"GetAll", customerService.getAll());
       }

       @GetMapping(path = "/search")
       public ResponseUtil searchCustomer(String id){
           return  new ResponseUtil(200,"Search",customerService.search(id));
       }






}
