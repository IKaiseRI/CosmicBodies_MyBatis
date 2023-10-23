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

@Mapper
public interface SatelliteBatisMapper {
    String findAll = "SELECT * FROM satellites";
    String findById = "SELECT * FROM satellites WHERE id = #{id}";
    String deleteById = "DELETE FROM satellites WHERE id = #{id}";
    String insert = "INSERT INTO satellites(name, diameter, distance_from_parent_planet, composition, planet) " +
            "VALUES(#{name}, #{diameter}, #{distanceFromParentPlanet}, #{composition}, #{planet.id})";
    String update = "UPDATE satellites " +
            "SET name = #{name}, diameter = #{diameter}, distance_from_parent_planet = #{distanceFromParentPlanet}, " +
            "composition = #{composition}, planet = #{planet.id} " +
            "WHERE id = #{id}";
    String findAllByPlanet = "SELECT * FROM satellites WHERE planet = #{id}";

    @Select(findAllByPlanet)
    List<Satellite> findAllByPlanet(Long id);

    @Select(findAll)
    @Result(
            property = "planet",
            column = "planet",
            javaType = Planet.class,
            one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findById"))
    List<Satellite> findAll();

    @Select(findById)
    @Result(
            property = "planet",
            column = "planet",
            javaType = Planet.class,
            one = @One(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findById"))
    Satellite findById(Long id);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Satellite satellite);

    @Update(update)
    void update(Satellite satellite);

    @Delete(deleteById)
    void deleteById(Long id);
}
