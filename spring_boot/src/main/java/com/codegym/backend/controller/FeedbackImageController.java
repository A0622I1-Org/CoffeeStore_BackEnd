package com.codegym.backend.controller;

import com.codegym.backend.dto.CreateFeedbackImg;
import com.codegym.backend.service.impl.FeedbackImageProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FeedbackImageController {
    @Autowired
    private FeedbackImageProcessingService feedbackImageProcessingService;

    @PostMapping("/image/create")
    public ResponseEntity<Void> createFeedbackImage(@RequestBody CreateFeedbackImg createFeedbackImg) {
        feedbackImageProcessingService.createFeedbackImage(createFeedbackImg);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
