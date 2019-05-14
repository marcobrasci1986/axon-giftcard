package io.axoniq.demo.giftcard.messaging.controller;

import io.axoniq.demo.giftcard.messaging.model.PersonCreatedEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Source.class)
public class PublishingController {
//
//    @Autowired
//    private Source source;


    @PostMapping("/sendmessage")
    public String sendMessage(@RequestBody PersonCreatedEvent personCreatedEvent) {

//        this.source.output().send(MessageBuilder.withPayload(personCreatedEvent).setHeader("myHeader", "myHeaderValue").build());
        return "Message was sent";
    }

    @GetMapping("/test")
    public String test() {
        return "Tetsing";
    }
}
