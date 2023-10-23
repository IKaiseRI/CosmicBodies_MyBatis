package com.MyBatis.CosmicBodies.batisMapper;

import com.MyBatis.CosmicBodies.entity.satellite.Satellite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SatelliteBatisMapper {
    @Select("SELECT * FROM satellites")
    List<Satellite> findAll();

    @Select("SELECT * FROM satellites " +
            "WHERE id = #{id}")
    Satellite findById(Long id);

    @Insert("INSERT INTO satellites(name, diameter, distanceFromParentPlanet, composition, planet) " +
            "VALUES(#{name}, #{diameter}, #{distanceFromParentPlanet}, #{composition}, #{planet.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Satellite satellite);

    @Update("UPDATE satellites " +
            "SET name = #{name}, diameter = #{diameter}, distanceFromParentPlanet = #{distanceFromParentPlanet}, " +
            "composition = #{composition}, planet = #{planet.id} " +
            "WHERE id = #{id}")
    void update(Satellite satellite);

    @Delete("DELETE FROM satellites WHERE id = #{id}")
    void deleteById(Long id);
}
