package com.itstep.firstapp.cars.models;

import java.util.HashSet;

public class CarModel {

    private final HashSet<ColorModel> colors = new HashSet<ColorModel>();

    public void addColor(ColorModel color) {
        colors.add(color);
        if (!color.getCars().contains(this)) {
            color.addCar(this);
        }
    }

    public void removeColor(ColorModel color) {
        colors.remove(color);
        if (color.getCars().contains(this)) {
            color.removeCar(this);
        }
    }

    public HashSet<ColorModel> getColors() {
        return colors;
    }

    private BrandModel brand;

    public BrandModel getBrand() {
        return brand;
    }

    public void setBrand(BrandModel brand) {
        this.brand = brand;
    }

    public CarModel() {}
    public CarModel(String name) {
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
