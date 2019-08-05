package com.ei.form;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * LoginForm holds values for the login text fields to validate proper data, and compare with the database.
 * 
 * @author bstout
 *
 */
@Data
public class LoginForm {

    @Size(min = 4, max = 12, message = "Please provide valid username")
    private String username;

    @Size(min = 8, message = "Please provide valid password")
    private String password;

}
