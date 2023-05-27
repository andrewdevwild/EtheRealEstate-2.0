package com.digitazon.EtheRealEstate.services;

import com.digitazon.EtheRealEstate.persistence.entities.Planet;
import com.digitazon.EtheRealEstate.persistence.repositories.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepo planetRepo;
    public List<Planet> getAll() {
        return planetRepo.findAll();
    }
    public Planet getById(long id){
        Optional<Planet> optionalPlanet = planetRepo.findById(id);

        if(optionalPlanet.isEmpty()){
            throw new IllegalStateException("Planet not found");
        }
        return optionalPlanet.get();
    }
    public Planet create(Planet newPlanet){
        newPlanet = planetRepo.save(newPlanet);
        return newPlanet;
    }
    public Planet update(long id, Planet updatePlanet){
        Optional<Planet> optionalPlanet = planetRepo.findById(id);

        if(optionalPlanet.isEmpty()){
            throw new IllegalStateException("Planet not found");
        }
        Planet entityToUpdate = optionalPlanet.get();

        updatePlanet.setId(entityToUpdate.getId());
        updatePlanet = planetRepo.save(updatePlanet);
        return updatePlanet;
        }

        public Planet delete(long id) {
        Optional<Planet> optionalPlanet = planetRepo.findById(id);

        if(optionalPlanet.isEmpty()){
            throw new IllegalStateException("Planet not found");
        }
        Planet entityToDelete = optionalPlanet.get();
        planetRepo.delete(entityToDelete);
        return entityToDelete;
    }
}