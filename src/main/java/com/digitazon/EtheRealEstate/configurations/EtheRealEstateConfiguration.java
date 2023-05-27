package com.digitazon.EtheRealEstate.configurations;

import com.digitazon.EtheRealEstate.persistence.entities.Planet;
import com.digitazon.EtheRealEstate.presentation.dto.PlanetDTO;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class EtheRealEstateConfiguration {

   @Bean
    public ModelMapper modelMapper() {
       ModelMapper modelMapper = new ModelMapper();
       return modelMapper;
   }
//        // Creo l'istanza del model mapper che verrà restituita ai controller in autowired
//        ModelMapper modelMapper = new ModelMapper();
//
//        // Inizializza il property mapper per configurare il map di propietà "personalizzate"
//        TypeMap<Planet, PlanetDTO> planetToDTOMapper = modelMapper.createTypeMap(Planet.class, PlanetDTO.class);
//        planetToDTOMapper.addMapping(Planet::getDiscoveryDate, PlanetDTO::convertDateToString);
//
//        TypeMap<PlanetDTO,Planet> DTOToPlanetMapper = modelMapper.createTypeMap(PlanetDTO.class,Planet.class);
//        DTOToPlanetMapper.addMapping(PlanetDTO::convertDiscoveryDate,Planet::setDiscoveryDate);
//
//
//
//    }
   }