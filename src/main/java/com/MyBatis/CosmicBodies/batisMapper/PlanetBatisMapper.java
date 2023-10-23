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

@Mapper
public interface PlanetBatisMapper {

    String findAll = "SELECT * FROM planets";
    String findById = "SELECT * FROM planets WHERE id = #{id}";
    String deleteById = "DELETE FROM planets WHERE id = #{id}";
    String insert = "INSERT INTO planets (name, diameter, radius, distance_from_star, size, composition, star, number_of_satellites) " +
            "VALUES (#{name}, #{diameter}, #{radius}, #{distanceFromStar}, #{size}, #{composition}, #{star.id} #{numberOfSatellites})";
    String update = "UPDATE planets SET name = #{name}, diameter = #{diameter}, radius = #{radius}, " +
            "distance_from_star = #{distanceFromStar}, size = #{size}, composition = #{composition}, " +
            "star = #{star.id}, number_of_satellites = #{numberOfSatellites} WHERE id = #{id}";

    String findAllByStar = "SELECT * FROM planets WHERE star = #{id}";

    @Select(findAllByStar)
    List<Planet> findAllByStar(Long id);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Planet planet);

    @Select(findById)
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

    @Select(findAll)
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

    @Update(update)
    void update(Planet planet);

    @Delete(deleteById)
    void deleteById(Long id);
}
