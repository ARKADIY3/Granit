package org.example.prostorazvlecaus.service.impl;

import org.example.prostorazvlecaus.model.Order;
import org.example.prostorazvlecaus.repo.OrderRepo;
import org.example.prostorazvlecaus.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class implOrder implements OrderService {

    private final OrderRepo orderrepo;

    public implOrder(OrderRepo orderrepo) {
        this.orderrepo = orderrepo;
    }

    @Override
    public List<Order> getOrder(){
        return orderrepo.findAll();
    }

    @Override
    public void addOrder(Order order) {
        orderrepo.save(order);
    }

    @Override
    public void deleteOrder(Long id){
        orderrepo.deleteById(id);
    }

    @Override
    public Order getOrder(Long id){
        return orderrepo.findById(id).orElse(null);
    }
}
