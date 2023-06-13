package com.codegym.backend.service;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedbackService {
    Page<FeedbackDto> findAll(Pageable pageable);
    FeedbackDetailDto findFeedbackById(int id);
    List<String> findImgUrlById(int id);
    Page<FeedbackDto> findListFeedbackByDate(Pageable pageable, String date);
}
