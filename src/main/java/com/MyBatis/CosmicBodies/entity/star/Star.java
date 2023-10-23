package com.MyBatis.CosmicBodies.entity.star;

import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.star.characteristic.Size;
import com.MyBatis.CosmicBodies.entity.star.characteristic.Color;
import com.MyBatis.CosmicBodies.entity.star.characteristic.Type;
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
public class Star {
    private Long id;
    private String name;
    private Size size;
    private Type type;
    private Color color;
    private int numberOfPlanets;
  //  private List<Planet> listOfPlanets = new ArrayList<>();
}
