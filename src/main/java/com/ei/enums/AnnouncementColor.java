package com.ei.enums;

public enum AnnouncementColor {
    
    //Background color
    PURPLE("Purple", "#75354D"),
    ORANGE("Orange", "#F89C1C"),
    BLUE("Blue", "#777D9B"),
    WHITE("White", "#FFFFFF");
   
    private String description;
    private String htmlCode;
    
    private AnnouncementColor(String description, String htmlCode) {
        this.description = description;
        this.htmlCode = htmlCode;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getHTMLCode() {
        return htmlCode;
    }
    
}
