package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.OrderDTO;

public interface OrderService {

      void placeOrder();

      void deleteOrder();

      void updateOrder();

      void orderIdVerified();

      void getAllOrder();

      void searchOrder();
}
