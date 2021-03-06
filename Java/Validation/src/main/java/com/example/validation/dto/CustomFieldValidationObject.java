package com.example.validation.dto;

import com.example.validation.annotations.CustomFieldValidation;

public class CustomFieldValidationObject {
    @CustomFieldValidation
    private String name;

    public CustomFieldValidationObject() {
    }

    public CustomFieldValidationObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
