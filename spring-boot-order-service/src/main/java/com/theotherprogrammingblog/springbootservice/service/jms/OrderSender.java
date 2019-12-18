package com.theotherprogrammingblog.springbootservice.service.jms;


import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderSender {

    private  static final String ORDER_TOPIC="book.order.placed";
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendOrder(BookOrder bookOrder) {
        LOGGER.info("Order placed: "+bookOrder.toString());
        jmsTemplate.convertAndSend(ORDER_TOPIC, bookOrder);
    }


}
