package io.axoniq.demo.giftcard.messaging.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BaseEvent {

    private String type;

    @JsonCreator
    public BaseEvent(
            @JsonProperty("_type") String type
    ) {
        this.type = type;
    }
}
