package com.MyBatis.CosmicBodies.dto;

import com.MyBatis.CosmicBodies.entity.satellite.composition.Composition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SatelliteDto {
    private Long id;
    private String name;
    private double diameter;
    private double distanceFromParentPlanet;
    private Composition composition;
    private String planet;
}
