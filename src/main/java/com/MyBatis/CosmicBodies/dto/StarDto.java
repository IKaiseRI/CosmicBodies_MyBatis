package com.MyBatis.CosmicBodies.dto;

import com.MyBatis.CosmicBodies.entity.star.characteristic.Color;
import com.MyBatis.CosmicBodies.entity.star.characteristic.Size;
import com.MyBatis.CosmicBodies.entity.star.characteristic.Type;
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
public class StarDto {
    private Long id;
    private String name;
    private Size size;
    private Type type;
    private Color color;
    private int numberOfPlanets;
    private List<String> listOfPlanets = new ArrayList<>();
}
