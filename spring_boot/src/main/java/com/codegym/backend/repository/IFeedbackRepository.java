package com.codegym.backend.repository;

import com.codegym.backend.dto.FeedbackDto;
import com.codegym.backend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
    String createFeedback_sql = "insert into feedback(fb_id,name,email,date,content,type_id,rate) " +
            "values (?1,?2,?3,?4,?5,?6,?7)";

    @Modifying
    @Query(value = "insert into feedback(fb_id,name,email,date,content,type_id,rate) values (?1,?2,?3,?4,?5,?6,?7);", nativeQuery = true)
//    void createFeedback(@Param("fb_id") String fb_id, @Param("name") String name,
//                        @Param("email") String email, @Param("date") String date, @Param("content") String content,
//                        @Param("type_id") int type_id, @Param("rate") String rate);
    void createFeedback(String fb_id, String name,
                        String email, String date, String content,
                        int type_id, String rate);

//    @Query(value = "select f.id, f.fb_id , f.name, f.email, ft.type, f.date from feedback left join feedback_type ft on f.type_id = ft.id", nativeQuery = true)
//    List<FeedbackDto> getAllList();
}
