package com.itstep.firstapp.cars.repositories;

import com.itstep.firstapp.cars.models.CarModel;

import java.util.HashSet;

public class CarRepository implements RepositoryInterface<CarModel> {

    private final HashSet<CarModel> cars = new HashSet<>();

    public HashSet<CarModel> getAll() {
        return cars;
    }

    private CarRepository() {
        // private constructor to prevent instantiation
    }

    public static CarRepository getInstance() {
        return CarRepository.instance;
    }

    private static CarRepository instance;
}
