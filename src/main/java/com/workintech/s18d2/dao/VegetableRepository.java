package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {

    @Query("SELECT v FROM Vegetable v ORDER BY price DESC ")
    List<Vegetable> descPriceForVegetable();

    @Query("SELECT v FROM Vegetable v ORDER BY price")
    List<Vegetable> ascPriceForVegetable();

    @Query("SELECT v FROM Vegetable v WHERE LOWER(v.name) LIKE LOWER (CONCAT('%',:name,'%'))")
    List<Vegetable> searchByName(String name);
}
