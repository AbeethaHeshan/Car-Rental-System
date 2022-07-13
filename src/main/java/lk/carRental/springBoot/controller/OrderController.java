package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

      @Autowired
      OrderService order;


            @PutMapping("placeOrder")
            public void placeOrder(){


            }

            @DeleteMapping("deleteOrder")
            public  void deleteOrder(){


            }

            @PutMapping("updateOrder")
            public  void updateOrder(){


            }

            @GetMapping("isVerified")
            public void orderIdVerified(){


            }
            @GetMapping("all")
            public void getAllOrder(){


            }

            @GetMapping("searchOrder")
            public void searchOrder(){


            }



}
