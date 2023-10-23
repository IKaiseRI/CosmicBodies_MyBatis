package com.MyBatis.CosmicBodies.batisMapper;

import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.star.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.DELETE_BY_ID;
import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.INSERT;
import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.SELECT_ALL;
import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.SELECT_ALL_BY_STAR;
import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.SELECT_BY_ID;
import static com.MyBatis.CosmicBodies.constant.PlanetSQLConstants.UPDATE;


@Mapper
public interface PlanetBatisMapper{

    @Select(SELECT_ALL_BY_STAR)
    List<Planet> findAllByStar(Long id);

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Planet planet);

    @Select(SELECT_BY_ID)
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "satelliteList",
                    column = "id", javaType = List.class,
                    many = @Many(select = "com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper.findAllByPlanet")
            ),
            @Result(
                    property = "star",
                    column = "star",
                    javaType = Star.class,
                    one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.StarBatisMapper.findById")
            )
    })
    Planet findById(Long id);

    @Select(SELECT_ALL)
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "satelliteList",
                    column = "id", javaType = List.class,
                    many = @Many(select = "com.MyBatis.CosmicBodies.batisMapper.SatelliteBatisMapper.findAllByPlanet")
            ),
            @Result(
                    property = "star",
                    column = "star",
                    javaType = Star.class,
                    one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.StarBatisMapper.findById")
            )
    })
    List<Planet> findAll();

    @Update(UPDATE)
    void update(Planet planet);

    @Delete(DELETE_BY_ID)
    void deleteById(Long id);
}
