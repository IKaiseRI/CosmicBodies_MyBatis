package com.MyBatis.CosmicBodies.batisMapper;

import com.MyBatis.CosmicBodies.entity.planet.Planet;
import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.DELETE_BY_ID;
import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.INSERT;
import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.SELECT_ALL;
import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.SELECT_ALL_BY_PLANET;
import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.SELECT_BY_ID;
import static com.MyBatis.CosmicBodies.constant.SatelliteSQLConstants.UPDATE;

@Mapper
public interface SatelliteBatisMapper {
    @Select(SELECT_ALL_BY_PLANET)
    List<Satellite> findAllByPlanet(Long id);

    @Select(SELECT_ALL)
    @Result(
            property = "planet",
            column = "planet",
            javaType = Planet.class,
            one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findById"))
    List<Satellite> findAll();

    @Select(SELECT_BY_ID)
    @Result(
            property = "planet",
            column = "planet",
            javaType = Planet.class,
            one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findById"))
    Satellite findById(Long id);

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Satellite satellite);

    @Update(UPDATE)
    void update(Satellite satellite);

    @Delete(DELETE_BY_ID)
    void deleteById(Long id);
}
