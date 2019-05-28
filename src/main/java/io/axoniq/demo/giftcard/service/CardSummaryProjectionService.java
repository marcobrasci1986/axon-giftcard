package io.axoniq.demo.giftcard.service;

import io.axoniq.demo.giftcard.query.CardSummaryProjection;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.EventProcessingConfiguration;
import org.axonframework.eventhandling.EventTrackerStatus;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CardSummaryProjectionService {

    private final EventProcessingConfiguration eventProcessingConfiguration;

    public Map<Integer, EventTrackerStatus> processingStatus() {
        TrackingEventProcessor trackingEventProcessor = getTrackingEventProcessor();
        return trackingEventProcessor.processingStatus();

    }

    public void reset() {
        TrackingEventProcessor trackingEventProcessor = getTrackingEventProcessor();

        trackingEventProcessor.shutDown();
        trackingEventProcessor.resetTokens();
        trackingEventProcessor.start();

    }

    private TrackingEventProcessor getTrackingEventProcessor() {
        return eventProcessingConfiguration
                .eventProcessorByProcessingGroup(CardSummaryProjection.CARD_SUMMARY_PROCESSOR, TrackingEventProcessor.class)
                .orElseThrow(IllegalStateException::new);
    }
}
