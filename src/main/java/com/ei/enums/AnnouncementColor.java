package com.ei.enums;

/**
 * @author sjean-baptiste
 */

public enum AnnouncementColor {
    PURPLE("Purple"),
    ORANGE("Orange"),
    BLUE("Blue");

    private String description;

    private AnnouncementColor(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
