package io.axoniq.demo.giftcard.controller;

import io.axoniq.demo.giftcard.service.CardSummaryProjectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventTrackerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CardSummaryProjectionController {

    private final CardSummaryProjectionService cardSummaryProjectionService;

    @GetMapping("/reset")
    public void reset() {
        log.info("Resetting cardsummary projections");
        cardSummaryProjectionService.reset();
    }

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Resetting cardsummary projections");
        Map<Integer, EventTrackerStatus> statusMap = cardSummaryProjectionService.processingStatus();
        return ResponseEntity.ok(statusMap);
    }
}
