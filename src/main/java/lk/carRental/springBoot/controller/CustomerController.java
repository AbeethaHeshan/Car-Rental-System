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
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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



       @GetMapping("/id")
       public ResponseUtil id(){

           return new ResponseUtil(200,"",customerService.getLastId());
       }



       //save cust
       @ResponseStatus(HttpStatus.CREATED)
       @PostMapping(path = "/post",consumes = MediaType.APPLICATION_JSON_VALUE , produces ={MediaType.APPLICATION_JSON_VALUE})
       public ResponseUtil registerCustomer(@RequestBody CustomerDTO customer) throws IOException {

           //set to service dbs

           customerService.saveDetails(customer);
           return new ResponseUtil(200,"Save",null);

       }

       // save photos
       @PostMapping("/post/photos")
       public  void registerPhotos(@RequestParam("id") String id , @RequestParam("idFront") MultipartFile idFront , @RequestParam("idBack") MultipartFile idBack , @RequestParam("lisFront") MultipartFile lisFront , @RequestParam("lisBack") MultipartFile lisBack){


               System.out.println(id);
               int i = Integer.parseInt(id);

               // id set to subDir name
               service.store(service.createDirectory("Customer",id),idFront,idBack,lisFront,lisBack);


               //save path
              String path = service.createDirectory("Customer", id);
           System.out.println(path);
               //save db
              customerService.updatePath(path,Integer.parseInt(id),idFront.getOriginalFilename(),idBack.getOriginalFilename(),lisFront.getOriginalFilename(),lisBack.getOriginalFilename());

              System.out.println("Done");

       }



       // update customer
       @PutMapping(path = "/update/customer",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
       public  ResponseUtil updateCustomer(@RequestBody CustomerDTO customer){

               return new ResponseUtil(200,"Update",customerService.update(customer));

       }




       @PutMapping(path = "/update/photos", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
       public  ResponseUtil  updatePhotos(@RequestParam("id") String id,@RequestParam("idFront") MultipartFile idFront  , @RequestParam("idBack") MultipartFile idBack , @RequestParam("lisFront") MultipartFile lisFront , @RequestParam("lisBack") MultipartFile lisBack) throws IOException {

           System.out.println(id);
           // get path
            String path = customerService.getPath(Integer.parseInt(id));
            CustomerDTO fileNames = customerService.getFileName(Integer.parseInt(id));
           //delete current

           String licenseFrontFileName = fileNames.getLicenseFrontFileName();
           String licenseBackFileName = fileNames.getLicenseBackFileName();
           String nicFrontFileName = fileNames.getNicFrontFileName();
           String nicBackFileName = fileNames.getNicBackFileName();



          /*
           if(licenseFrontFileName.equals(lisFront.getName())){

           }
           else{
               // save new
               System.out.println("update lisence front");
               service.delete(licenseFrontFileName,path);
               service.store(path,lisFront);
               // update path db


           }

           if(licenseBackFileName.equals(lisBack.getName())){


           }
           else {
               // save new
               System.out.println("update lisence Back");
               service.delete(licenseBackFileName,path);
               service.store(path,lisBack);
               // update path db

           }
           if(nicFrontFileName.equals(idFront.getName())){


           }else {
               // save new
               System.out.println("update lisence front");
               service.delete(nicFrontFileName,path);
               service.store(path,idFront);
               // update path db
           }

           if(nicBackFileName.equals(idBack.getName())){


           }else {
               // save new
               System.out.println("update lisence front");
               service.delete(nicBackFileName,path);
               service.store(path,idBack);
               // update path db
           }
            */

           if(! nicBackFileName.equals(idBack.getName()) && nicFrontFileName.equals(idBack.getName())){
               // save new
               System.out.println("update lisence front");
               service.delete(nicBackFileName,path);
               service.delete(nicFrontFileName,path);
               service.store(path,idBack);
               // update path db
           }else {
               // save new
               System.out.println("update lisence front");
               service.delete(nicBackFileName,path);
               service.store(path,idBack);
               // update path db
           }

          return new ResponseUtil(200,"Update",null);

    }


    // if not verified
    @PutMapping(path = "/delete/nicOrLis/photos", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseUtil deletePhotos(@RequestParam("id") String id,@RequestParam("issue") String issue) throws IOException {

           // this method is use to delete photos from directories and  update photos in database (assign null)
           // and set customer not verified
           // run . after check verify by admin


           //delete photos in repo

          // if issue eq id then both nic images are delete

        CustomerDTO fileNames = customerService.getFileName(Integer.parseInt(id));
       // String path = customerService.getPath(Integer.parseInt(id));

                    if(issue.equals("nic")){
                          // get path/nic name
                        String path = customerService.getPath(Integer.parseInt(id));
                        String nicFrontFileName = fileNames.getNicFrontFileName();
                        String nicBackFileName = fileNames.getNicBackFileName();

                          // delete from dir
                        service.delete(nicBackFileName,path);
                        service.delete(nicFrontFileName,path);

                         // delete (set null) db and set customer not vrified
                         customerService.setNicNull(Integer.parseInt(id));

                    }else if(issue.equals("lis")){

                        // get path/lis  name
                        String licenseFrontFileName = fileNames.getLicenseFrontFileName();
                        String licenseBackFileName = fileNames.getLicenseBackFileName();
                        String path = customerService.getPath(Integer.parseInt(id));

                        // delete from dir
                        service.delete(licenseFrontFileName,path);
                        service.delete(licenseBackFileName,path);

                        // delete db and set customer not vrified
                        customerService.setLisNull(Integer.parseInt(id));

                    }else{
                        //both
                        // get  path/lis/nic  name
                        String path = customerService.getPath(Integer.parseInt(id));
                        String nicFrontFileName = fileNames.getNicFrontFileName();
                        String nicBackFileName = fileNames.getNicBackFileName();
                        String licenseFrontFileName = fileNames.getLicenseFrontFileName();
                        String licenseBackFileName = fileNames.getLicenseBackFileName();

                        // delete from dir
                        service.delete(licenseFrontFileName,path);
                        service.delete(licenseBackFileName,path);
                        service.delete(nicBackFileName,path);
                        service.delete(nicFrontFileName,path);

                        // delete db and set customer not vrified
                        customerService.setNicNull(Integer.parseInt(id));
                        customerService.setLisNull(Integer.parseInt(id));
                    }

           return new ResponseUtil(200," photos delete success ",null);

    }

        // set verified
        @PutMapping(path = "put/verified", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
        public ResponseUtil setCustomerVerify(@RequestParam String id){

               customerService.setCustomerStatusVerify(Integer.parseInt(id));

            return new ResponseUtil(200," customer verified  success ",null);
        }


     @DeleteMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
     public  ResponseUtil deleteCustomer( @PathVariable String id){
           return new ResponseUtil(200,"Delete",customerService.delete(Integer.parseInt(id)));
      }

       @GetMapping(path = "/isVerified" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil getCustomerIsVerified(String id){

            return new ResponseUtil(200,"getVerified/Not",customerService.IsVerified(Integer.parseInt(id)));

       }


       // get all customers
       @GetMapping(path = "all/customers" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil getAllCustomer() {

             return new ResponseUtil(200,"GetAll", customerService.getAll());
       }

       //get all photos
       @GetMapping(path = "getAll/photos")
       public  ResponseUtil getAllPhotos(){
           // get all customer ids
           ArrayList<CustomerDTO> all = customerService.getAll();
           ArrayList<Resource> multipartFiles = new ArrayList<>();
           for ( CustomerDTO c: all ) {

               for (int i = 1; i <= 4 ; i++) {
                   switch (i){
                       case 1 :
                           multipartFiles.add(service.loadAsResource("Customer",String.valueOf(c.getCustomerId()),c.getNicFrontFileName()))
                          ;break;
                       case 2 :
                           multipartFiles.add(service.loadAsResource("Customer", String.valueOf(c.getCustomerId()), c.getNicBackFileName()))
                          ;break;
                       case 3 :
                           multipartFiles.add(service.loadAsResource("Customer",String.valueOf(c.getCustomerId()),c.getLicenseFrontFileName()))
                           ;break;
                       case 4 :
                           multipartFiles.add( service.loadAsResource("Customer",String.valueOf(c.getCustomerId()),c.getLicenseBackFileName()))
                          ;break;
                       default: ;

                   }

               }

           }

           return new ResponseUtil(200,"GetAllPhotos", multipartFiles);
       }



       // search customer
       @GetMapping(path = "/search" , produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseUtil searchCustomer(String id){

           return  new ResponseUtil(200 ,"Search",customerService.search(id));

       }


}
