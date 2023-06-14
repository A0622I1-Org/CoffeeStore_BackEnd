package com.codegym.backend.service;

import com.codegym.backend.model.Feedback;
import com.codegym.backend.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository repository;

    @Override
    public List<Feedback> getAll() {
        return repository.findAll();
    }

    @Override
    public void createFeedback(Feedback feedback) {
//        repository.save(feedback);
        repository.createFeedback(feedback.getFeedbackId(), feedback.getName(), feedback.getEmail(), feedback.getDate(), feedback.getContent(), feedback.getFeedbackType().getId(), feedback.getRate());
    }
}
