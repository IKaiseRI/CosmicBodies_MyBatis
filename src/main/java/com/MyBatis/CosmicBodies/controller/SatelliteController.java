package com.MyBatis.CosmicBodies.controller;

import com.MyBatis.CosmicBodies.dto.SatelliteDto;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import com.MyBatis.CosmicBodies.service.SatelliteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {
    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @GetMapping
    public List<SatelliteDto> getAllSatellites() {
        return satelliteService.findAll();
    }

    @GetMapping("/{id}")
    public SatelliteDto getSatelliteById(@PathVariable Long id) {
        return satelliteService.findById(id);
    }

    @PostMapping
    public void createSatellite(@RequestBody SatelliteDto satelliteDto) {
        satelliteService.insert(satelliteDto);
    }

    @PutMapping("/{id}")
    public void updateSatellite(@PathVariable Long id, @RequestBody SatelliteDto satelliteDto) {
        satelliteDto.setId(id);
        satelliteService.update(satelliteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSatellite(@PathVariable Long id) {
        satelliteService.deleteById(id);
    }
}
