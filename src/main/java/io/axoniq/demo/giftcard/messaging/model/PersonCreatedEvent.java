package io.axoniq.demo.giftcard.messaging.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Builder
@ToString
// Getters are necessary -> Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
@Getter
public class PersonCreatedEvent implements Serializable {
    private UUID id;
    private String firstname;
    private String lastname;

    @JsonCreator
    public PersonCreatedEvent(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname
    ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
