package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> ascPriceForVegetable() {
        return vegetableRepository.ascPriceForVegetable();
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(long id) {
        Optional<Vegetable> vegetableById = vegetableRepository.findById(id);
        if(vegetableById.isPresent()){
            return vegetableById.get();
        }else {
            throw new RuntimeException(id+"'li vegetable bulunamadı!");
        }
    }

    @Override
    public List<Vegetable> descPriceForVegetable() {
        return vegetableRepository.descPriceForVegetable();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }
    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable remove(long id) {
        Vegetable willRemoveVegetable=findById(id);
        vegetableRepository.delete(willRemoveVegetable);
        return willRemoveVegetable;
    }
}
