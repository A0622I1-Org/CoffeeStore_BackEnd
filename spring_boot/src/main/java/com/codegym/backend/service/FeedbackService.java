package com.codegym.backend.service;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.FeedbackDto;
import com.codegym.backend.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    IFeedbackRepository feedbackRepository;

    @Override
    public Page<FeedbackDto> findAll(Pageable pageable) {
        return feedbackRepository.findAllList(pageable);
    }

    @Override
    public FeedbackDetailDto findFeedbackById(int id) {
        return feedbackRepository.findFeedbackById(id);
    }

    @Override
    public List<String> findImgUrlById(int id) {
        return feedbackRepository.findImgUrlById(id);
    }
}
