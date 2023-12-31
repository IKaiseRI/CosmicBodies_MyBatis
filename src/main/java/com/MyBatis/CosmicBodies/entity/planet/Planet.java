package com.MyBatis.CosmicBodies.entity.planet;

import com.MyBatis.CosmicBodies.entity.planet.tipisation.Composition;
import com.MyBatis.CosmicBodies.entity.planet.tipisation.Size;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import com.MyBatis.CosmicBodies.entity.star.Star;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Planet {
    private Long id;
    private String name;
    private double diameter;
    private double radius;
    private double distanceFromStar;
    private Size size;
    private Composition composition;
    private int numberOfSatellites;
    private Star star;
    private List<Satellite> satelliteList = new ArrayList<>();

    public void addSatellite(Satellite satellite) {
        satellite.setPlanet(this);
        satelliteList.add(satellite);
    }
}
