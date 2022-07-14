package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.dto.OrderDTO;
import lk.carRental.springBoot.repo.OrderRepo;
import lk.carRental.springBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepo order;

    @Override
    public String placeOrder(OrderDTO orderDTO) {
        return "";
    }

    @Override
    public String deleteOrder(String id) {
        return "";
    }

    @Override
    public String updateOrder(OrderDTO orderDTO) {

        return "";
    }

    @Override
    public boolean orderIdVerified(String id) {
            return false;
    }

    @Override
    public ArrayList<OrderDTO> getAllOrder() {
              return null;
    }

    @Override
    public OrderDTO searchOrder(String id) {
            return null;
    }
}
