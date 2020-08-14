package org.example.validationexample.dto;

import javax.validation.constraints.NotNull;

public class Car {
    @NotNull
    private String make;

    public Car() {
    }

    public Car(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
