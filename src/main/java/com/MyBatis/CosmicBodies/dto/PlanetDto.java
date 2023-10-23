package com.MyBatis.CosmicBodies.dto;

import com.MyBatis.CosmicBodies.entity.planet.PlanetType;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanetDto {
    private Long id;
    private String name;
    private double diameter;
    private double radius;
    private double distanceFromStar;
    private PlanetType planetType;
    private int numberOfSatellites;
    private List<String> satelliteList = new ArrayList<>();
}
