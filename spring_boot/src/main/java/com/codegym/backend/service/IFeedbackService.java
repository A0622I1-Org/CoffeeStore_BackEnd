package com.codegym.backend.service;

import com.codegym.backend.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getAll();
    void createFeedback(Feedback feedback);
}
