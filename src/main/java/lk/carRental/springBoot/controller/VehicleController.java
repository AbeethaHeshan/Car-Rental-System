package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicle;


         @PostMapping("register")
         public void registerVehicle(){



         }

         @DeleteMapping("delete")
         public void deleteVehicle(){



        }


        @PutMapping("update")
        public void updateVehicle(){



         }

         @GetMapping("getAll")
        public void getAllVehicle(){



        }

        @GetMapping("search")
        public void searchVehicle(){



        }

        @GetMapping("allAvailable")
        public void getAllAvailableVehicle(){



        }
}

