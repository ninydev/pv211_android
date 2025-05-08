package com.itstep.firstapp.cars.repositories;

import com.itstep.firstapp.cars.models.BrandModel;

import java.util.HashSet;

public class BrandRepository implements RepositoryInterface<BrandModel> {

    private final HashSet<BrandModel> brands = new HashSet<>();

    public HashSet<BrandModel> getAll() {
        return brands;
    }

    private BrandRepository() {
        // private constructor to prevent instantiation
    }

    public static BrandRepository getInstance() {
        return BrandRepository.instance;
    }

    private static BrandRepository instance;




}
