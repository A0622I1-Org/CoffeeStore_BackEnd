/**
 * FeedbackResController class use to make API
 *
 * @author TuLG
 * @version 1.0
 * @since 2023-06-13
 */


package com.codegym.backend.controller;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.FeedbackDto;
import com.codegym.backend.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class FeedbackResController {
    @Autowired
    private IFeedbackService feedbackService;

    @GetMapping("/listFeedback")
    public ResponseEntity<Page<FeedbackDto>> getFeedbacklist(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FeedbackDto> feedbackList = feedbackService.findAll(pageable);
        if (feedbackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/getListByDate")
    public ResponseEntity<Page<FeedbackDto>> getListByDate(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam String date) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FeedbackDto> feedbackList = feedbackService.findListFeedbackByDate(pageable, date);
        if (feedbackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/feedbackDetail/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int id){
        FeedbackDetailDto feedbackDetail = feedbackService.findFeedbackById(id);
        if(Objects.equals(feedbackDetail.getName(), "")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(feedbackDetail,HttpStatus.OK);
    }

    @GetMapping("/feedbackImg/{id}")
    public ResponseEntity<?> getImgUrlById(@PathVariable int id){
        List<String> imgList = feedbackService.findImgUrlById(id);
        if(imgList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imgList,HttpStatus.OK);
    }
}