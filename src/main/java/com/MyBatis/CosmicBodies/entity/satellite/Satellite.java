package com.MyBatis.CosmicBodies.entity.satellite;

import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.satellite.composition.Composition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Alias("satellites")
public class Satellite {
    private Long id;
    private String name;
    private double diameter;
    private double distanceFromParentPlanet;
    private Composition composition;
    private Planet planet;
}
