package com.itstep.firstapp.cars.repositories;

import java.util.HashSet;

public interface RepositoryInterface <Type> {
    HashSet<Type> getAll();

}
