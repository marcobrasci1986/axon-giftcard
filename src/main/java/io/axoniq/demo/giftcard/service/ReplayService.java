package io.axoniq.demo.giftcard.service;

import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplayService {

    @Autowired
    private EventProcessingConfiguration eventProcessingConfiguration;

    public void resetCards() {
        eventProcessingConfiguration
                .eventProcessorByProcessingGroup("myProcessor",
                        TrackingEventProcessor.class)
                .ifPresent(trackingEventProcessor -> {
                    trackingEventProcessor.shutDown();
                    trackingEventProcessor.resetTokens();
                    trackingEventProcessor.start();
                });
    }
}
