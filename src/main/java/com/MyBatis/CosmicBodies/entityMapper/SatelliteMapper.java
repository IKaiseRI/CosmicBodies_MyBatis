package com.MyBatis.CosmicBodies.entityMapper;

import com.MyBatis.CosmicBodies.dto.SatelliteDto;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import org.springframework.stereotype.Component;

@Component
public class SatelliteMapper {

    public static SatelliteDto toDto(Satellite satellite) {
        return SatelliteDto.builder()
                .id(satellite.getId())
                .name(satellite.getName())
                .diameter(satellite.getDiameter())
                .distanceFromParentPlanet(satellite.getDistanceFromParentPlanet())
                .composition(satellite.getComposition())
                .planet(satellite.getPlanet() != null ? satellite.getPlanet().getName() : null)
                .build();
    }

    public static Satellite toEntity(SatelliteDto satelliteDto) {
        return Satellite.builder()
                .id(satelliteDto.getId())
                .name(satelliteDto.getName())
                .diameter(satelliteDto.getDiameter())
                .distanceFromParentPlanet(satelliteDto.getDistanceFromParentPlanet())
                .composition(satelliteDto.getComposition())
                .build();
    }


}
