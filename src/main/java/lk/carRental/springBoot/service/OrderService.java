package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.OrderDTO;

import java.util.ArrayList;

public interface OrderService {

      String placeOrder(OrderDTO orderDTO);

      String deleteOrder(String id);

      String updateOrder(OrderDTO orderDTO);

      boolean orderIdVerified(String id);

      ArrayList<OrderDTO> getAllOrder();

      OrderDTO searchOrder(String id);
}
