package com.MyBatis.CosmicBodies.constant;

public class StarSQLConstants {
    public static final String SELECT_ALL = """
        SELECT * FROM stars
        """;
    public static final String SELECT_BY_ID = """
        SELECT * FROM stars WHERE id = #{id}
        """;
    public static final String DELETE_BY_ID = """
        DELETE FROM stars WHERE id = #{id}
        """;

    public static final String INSERT = """
        INSERT INTO stars (name, size, type, color, number_of_planets)
        VALUES (#{name}, #{size}, #{type}, #{color}, #{numberOfPlanets})
        """;
    public static final String UPDATE = """
        UPDATE stars
        SET name = #{name}, size = #{size}, type = #{type}, color = #{color}, number_of_planets = #{numberOfPlanets}
        WHERE id = #{id}
        """;
}
