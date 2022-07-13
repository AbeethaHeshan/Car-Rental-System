package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicle;


         public void registerVehicle(){



         }

        public void deleteVehicle(){



        }



        public void updateVehicle(){



         }

        public void getAllVehicle(){



        }


        public void searchVehicle(){



        }


        public void getAllAvailableVehicle(){



        }
}

