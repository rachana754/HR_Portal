package com.ei.form;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;


/**
 * Used to process data to and from the controller and the HTML view 
 * @author sjean-baptiste
 */

@Data
public class AnnouncementForm {
    
    @Nullable
    private Integer id;

    @Size(min = 1, max = 80, message = "Please provide valid subject")
    private String subject;

    @Size(min = 1, max = 500, message = "Please provide valid description")
    private String description;

    private String link;

    private String selectedColor;

}