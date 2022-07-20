package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.GalleryDTO;
import lk.carRental.springBoot.dto.VehicleDTO;
import lk.carRental.springBoot.entity.Gallery;
import lk.carRental.springBoot.service.GallaryService;
import lk.carRental.springBoot.service.VehicleService;
import lk.carRental.springBoot.service.fileStoreService.StorageService;
import lk.carRental.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicle;

    @Autowired
    StorageService service;


     @Autowired
     GallaryService gallary;

         @PostMapping("register/vehicle")
         public ResponseUtil registerVehicle(@RequestBody VehicleDTO vehicle){

                this.vehicle.save(vehicle);

             return new ResponseUtil(200,"save",null);

         }


         @PostMapping("/register/vehicle/photos")
         public ResponseUtil registerVehiclePhotos(@RequestParam("id")String id ,@RequestParam("photoOne") MultipartFile photoOne, @RequestParam("photoTwo") MultipartFile photoTwo, @RequestParam("photoThree") MultipartFile photoThree , @RequestParam("photoFour") MultipartFile photoFour ){


             String path = service.createDirectory("Vehicle",id);
             service.store(path,photoOne,photoTwo,photoThree,photoFour);
             ArrayList<GalleryDTO> photoArray = new ArrayList<>();

             for (int i = 1; i <= 4; i++) {
                 System.out.println(i);
                 switch (i) {
                     case 1: photoArray.add(new GalleryDTO(path,photoOne.getOriginalFilename(),id));break;
                     case 2: photoArray.add(new GalleryDTO(path,photoTwo.getOriginalFilename(),id));break;
                     case 3: photoArray.add(new GalleryDTO(path,photoThree.getOriginalFilename(),id));break;
                     case 4: photoArray.add(new GalleryDTO(path,photoFour.getOriginalFilename(),id));break;
                     default:
                         System.out.println("sd");

                 }


             }

             System.out.println(photoArray.get(0));
             System.out.println(photoArray.get(1));
             System.out.println(photoArray.get(2));
             System.out.println(photoArray.get(3));

             gallary.saveVehiclePohotoDetails(path,id,photoArray);

             return new ResponseUtil(200,"save","Save");

         }


         @DeleteMapping("delete")
         public ResponseUtil deleteVehicle(String id){
                this.vehicle.delete(id);
           return new ResponseUtil(200,"delete",null);
        }


        @PutMapping("update")
        public ResponseUtil updateVehicle(@RequestParam VehicleDTO vehicle, @RequestParam ArrayList<MultipartFile> files){

                       this.vehicle.update(vehicle);

                return new ResponseUtil(200,"update",null);

         }
        @GetMapping("getAll/vehicle")
        public ResponseUtil getAllVehicle(){

                 return new ResponseUtil(200,"getAll",this.vehicle.getAll());

        }

    @GetMapping("getAll/vehicle/photos")
    public ResponseUtil getAllVehiclePhotos(){
       /*        // get all vehicles
        ArrayList<VehicleDTO> all = vehicle.getAll();

              // path ,

        ArrayList<Gallery> galleries = gallary.getAll();
        // get all customer ids
        ArrayList<Resource> multipartFiles = new ArrayList<>();
        for ( VehicleDTO c: all ) {

            for (Gallery g :  galleries) {
              //  multipartFiles.add(gallary.loadAsResource("Vehicle",c.getRegistrationNo(),g.getImgName()));
            }
            */

         return new ResponseUtil(200,"getAll",null);

        }









        @GetMapping("search")
        public ResponseUtil searchVehicle(String id){


               return new ResponseUtil(200,"search",this.vehicle.search(id));
        }

        @GetMapping("allAvailable")
        public ResponseUtil getAllAvailableVehicle(){

                 return  new ResponseUtil(200,"getAll",vehicle.getAllAvailableVehicle());

        }
}

