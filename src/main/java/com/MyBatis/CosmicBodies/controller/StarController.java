package com.MyBatis.CosmicBodies.controller;

import com.MyBatis.CosmicBodies.dto.StarDto;
import com.MyBatis.CosmicBodies.service.StarService;
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
@RequestMapping("/stars")
public class StarController {
    private final StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping
    public List<StarDto> findAll() {
        return starService.findAll();
    }

    @GetMapping("/{id}")
    public StarDto findById(@PathVariable Long id) {
        return starService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody StarDto starDto) {
        starService.create(starDto);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody StarDto starDto
    ) {
        starDto.setId(id);
        starService.update(starDto);
    }

    @PutMapping("/{starId}/add-planet/{planetId}")
    public void addPlanetToStar(
            @PathVariable Long starId,
            @PathVariable Long planetId
    ) {
        starService.addPlanetToStar(starId, planetId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        starService.deleteById(id);
    }
}
