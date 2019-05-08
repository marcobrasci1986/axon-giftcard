package io.axoniq.demo.giftcard.controller;

import io.axoniq.demo.giftcard.service.ReplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResetController {

    private final ReplayService replayService;

    @GetMapping("/reset")
    public void resetProjection() {
        System.out.println("here");
        replayService.resetCards();
    }
}
