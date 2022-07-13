package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driver;


    public void registerDriver(){


    }

    public  void deleteDriver(){


    }

    public  void updateDriver(){


    }

    public void searchDriver(){


    }

    public void getDriverIsVerified(){


    }

    public  void getAllDriver(){



    }

    public  void getDriverAvailability(){


    }

}
