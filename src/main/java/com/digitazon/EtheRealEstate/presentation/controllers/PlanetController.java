package com.digitazon.EtheRealEstate.presentation.controllers;

import com.digitazon.EtheRealEstate.persistence.entities.Exohouse;
import com.digitazon.EtheRealEstate.persistence.entities.Planet;
import com.digitazon.EtheRealEstate.presentation.dto.ExohouseDTO;
import com.digitazon.EtheRealEstate.presentation.dto.PlanetDTO;
import com.digitazon.EtheRealEstate.services.ExohouseService;
import com.digitazon.EtheRealEstate.services.PlanetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanetController {


    @Autowired
    private ExohouseService exohouseService;
    @Autowired
    private PlanetService planetService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<PlanetDTO> getPlanets() {
        return planetService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public PlanetDTO getPlanetById(@PathVariable long id){
        return convertToDTO(planetService.getById(id));
    }

    @PostMapping
    public PlanetDTO createPlanet(@RequestBody PlanetDTO newPlanet) {
        Planet planet = convertToEntity(newPlanet);
        planet = planetService.create(planet);
        return convertToDTO(planet);
    }

   @PutMapping("/{id}")
   public PlanetDTO updatePlanet(@PathVariable long id, @RequestBody PlanetDTO updatePlanet) {
        Planet planet = convertToEntity(updatePlanet);
        planet = planetService.update(id, planet);
        return convertToDTO(planet);
    }
    @DeleteMapping("/{id}")
    public PlanetDTO deletePlanet(@PathVariable long id) {
        return convertToDTO(planetService.delete(id));
    }

    @GetMapping("/{id}/exohouse")
    public List<ExohouseDTO> getExohouses(@PathVariable long id){
        Planet planet = planetService.getById(id);
        return planet.getExohouses()
                .stream()
                .map(this::convertToExohouseDTO)
                .toList();
    }
    private PlanetDTO convertToDTO(Planet planet){
        return modelMapper.map(planet, PlanetDTO.class);
    }

    private Planet convertToEntity(PlanetDTO dto){
        return modelMapper.map(dto, Planet.class);
    }

    private ExohouseDTO convertToExohouseDTO(Exohouse exohouse) {
        return modelMapper.map(exohouse, ExohouseDTO.class);
    }

}