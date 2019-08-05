package com.ei.form;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
//tellHR Form
@Data
public class TellHRForm {
    @NotEmpty(message="Please input something")
    private String subject;
    
    @NotEmpty(message="Please hang up and try again")
    private String message;
}