package com.MyBatis.CosmicBodies.service;

import com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper;
import com.MyBatis.CosmicBodies.batisMapper.StarBatisMapper;
import com.MyBatis.CosmicBodies.dto.StarDto;
import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.star.Star;
import com.MyBatis.CosmicBodies.entityMapper.StarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarService implements CommonService<StarDto> {
    private final StarBatisMapper starBatisMapper;
    private final PlanetBatisMapper planetBatisMapper;

    public StarService(StarBatisMapper starBatisMapper, PlanetBatisMapper planetBatisMapper) {
        this.starBatisMapper = starBatisMapper;
        this.planetBatisMapper = planetBatisMapper;
    }

    public List<StarDto> findAll() {
        return starBatisMapper.findAll().stream()
                .map(StarMapper::toDto)
                .collect(Collectors.toList());
    }

    public StarDto findById(Long id) {
        return StarMapper.toDto(starBatisMapper.findById(id));
    }

    public void deleteById(Long id) {
        starBatisMapper.deleteById(id);
    }

    public void create(StarDto starDto) {
        starBatisMapper.insert(StarMapper.toEntity(starDto));
    }

    public void update(StarDto starDto) {
        starBatisMapper.update(StarMapper.toEntity(starDto));
    }

    public void addPlanetToStar(Long starId, Long planetId) {
        Star star = starBatisMapper.findById(starId);
        Planet planet = planetBatisMapper.findById(planetId);

        star.addPlanet(planet);
        planetBatisMapper.update(planet);
    }
}
