package com.codegym.backend.controller;

import com.codegym.backend.dto.CreateFeedback;
import com.codegym.backend.model.Feedback;
import com.codegym.backend.model.FeedbackType;
import com.codegym.backend.service.IFeedbackService;
import com.codegym.backend.service.IFeedbackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @Autowired
    private IFeedbackTypeService feedbackTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<Feedback>> getAllType() {
        List<Feedback> feedbackList = feedbackService.getAll();
        if (feedbackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFeedback(@RequestBody CreateFeedback feedbackCreate) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackCreate.getFeedbackId());
        feedback.setName(feedbackCreate.getName());
        feedback.setEmail(feedbackCreate.getEmail());
        feedback.setDate(feedbackCreate.getDate());
        feedback.setContent(feedbackCreate.getContent());
        feedback.setRate(feedbackCreate.getRate());
        FeedbackType feedbackType = feedbackTypeService.findById(Integer.parseInt(feedbackCreate.getFeedbackType()));
        feedback.setFeedbackType(feedbackType);
        feedbackService.createFeedback(feedback);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
