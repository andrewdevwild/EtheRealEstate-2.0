package com.digitazon.EtheRealEstate.persistence.repositories;

import com.digitazon.EtheRealEstate.persistence.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet,Long> {
}
