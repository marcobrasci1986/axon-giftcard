package io.axoniq.demo.giftcard.messaging.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
// Getters are necessary -> Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
@Getter
public class PersonCreatedEvent extends BaseEvent {
    private UUID id;
    private String firstname;
    private String lastname;

    @Builder
    @JsonCreator
    public PersonCreatedEvent(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            @JsonProperty("_type") String type
    ) {
        super(type);
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
