package com.theotherprogrammingblog.springbootservice.controller;


import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import com.theotherprogrammingblog.springbootservice.service.jms.OrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderSender orderSender;

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder (@RequestBody BookOrder bookOrder){
        orderSender.placeOrder(bookOrder);
        return new ResponseEntity( bookOrder, HttpStatus.OK);
    }

}
