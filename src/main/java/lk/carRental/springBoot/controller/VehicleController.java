package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.dto.VehicleDTO;
import lk.carRental.springBoot.service.VehicleService;
import lk.carRental.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicle;



         @PostMapping("register")
         public ResponseUtil registerVehicle(@RequestParam("vehicle") VehicleDTO vehicle, @RequestParam("files") ArrayList<MultipartFile> files){


             this.vehicle.save(vehicle);

             return new ResponseUtil(200,"save",null);
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

         @GetMapping("getAll")
        public ResponseUtil getAllVehicle(){

                 return new ResponseUtil(200,"getAll",this.vehicle.getAll());

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

