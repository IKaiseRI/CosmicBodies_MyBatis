package com.MyBatis.CosmicBodies.entityMapper;

import com.MyBatis.CosmicBodies.dto.StarDto;
import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.star.Star;

import java.util.stream.Collectors;

public class StarMapper {

    public static StarDto toDto(Star star) {
        return StarDto.builder()
                .id(star.getId())
                .size(star.getSize())
                .color(star.getColor())
                .name(star.getName())
                .type(star.getType())
                .numberOfPlanets(star.getNumberOfPlanets())
                .listOfPlanets(star.getListOfPlanets().stream()
                        .map(Planet::getName)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Star toEntity(StarDto starDto) {
        return Star.builder()
                .id(starDto.getId())
                .size(starDto.getSize())
                .color(starDto.getColor())
                .name(starDto.getName())
                .type(starDto.getType())
                .numberOfPlanets(starDto.getNumberOfPlanets())
                .build();
    }
}
