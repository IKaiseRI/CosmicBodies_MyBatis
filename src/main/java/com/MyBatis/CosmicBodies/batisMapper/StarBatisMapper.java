package com.MyBatis.CosmicBodies.batisMapper;

import com.MyBatis.CosmicBodies.entity.star.Star;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StarBatisMapper {
    String findAll = "SELECT * FROM stars";
    String findById = "SELECT * FROM stars WHERE id = #{id}";
    String deleteById = "DELETE FROM stars Where id = #{id}";
    String insert = "INSERT INTO stars (name, size, type, color, number_of_planets) " +
            "VALUES (#{name}, #{size}, #{type}, #{color}, #{numberOfPlanets})";
    String update = "UPDATE stars " +
            "SET name = #{name}, " +
            "    size = #{size}, " +
            "    type = #{type}, " +
            "    color = #{color}, " +
            "    number_of_planets = #{numberOfPlanets} " +
            "WHERE id = #{id}";

    @Select(findAll)
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "listOfPlanets",
                    column = "id", javaType = List.class,
                    many = @Many(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findAllByStar")
            )
    })
    List<Star> findAll();

    @Select(findById)
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "listOfPlanets",
                    column = "id", javaType = List.class,
                    many = @Many(select = "com.MyBatis.CosmicBodies.batisMapper.PlanetBatisMapper.findAllByStar")
            )
    })
    Star findById(Long id);

    @Insert(insert)
    void insert(Star star);

    @Update(update)
    void update(Star star);

    @Delete(deleteById)
    void deleteById(Long id);
}
