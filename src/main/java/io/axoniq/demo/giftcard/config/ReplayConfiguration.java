//package io.axoniq.demo.giftcard.config;
//
//
//import org.axonframework.config.EventProcessingConfiguration;
//import org.axonframework.eventhandling.TrackingEventProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ReplayConfiguration {
//
//    @Autowired
//    public void configureProcessors(EventProcessingConfiguration configuration) {
//        configuration
//                .eventProcessorByProcessingGroup("myProcessor",
//                        TrackingEventProcessor.class)
//                .ifPresent(trackingEventProcessor -> {
//                    trackingEventProcessor.shutDown();
//                    trackingEventProcessor.resetTokens();
//                    trackingEventProcessor.start();
//                });
//    }
//}
