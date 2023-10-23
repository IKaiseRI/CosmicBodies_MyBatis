package com.MyBatis.CosmicBodies.service;

import com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper;
import com.MyBatis.CosmicBodies.dto.SatelliteDto;
import com.MyBatis.CosmicBodies.entityMapper.SatelliteMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SatelliteService implements CommonService<SatelliteDto> {
    private final SatelliteBatisMapper satelliteBatisMapper;

    public SatelliteService(SatelliteBatisMapper satelliteBatisMapper) {
        this.satelliteBatisMapper = satelliteBatisMapper;
    }

    public List<SatelliteDto> findAll() {
        return satelliteBatisMapper.findAll().stream()
                .map(SatelliteMapper::toDto)
                .collect(Collectors.toList());
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
