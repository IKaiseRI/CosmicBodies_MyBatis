package com.MyBatis.CosmicBodies.service;

import com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper;
import com.MyBatis.CosmicBodies.dto.SatelliteDto;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import com.MyBatis.CosmicBodies.entityMapper.SatelliteMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SatelliteService {
    private final SatelliteBatisMapper satelliteBatisMapper;
    private final SatelliteMapper satelliteMapper;

    public SatelliteService(SatelliteBatisMapper satelliteBatisMapper, SatelliteMapper satelliteMapper) {
        this.satelliteBatisMapper = satelliteBatisMapper;
        this.satelliteMapper = satelliteMapper;
    }

    public List<SatelliteDto> findAll() {
        return satelliteBatisMapper.findAll().stream()
                .map(satelliteMapper::toDto)
                .collect(Collectors.toList());
    }

    public SatelliteDto findById(Long id) {
        return satelliteMapper.toDto(satelliteBatisMapper.findById(id));
    }

    public void insert(SatelliteDto satelliteDto) {
        satelliteBatisMapper.insert(satelliteMapper.toEntity(satelliteDto));
    }

    public void update(SatelliteDto satelliteDto) {
        satelliteBatisMapper.update(satelliteMapper.toEntity(satelliteDto));
    }

    public void deleteById(Long id) {
        satelliteBatisMapper.deleteById(id);
    }
}
