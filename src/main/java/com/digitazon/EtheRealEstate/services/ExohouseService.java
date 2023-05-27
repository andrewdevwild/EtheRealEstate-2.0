package com.digitazon.EtheRealEstate.services;

import com.digitazon.EtheRealEstate.persistence.entities.Exohouse;
import com.digitazon.EtheRealEstate.persistence.repositories.ExohouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExohouseService {

    @Autowired
    private ExohouseRepo exohouseRepo;

    public List<Exohouse> getAll(){
        return exohouseRepo.findAll();
    }

    public Exohouse getById(long id){
        Optional<Exohouse> optionalExohouse = exohouseRepo.findById(id);

        if(optionalExohouse.isEmpty()){
            throw new IllegalStateException("Exohouse not found");
        }

        return optionalExohouse.get();
    }

    public Exohouse create(Exohouse newExohouse){
        if (newExohouse.getPlanet() == null ){
            throw new IllegalStateException("Planet must not be null");

        }

        newExohouse = exohouseRepo.save(newExohouse);
        return newExohouse;
    }

    public Exohouse update(long id,Exohouse updateExohouse){
        if (updateExohouse.getPlanet() == null){
            throw new IllegalStateException("Planet must not be null");
        }
        Optional<Exohouse> optionalExohouse = exohouseRepo.findById(id);
        if(optionalExohouse.isEmpty()){
            throw new IllegalStateException("Exohouse not found");
        }
        Exohouse entityToUpdate = optionalExohouse.get();

        updateExohouse.setId(entityToUpdate.getId());

        updateExohouse = exohouseRepo.save(updateExohouse);

        return updateExohouse;
    }

    public Exohouse delete(long id) {
        Optional<Exohouse> optionalExohouse = exohouseRepo.findById(id);

        if(optionalExohouse.isEmpty()){
            throw new IllegalStateException("Exohouse not found");
        }
        Exohouse entityToDelete = optionalExohouse.get();

        exohouseRepo.delete(entityToDelete);

        return entityToDelete;
    }
}
