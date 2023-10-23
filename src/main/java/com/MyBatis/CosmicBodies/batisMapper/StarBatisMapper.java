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

import static com.MyBatis.CosmicBodies.constant.StarSQLConstants.DELETE_BY_ID;
import static com.MyBatis.CosmicBodies.constant.StarSQLConstants.INSERT;
import static com.MyBatis.CosmicBodies.constant.StarSQLConstants.SELECT_ALL;
import static com.MyBatis.CosmicBodies.constant.StarSQLConstants.SELECT_BY_ID;
import static com.MyBatis.CosmicBodies.constant.StarSQLConstants.UPDATE;

@Mapper
public interface StarBatisMapper {

    @Select(SELECT_ALL)
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

    @Select(SELECT_BY_ID)
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

    @Insert(INSERT)
    void insert(Star star);

    @Update(UPDATE)
    void update(Star star);

    @Delete(DELETE_BY_ID)
    void deleteById(Long id);
}
