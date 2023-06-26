/**
 * IFeedbackRepository interface is used to interact with the database to get data
 *
 * @author TuLG
 * @version 1.0
 * @since 2023-06-13
 */

package com.codegym.backend.repository;

import com.codegym.backend.dto.FeedbackDetailDto;
import com.codegym.backend.dto.IFeedbackDto;
import com.codegym.backend.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Modifying
    @Query(value = "insert into feedback(fb_id,name,email,date,content,type_id,rate) values (?1,?2,?3,?4,?5,?6,?7);", nativeQuery = true)
    void createFeedback(String fbId, String name,
                        String email, String date, String content,
                        int typeId, Integer rate);

    String selectAllFeedback_sql = "select f.id, f.fb_id , f.name, f.email, ft.type, f.date from feedback f\n" +
            "left join feedback_type ft on f.type_id = ft.id\n" +
            "order by f.id asc";

    @Query(value = selectAllFeedback_sql, countQuery = selectAllFeedback_sql, nativeQuery = true)
    Page<IFeedbackDto> findAllList(Pageable pageable);

    String selectFeedbackDetail_sql = "select f.rate, ft.type ,f.name, f.content from feedback f\n" +
            "left join feedback_type ft on f.type_id = ft.id\n" +
            "where f.id = ?";

    @Query(value = selectFeedbackDetail_sql, countQuery = selectFeedbackDetail_sql, nativeQuery = true)
    FeedbackDetailDto findFeedbackById(int id);

    String selectFeedbackImg_sql = "select fi.imgUrl from feedback f\n" +
            "left join feedback_img fi on f.id= fi.feedback_id\n" +
            "where f.id = ? \n" +
            "order by fi.id asc";

    @Query(value = selectFeedbackImg_sql, countQuery = selectFeedbackImg_sql, nativeQuery = true)
    List<String> findImgUrlById(int id);

    String selectAllFeedbackByDate_sql = "select f.id, f.fb_id , f.name, f.email, ft.type, f.date from feedback f\n" +
            "left join feedback_type ft on f.type_id = ft.id\n" +
            "where f.date = ?\n" +
            "order by f.id asc";

    @Query(value = selectAllFeedbackByDate_sql, countQuery = selectAllFeedbackByDate_sql, nativeQuery = true)
    Page<IFeedbackDto> findListFeedbackByDate(Pageable pageable, String date);

    /**
     * @author DongPL
     * @version 2.0
     * @since 19/06/2023
     */
    @Query(value = "select MAX(id) from feedback", nativeQuery = true)
    Integer getLastInsert();

    /**
     * @author DongPL
     * @version 2.0
     * @since 19/06/2023
     */
    @Query(value = "select * from feedback where id = :id", nativeQuery = true)
    Feedback findObject(@Param("id") int id);
}
