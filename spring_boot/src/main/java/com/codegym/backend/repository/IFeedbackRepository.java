package com.codegym.backend.repository;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.FeedbackDto;
import com.codegym.backend.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
    String selectAllFeedback_sql = "select f.id, f.fb_id , f.name, f.email, ft.type, f.date from feedback f\n" +
            "left join feedback_type ft on f.type_id = ft.id\n" +
            "order by f.id asc";
    @Query(value =selectAllFeedback_sql, countQuery = selectAllFeedback_sql, nativeQuery = true)
    Page<FeedbackDto> findAllList(Pageable pageable);

    String selectFeedbackDetail_sql = "select f.rate, ft.type ,f.name, f.content from feedback f\n" +
            "left join feedback_type ft on f.type_id = ft.id\n" +
            "where f.id = ?;";
    @Query(value =selectFeedbackDetail_sql, countQuery = selectFeedbackDetail_sql, nativeQuery = true)
    FeedbackDetailDto findFeedbackById(int id);

    String selectFeedbackImg_sql = "select f.id , fi.imgUrl from feedback f\n" +
            "left join feedback_img fi on f.id= fi.feedback_id\n" +
            "where f.id = ? \n" +
            "order by fi.id asc;";
    @Query(value =selectFeedbackImg_sql, countQuery = selectFeedbackImg_sql, nativeQuery = true)
    List<String> findImgUrlById(int id);
}
