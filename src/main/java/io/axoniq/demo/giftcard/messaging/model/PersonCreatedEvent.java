package io.axoniq.demo.giftcard.messaging.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@ToString
// Getters are necessary -> Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
@Getter
public class PersonCreatedEvent {
    private UUID id;
    private String firstname;
    private String lastname;
    private String type;


    @JsonCreator
    public PersonCreatedEvent(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("_type") String type
    ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
    }
}
