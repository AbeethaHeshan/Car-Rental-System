package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

      @Autowired
      OrderService order;

            public void placeOrder(){


            }

            public  void deleteOrder(){


            }

            public  void updateOrder(){


            }

            public void orderIdVerified(){


            }

            public void getAllOrder(){


            }

            public void searchOrder(){


            }



}
