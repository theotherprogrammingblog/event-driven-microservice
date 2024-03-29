package com.theotherprogrammingblog.springbootservice.service.jms;


import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class FulfillmentSender {
    private  static final String ORDER_MAILED="order.mailed";

    private static final Logger LOGGER = LoggerFactory.getLogger(FulfillmentSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrderMailed(BookOrder bookOrder){
        LOGGER.info("Order Mailed: "+bookOrder.toString());
        jmsTemplate.convertAndSend(ORDER_MAILED, bookOrder);
    }
}
