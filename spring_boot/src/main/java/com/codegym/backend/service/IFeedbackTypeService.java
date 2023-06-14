package com.codegym.backend.service;

import com.codegym.backend.model.FeedbackType;

import java.util.List;

public interface IFeedbackTypeService {
    List<FeedbackType> selectAll();
    FeedbackType findById(int id);
}
