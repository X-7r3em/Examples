package com.example.exceptionhandling.services;

import com.example.exceptionhandling.dtos.Car;

public interface CarService {

    Car createService(Car car);

    Car createProxy(Car car);

}
