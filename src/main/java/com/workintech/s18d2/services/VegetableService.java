package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findAll();
    Vegetable findById(long id);
    List<Vegetable> descPriceForVegetable();
    List<Vegetable> ascPriceForVegetable();
    Vegetable save(Vegetable vegetable);
    List<Vegetable> searchByName(String name);
    Vegetable remove(long id);

}
