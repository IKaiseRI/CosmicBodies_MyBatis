package com.MyBatis.CosmicBodies.entityMapper;

import com.MyBatis.CosmicBodies.dto.PlanetDto;
import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlanetMapper {

    public PlanetDto toDto(Planet planet) {
        return PlanetDto.builder()
                .id(planet.getId())
                .name(planet.getName())
                .diameter(planet.getDiameter())
                .distanceFromStar(planet.getDistanceFromStar())
                .planetType(planet.getPlanetType())
                .radius(planet.getRadius())
                .numberOfSatellites(planet.getNumberOfSatellites())
                .satelliteList(planet.getSatelliteList().stream()
                        .map(Satellite::getName)
                        .collect(Collectors.toList()))
                .build();
    }

    public Planet toEntity(PlanetDto planetDto) {
        return Planet.builder()
                .id(planetDto.getId())
                .name(planetDto.getName())
                .diameter(planetDto.getDiameter())
                .distanceFromStar(planetDto.getDistanceFromStar())
                .numberOfSatellites(planetDto.getNumberOfSatellites())
                .planetType(planetDto.getPlanetType())
                .radius(planetDto.getRadius())
                .satelliteList()
        .build();
    }
}
