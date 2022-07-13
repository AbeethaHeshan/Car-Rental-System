package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driver;

    @PostMapping
    public void registerDriver(){


    }

    @DeleteMapping
    public  void deleteDriver(){


    }

    @PutMapping
    public  void updateDriver(){


    }

    @GetMapping("search")
    public void searchDriver(){


    }

    @GetMapping("isValid")
    public void getDriverIsVerified(){


    }


    @GetMapping("all")
    public  void getAllDriver(){



    }

    public  void getDriverAvailability(){


    }

}
