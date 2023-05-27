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
@RequestMapping("/exohouse")
@CrossOrigin(origins = "https://localhost:3000")
public class ExohouseController {

    @Autowired
    private ExohouseService exohouseService;
    @Autowired
    private PlanetService planetService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ExohouseDTO> getExohouses() {
        return exohouseService.getAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ExohouseDTO getExohouseById(@PathVariable long id) {
        return convertToDTO(exohouseService.getById(id));
    }

    @PostMapping
    public ExohouseDTO addExohouse (@RequestBody ExohouseDTO newExohouse) {
        Exohouse exohouse = convertToEntity(newExohouse);
        exohouse = exohouseService.create(exohouse);
        return convertToDTO(exohouse);
    }

    @DeleteMapping("/{id}")
    public ExohouseDTO deleteExohouse (@PathVariable long id) {
        return convertToDTO(exohouseService.delete(id));
    }

    @GetMapping ("/{id}/planet")
    public PlanetDTO getPlanet (@PathVariable long id) {
        Exohouse exohouse = exohouseService.getById(id);
        return convertToPlanetDTO(exohouse.getPlanet());
    }

    @PutMapping ("/{id}")
    public ExohouseDTO updateExohouse (@PathVariable long id, @RequestBody ExohouseDTO updateExohouse){

        Exohouse exohouse = convertToEntity(updateExohouse);
        exohouse = exohouseService.update(id,exohouse);

        return  convertToDTO(exohouse);
    }

    private ExohouseDTO convertToDTO(Exohouse exohouse){
        return modelMapper.map(exohouse, ExohouseDTO.class);
    }
    private Exohouse convertToEntity(ExohouseDTO dto){
        Exohouse exohouse = modelMapper.map(dto, Exohouse.class);
        Planet exohousePlanet = planetService.getById(dto.getIdPlanet());
        exohouse.setPlanet(exohousePlanet);
        return exohouse;
    }

    private PlanetDTO convertToPlanetDTO (Planet planet){
        return modelMapper.map(planet, PlanetDTO.class);
    }
}
