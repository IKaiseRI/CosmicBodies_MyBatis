package com.MyBatis.CosmicBodies.controller;

import com.MyBatis.CosmicBodies.dto.PlanetDto;
import com.MyBatis.CosmicBodies.service.PlanetService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public List<PlanetDto> findAll() {
        return planetService.findAll();
    }

    @GetMapping("/{id}")
    public PlanetDto findById(@PathVariable Long id) {
        return planetService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody PlanetDto planetDto) {
        planetService.create(planetDto);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody PlanetDto planetDto
    ) {
        planetDto.setId(id);
        planetService.update(planetDto);
    }

    @PutMapping("/{planetId}/add-satellite/{satelliteId}")
    public void addSatelliteToPlanet(
            @PathVariable Long planetId,
            @PathVariable Long satelliteId
    ) {
        planetService.addSatelliteToPlanet(planetId, satelliteId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        planetService.deleteById(id);
    }
}
