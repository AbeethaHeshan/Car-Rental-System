package lk.carRental.springBoot.controller;


import lk.carRental.springBoot.dto.OrderDTO;
import lk.carRental.springBoot.service.OrderService;
import lk.carRental.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

      @Autowired
      OrderService order;


            @PutMapping(value = "placeOrder",consumes = {MediaType.APPLICATION_JSON_VALUE})
            public ResponseUtil placeOrder(@RequestBody  OrderDTO orderDTO){

               return new ResponseUtil(200,"save",order.placeOrder(orderDTO));
            }

            @DeleteMapping("deleteOrder")
            public  ResponseUtil deleteOrder(String id){

                  return new ResponseUtil(200,"delete",order.deleteOrder(id));
            }

            @PutMapping("updateOrder")
            public  ResponseUtil updateOrder(OrderDTO orderDTO){
                  return  new ResponseUtil(200,"update",order.updateOrder(orderDTO));
            }

            @GetMapping("isVerified")
            public ResponseUtil orderIdVerified(String id){
                return new ResponseUtil(200,"idverified",order.orderIdVerified(id));

            }
            @GetMapping("all")
            public ResponseUtil getAllOrder(){

                    return new ResponseUtil(200,"all",order.getAllOrder());

            }

            @GetMapping("searchOrder")
            public ResponseUtil searchOrder(String id){

                    return new ResponseUtil(200,"search",order.searchOrder(id));
            }



}
