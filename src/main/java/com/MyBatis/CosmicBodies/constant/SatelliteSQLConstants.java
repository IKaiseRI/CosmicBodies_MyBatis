package com.MyBatis.CosmicBodies.constant;

public class SatelliteSQLConstants {
    public static final String SELECT_ALL = """
        SELECT * FROM satellites
        """;
    public static final String SELECT_BY_ID = """
        SELECT * FROM satellites WHERE id = #{id}
        """;
    public static final String DELETE_BY_ID = """
        DELETE FROM satellites WHERE id = #{id}
        """;

    public static final String SELECT_ALL_BY_PLANET = """
            SELECT * FROM satellites WHERE planet = #{id}
            """;

    public static final String INSERT = """
        INSERT INTO satellites (name, diameter, distance_from_parent_planet, composition, planet)
        VALUES (#{name}, #{diameter}, #{distanceFromParentPlanet}, #{composition}, #{planet.id})
        """;
    public static final String UPDATE = """
        UPDATE satellites
        SET name = #{name}, diameter = #{diameter}, distance_from_parent_planet = #{distanceFromParentPlanet},
            composition = #{composition}, planet = #{planet.id}
        WHERE id = #{id}
        """;
}
