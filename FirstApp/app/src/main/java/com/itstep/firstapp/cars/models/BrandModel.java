package com.itstep.firstapp.cars.models;

import java.util.HashSet;

public class BrandModel {

    private HashSet<CarModel> cars = new HashSet<CarModel>();

    public void addCar(CarModel car) {
        cars.add(car);
        car.setBrand(this);
    }

    public void removeCar(CarModel car) {
        cars.remove(car);
        car.setBrand(null);
    }

    public HashSet<CarModel> getCars() {
        return cars;
    }

    public void setCars(HashSet<CarModel> cars) {
        this.cars = cars;
    }

    public BrandModel() {}
    public BrandModel(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
