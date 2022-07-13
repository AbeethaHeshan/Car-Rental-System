package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.repo.OrderRepo;
import lk.carRental.springBoot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepo order;

    @Override
    public void placeOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void orderIdVerified() {

    }

    @Override
    public void getAllOrder() {

    }

    @Override
    public void searchOrder() {

    }
}
