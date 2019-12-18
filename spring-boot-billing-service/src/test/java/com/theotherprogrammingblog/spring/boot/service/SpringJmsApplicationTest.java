package com.theotherprogrammingblog.spring.boot.service;



import com.theotherprogrammingblog.springbootservice.SpringBootBillingServiceApplication;
import com.theotherprogrammingblog.springbootservice.model.BookOrder;
import com.theotherprogrammingblog.springbootservice.service.jms.BillingOrderSender;
import com.theotherprogrammingblog.springbootservice.service.jms.BookOrderReceiver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.concurrent.TimeUnit;



@SpringBootTest(classes = SpringBootBillingServiceApplication.class)
public class SpringJmsApplicationTest {

  @Autowired
  private BookOrderReceiver bookOrderReceiver;
  @Autowired
  private BillingOrderSender billingOrderSender;

  @Test
  public void testReceive() throws Exception {

    System.out.print("hello");
   // sender.send("order-001");
   // sender.send("order-002");
   // sender.send("order-003");
   // sender.send("order-004");

    BookOrder bookOrder= new BookOrder();
    billingOrderSender.sendBillingOrderProcessed(bookOrder);

    //receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    //assertThat(receiver.getLatch().getCount()).isEqualTo(0);
  }
}
