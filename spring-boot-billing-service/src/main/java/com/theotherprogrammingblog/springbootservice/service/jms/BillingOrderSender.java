package com.theotherprogrammingblog.springbootservice.service.jms;


import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingOrderSender {
    private  static final String ORDER_PROCESSED="order.processed";
    private  static final String ORDER_CANCELLED="order.cancelled";

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingOrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrderCancelled(BookOrder bookOrder){
        LOGGER.info("Order Cancelled: "+bookOrder.toString());
        jmsTemplate.convertAndSend(ORDER_CANCELLED, bookOrder);
    }

    public void sendOrderProcessed(BookOrder bookOrder){
        LOGGER.info("Order Processed: "+bookOrder.toString());
        jmsTemplate.convertAndSend(ORDER_PROCESSED, bookOrder);
    }
}
