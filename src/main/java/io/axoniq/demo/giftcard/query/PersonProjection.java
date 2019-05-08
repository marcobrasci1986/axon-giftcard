package io.axoniq.demo.giftcard.query;

import io.axoniq.demo.giftcard.api.IssuedEvt;
import lombok.extern.slf4j.XSlf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@XSlf4j
@Component
@ProcessingGroup("myProcessor2")
public class PersonProjection {

    @EventHandler
    public void on(IssuedEvt event) {
        log.trace("projecting {}", event);

    }
}
