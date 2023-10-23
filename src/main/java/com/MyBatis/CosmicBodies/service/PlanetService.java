package com.MyBatis.CosmicBodies.service;

import com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper;
import com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper;
import com.MyBatis.CosmicBodies.dto.PlanetDto;
import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import com.MyBatis.CosmicBodies.entityMapper.PlanetMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService implements CommonService<PlanetDto> {
    private final PlanetBatisMapper planetBatisMapper;
    private final SatelliteBatisMapper satelliteBatisMapper;

    public PlanetService(PlanetBatisMapper planetBatisMapper, SatelliteBatisMapper satelliteBatisMapper) {
        this.planetBatisMapper = planetBatisMapper;
        this.satelliteBatisMapper = satelliteBatisMapper;
    }

    public List<PlanetDto> findAll() {
        return planetBatisMapper.findAll().stream()
                .map(PlanetMapper::toDto)
                .collect(Collectors.toList());
    }

    public PlanetDto findById(Long id) {
        return PlanetMapper.toDto(planetBatisMapper.findById(id));
    }

    public void create(PlanetDto planetDto) {
        planetBatisMapper.insert(PlanetMapper.toEntity(planetDto));
    }

    public void update(PlanetDto planetDto) {
        planetBatisMapper.update(PlanetMapper.toEntity(planetDto));
    }

    public void deleteById(Long id) {
        planetBatisMapper.deleteById(id);
    }

    public void addSatelliteToPlanet(Long planetId, Long satelliteId) {
        Planet planet = planetBatisMapper.findById(planetId);
        Satellite satellite = satelliteBatisMapper.findById(satelliteId);

        planet.addSatellite(satellite);
        satelliteBatisMapper.update(satellite);
    }
}
