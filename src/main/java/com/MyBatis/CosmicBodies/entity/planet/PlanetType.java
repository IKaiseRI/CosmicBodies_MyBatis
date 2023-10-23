package com.MyBatis.CosmicBodies.entity.planet;

import com.MyBatis.CosmicBodies.entity.planet.tipisation.Size;
import com.MyBatis.CosmicBodies.entity.planet.tipisation.Composition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanetType {
    private Size size;
    private Composition composition;
}
