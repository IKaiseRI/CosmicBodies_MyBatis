package com.MyBatis.CosmicBodies.constant;

public class PlanetSQLConstants {
    public static final String SELECT_ALL = """
            SELECT * FROM planets
            """;
    public static final String SELECT_BY_ID = """
            SELECT * FROM planets WHERE id = #{id}
            """;
    public static final String DELETE_BY_ID = """
            DELETE FROM planets WHERE id = #{id}
            """;

    public static final String SELECT_ALL_BY_STAR = """
            SELECT * FROM planets WHERE star = #{id}
            """;
    public static final String INSERT = """
            INSERT INTO planets (name, diameter, radius, distance_from_star, size, composition, star, number_of_satellites)
            VALUES (#{name}, #{diameter}, #{radius}, #{distanceFromStar}, #{size}, #{composition}, #{star.id}, #{numberOfSatellites})
            """;
    public static final String UPDATE = """
            UPDATE planets
            SET name = #{name}, diameter = #{diameter}, radius = #{radius},
                distance_from_star = #{distanceFromStar}, size = #{size}, composition = #{composition},
                star = #{star.id}, number_of_satellites = #{numberOfSatellites}
            WHERE id = #{id}
            """;
}
