package io.axoniq.demo.giftcard.messaging.model;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Builder
@ToString
public class PersonCreatedEvent implements Serializable {
    private UUID id;
    private String firstname;
    private String lastname;
}
