package com.ei.constants;

/***
 * @author acox
 * 
 *         Fields declared are constants where each one is the name of a config. This makes it easier to standardize the
 *         config names for usage across the application and makes it easier to edit in a centralized location.
 */
public interface ConfigNames {
    interface Home { 
        class TellHR { 
            public static final String ALLOWED_SUBJECTS = "home.tell_hr.allowed_subjects";
            public static final String DISPLAY = "home.tell_hr.display";
        }
        
    }
}