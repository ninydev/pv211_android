package com.itstep.firstapp.cars.repositories;

import com.itstep.firstapp.cars.models.ColorModel;

import java.util.HashSet;

public class ColorRepository implements RepositoryInterface<ColorModel> {

    private final HashSet<ColorModel> colors = new HashSet<>();

    public HashSet<ColorModel> getAll() {
        return colors;
    }

    private ColorRepository() {
        // private constructor to prevent instantiation
    }

    public static ColorRepository getInstance() {
        return ColorRepository.instance;
    }

    private static ColorRepository instance;
}
