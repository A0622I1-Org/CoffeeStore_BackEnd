package com.codegym.backend.service.Impl;

import com.codegym.backend.model.FeedbackImg;
import com.codegym.backend.repository.IFeedbackImageRepository;
import com.codegym.backend.service.IFeedbackImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackImageService implements IFeedbackImageService {
    @Autowired
    private IFeedbackImageRepository repository;


    @Override
    public void createFeedbackImage(FeedbackImg feedbackImg) {
        repository.createFeedbackImg(feedbackImg.getFeedback().getId(), feedbackImg.getImgUrl());
    }
}
