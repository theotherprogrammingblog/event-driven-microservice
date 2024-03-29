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
public class FulfillmentReceiver {

    @Autowired
    private FulfillmentSender fulfillmentSender;
    private static final Logger LOGGER = LoggerFactory.getLogger(FulfillmentReceiver.class);


    private  static final String ORDER_PROCESSED="order.processed";

    @JmsListener(destination = ORDER_PROCESSED, containerFactory = "topicListenerFactory")
    public void receiveOrderProcessed(@Payload BookOrder bookOrder,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {
        LOGGER.info("Message received from topic: "+ ORDER_PROCESSED);
        LOGGER.info("received data <" + bookOrder + ">");
        fulfillmentSender.sendOrderMailed(bookOrder);
    }
}
