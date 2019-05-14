//package io.axoniq.demo.giftcard.messaging;
//
//import io.axoniq.demo.giftcard.GcApp;
//import io.axoniq.demo.giftcard.messaging.model.PersonCreatedEvent;
//import lombok.extern.slf4j.XSlf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@XSlf4j
//public class ReceiverService {
//
//    @RabbitListener(queues = GcApp.queueName)
//    public void receiveMessage(final PersonCreatedEvent personCreatedEvent) {
//        log.info("Received message: {}", personCreatedEvent);
//    }
//
//}
