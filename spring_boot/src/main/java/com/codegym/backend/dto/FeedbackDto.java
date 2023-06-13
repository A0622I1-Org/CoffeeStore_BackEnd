/**
 * FeedbackDto interface is used to collect data from the database
 *
 * @author TuLG
 * @version 1.0
 * @since 2023-06-13
 */

package com.codegym.backend.dto;

public interface FeedbackDto {
    Integer getId();
    String getFb_id();
    String getName();
    String getEmail();
    String getType();
    String getDate();
}
