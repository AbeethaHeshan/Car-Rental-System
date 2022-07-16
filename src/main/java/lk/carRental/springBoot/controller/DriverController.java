package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.dto.DriverDTO;
import lk.carRental.springBoot.service.DriverService;
import lk.carRental.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driver;

    @PostMapping(path = "/save")
    public ResponseUtil registerDriver(@RequestParam DriverDTO driver){
        this.driver.save(driver);
           return new ResponseUtil(200,"",null);
    }

    @DeleteMapping("delete")
    public  ResponseUtil deleteDriver(String id){
        driver.delete(id);
        return new ResponseUtil(200,"deleteSuccess",null);
    }

    @PutMapping("update")
    public  ResponseUtil updateDriver(@RequestParam DriverDTO driver){
        this.driver.update(driver);
       return new ResponseUtil(200,"Update Success",null);
    }

    @GetMapping("search")
    public ResponseUtil searchDriver(String id){
          return new ResponseUtil(200,"Search",driver.search(id));
    }

    @GetMapping("isValid")
    public ResponseUtil getDriverIsVerified(String id){

           return new ResponseUtil(200,"isValid",driver.isVerified(id));
    }


    @GetMapping("all")
    public  ResponseUtil getAllDriver(){

             return  new ResponseUtil(200,"all",driver.getAll());

    }

    @GetMapping("availability")
    public  ResponseUtil getDriverAvailability(String id){

         return new ResponseUtil(200,"status",driver.getAvailability(id));

    }

}
