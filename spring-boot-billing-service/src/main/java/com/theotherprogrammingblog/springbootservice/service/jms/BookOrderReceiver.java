package com.theotherprogrammingblog.springbootservice.service.jms;



import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.jms.Session;

@Service
public class BookOrderReceiver {

    @Autowired
    private BillingOrderSender billingOrderSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookOrderReceiver.class);

    private  static final String ORDER_PLACED="order.placed";

    @JmsListener(destination = ORDER_PLACED, containerFactory = "topicListenerFactory")
    public void receiveOrderPlaced(@Payload BookOrder bookOrder,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {
        LOGGER.info("Message received from topic: "+ ORDER_PLACED);
        LOGGER.info("received data <" + bookOrder + ">");
        billingOrderSender.sendOrderProcessed(bookOrder);
    }
}
