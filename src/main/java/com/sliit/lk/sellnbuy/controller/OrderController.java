package com.sliit.lk.sellnbuy.controller;

import com.sliit.lk.sellnbuy.Repository.OrderRepository;
import com.sliit.lk.sellnbuy.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/add-order")
    public ResponseEntity<Object> addOrder(@RequestBody Map<String, String> body) {

        Order order = new Order();
        order.setOrderDate(new Date().toString());
        order.setProductId(1);
        order.setQty(5);
        order.setTotalBill(5000);

        Order savedOrder = orderRepository.save(order);
        return ResponseEntity
                .ok()
                .body("savedOrder " + savedOrder.getId() );
    }
}
