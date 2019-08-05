package com.ei.enums;

public enum DataType {
    STRING("string"), 
    INTEGER("integer"), 
    BOOLEAN("boolean"),
    LIST_STRING("list_string");
    
    private String description;
    
    private DataType(String description) {
        this.description = description;
    }
    
    public String getSubject() {
        return description;
    }
    
}
