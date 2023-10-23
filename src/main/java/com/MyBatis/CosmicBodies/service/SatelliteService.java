package com.MyBatis.CosmicBodies.service;

import com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper;
import com.MyBatis.CosmicBodies.dto.SatelliteDto;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import com.MyBatis.CosmicBodies.entityMapper.SatelliteMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SatelliteService {
    private final SatelliteBatisMapper satelliteBatisMapper;

    public SatelliteService(SatelliteBatisMapper satelliteBatisMapper) {
        this.satelliteBatisMapper = satelliteBatisMapper;
    }

    public List<SatelliteDto> findAll() {
        List<Satellite> satellites = satelliteBatisMapper.findAll();

        List<SatelliteDto> satelliteDtoList = new ArrayList<>();

        for (Satellite satellite : satellites) {
            satelliteDtoList.add(SatelliteMapper.toDto(satellite));
        }
        return satelliteDtoList;
/*        return satelliteBatisMapper.findAll().stream()
                .map(SatelliteMapper::toDto)
                .collect(Collectors.toList());*/
    }

    public SatelliteDto findById(Long id) {
        return SatelliteMapper.toDto(satelliteBatisMapper.findById(id));
    }

    public void create(SatelliteDto satelliteDto) {
        satelliteBatisMapper.insert(SatelliteMapper.toEntity(satelliteDto));
    }

    public void update(SatelliteDto satelliteDto) {
        satelliteBatisMapper.update(SatelliteMapper.toEntity(satelliteDto));
    }

    public void deleteById(Long id) {
        satelliteBatisMapper.deleteById(id);
    }
}
