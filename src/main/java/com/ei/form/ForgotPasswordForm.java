package com.ei.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ForgotPasswordForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 12, message = "Please enter a valid username")
    private String username2;

}
