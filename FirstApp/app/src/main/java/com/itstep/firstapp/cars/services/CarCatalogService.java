package com.itstep.firstapp.cars.services;

import com.itstep.firstapp.cars.repositories.BrandRepository;
import com.itstep.firstapp.cars.repositories.CarRepository;
import com.itstep.firstapp.cars.repositories.ColorRepository;

public class CarCatalogService {
    private final ColorRepository colorRepository;
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;

    public CarCatalogService() {
        this.colorRepository = ColorRepository.getInstance();
        this.carRepository = CarRepository.getInstance();
        this.brandRepository = BrandRepository.getInstance();
    }
}
