
/**
 * FeedbackService class to create shared methods
 *
 * @author TuLG
 * @version 1.0
 * @since 2023-06-13
 */

package com.codegym.backend.service.Impl;


import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.FeedbackDto;
import com.codegym.backend.dto.IFeedbackDto;
import com.codegym.backend.model.Feedback;
import com.codegym.backend.repository.IFeedbackRepository;
import com.codegym.backend.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Page<IFeedbackDto> findAll(Pageable pageable) {
        return feedbackRepository.findAllList(pageable);
    }

    @Override
    public void createFeedback(Feedback feedback) {
        feedbackRepository.createFeedback(feedback.getFeedbackId(), feedback.getName(),
                feedback.getEmail(), feedback.getDate(), feedback.getContent(), feedback.getFeedbackType().getId(), feedback.getRate());
    }

    @Override
    public FeedbackDetailDto findFeedbackById(int id) {
        return feedbackRepository.findFeedbackById(id);
    }

    @Override
    public List<String> findImgUrlById(int id) {
        return feedbackRepository.findImgUrlById(id);
    }

    @Override
    public Page<IFeedbackDto> findListFeedbackByDate(Pageable pageable, String date) {
        return feedbackRepository.findListFeedbackByDate(pageable, date);
    }

    @Override
    public Page<IFeedbackDto> findListFeedbackByRate(Pageable pageable, String rate) {
        return feedbackRepository.findListFeedbackByRate(pageable, rate);
    }

    @Override
    public Page<IFeedbackDto> findListFeedbackByRateAndDate(Pageable pageable, String rate, String date) {
        return feedbackRepository.findListFeedbackByRateAndDate(pageable, rate, date);
    }
}
