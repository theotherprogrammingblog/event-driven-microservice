package com.theotherprogrammingblog.springbootservice.service.jms;


import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BillingOrderSender {
    private  static final String BILLING_ORDER_PROCESSED="billing.order.processed";
    private  static final String BILLING_ORDER_CANCELLED="billing.order.cancelled";

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingOrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendBookOrderCancelled(BookOrder bookOrder){
        LOGGER.info("Billing Cancelled: "+bookOrder.toString());
        jmsTemplate.convertAndSend(BILLING_ORDER_CANCELLED, bookOrder);
    }

    public void sendBillingOrderProcessed(BookOrder bookOrder){
        LOGGER.info("Billing Processed: "+bookOrder.toString());
        jmsTemplate.convertAndSend(BILLING_ORDER_PROCESSED, bookOrder);
    }
}
