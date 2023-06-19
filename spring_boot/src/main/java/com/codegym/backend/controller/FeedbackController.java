package com.codegym.backend.controller;

import com.codegym.backend.dto.CreateFeedback;
import com.codegym.backend.service.Impl.FeedbackProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackProcessingService feedbackProcessingService;

    @PostMapping("/create")
    public ResponseEntity<?> createFeedback(@RequestBody CreateFeedback feedbackCreate) {
        feedbackProcessingService.processFeedback(feedbackCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
