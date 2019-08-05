package com.ei.form;

import javax.validation.constraints.Size;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ei.enums.AnnouncementColor;

@Data
public class AnnouncementForm {

    @NotEmpty
    @Size(min = 1, max = 50, message = "Please provide valid subject")
    private String subject;

    @NotEmpty
    @Size(min = 1, max = 400, message = "Please provide valid description")
    private String description;

    @NotEmpty
    @Size(min = 1, max = 30, message = "Please provide valid link")
    private String link;

    @NotNull(message = "Please select a color")
    private AnnouncementColor selectedColor;

}