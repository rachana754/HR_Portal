package com.ei.form;

import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class AlertForm {
    @Nullable
    private Integer id;

    @Size(min = 1, max = 50, message = "Please provide subject")
    private String subject;

    @Size(min = 1, message = "Please provide description")
    private String description;

}