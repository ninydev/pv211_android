package com.itstep.firstapp.cars.models;

import java.util.HashSet;

public class ColorModel {

    private final HashSet<CarModel> cars = new HashSet<CarModel>();

    public void addCar(CarModel car) {
        cars.add(car);
        if (!car.getColors().contains(this)) {
            car.addColor(this);
        }
    }

    public void removeCar(CarModel car) {
        cars.remove(car);
        if (car.getColors().contains(this)) {
            car.removeColor(this);
        }
    }

    public HashSet<CarModel> getCars() {
        return cars;
    }

    public ColorModel() {}

    public ColorModel(String name, String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String hexCode;

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
