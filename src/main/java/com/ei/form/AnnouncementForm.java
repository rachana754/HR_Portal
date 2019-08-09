package com.ei.form;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ei.enums.AnnouncementColor;

@Data
public class AnnouncementForm {
    
    @Nullable
    private Integer id;

    @Size(min = 1, max = 50, message = "Please provide valid subject")
    private String subject;

    @Size(min = 1, max = 400, message = "Please provide valid description")
    private String description;

    private String link;

    private String selectedColor;

}