package com.MyBatis.CosmicBodies.entityMapper;

import com.MyBatis.CosmicBodies.dto.PlanetDto;
import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlanetMapper {

    public static PlanetDto toDto(Planet planet) {
        return PlanetDto.builder()
                .id(planet.getId())
                .name(planet.getName())
                .diameter(planet.getDiameter())
                .distanceFromStar(planet.getDistanceFromStar())
                .size(planet.getSize())
                .composition(planet.getComposition())
                .radius(planet.getRadius())
                .star(planet.getStar() != null ? planet.getStar().getName() : null)
                .numberOfSatellites(planet.getNumberOfSatellites())
                .satelliteList(planet.getSatelliteList().stream()
                        .map(Satellite::getName)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Planet toEntity(PlanetDto planetDto) {
        return Planet.builder()
                .id(planetDto.getId())
                .name(planetDto.getName())
                .diameter(planetDto.getDiameter())
                .distanceFromStar(planetDto.getDistanceFromStar())
                .numberOfSatellites(planetDto.getNumberOfSatellites())
                .size(planetDto.getSize())
                .composition(planetDto.getComposition())
                .radius(planetDto.getRadius())
                .build();
    }
}
