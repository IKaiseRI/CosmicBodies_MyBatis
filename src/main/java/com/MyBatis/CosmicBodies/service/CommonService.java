package com.MyBatis.CosmicBodies.service;

import java.util.List;

public interface CommonService<ELEMENT> {

    List<ELEMENT> findAll();

    ELEMENT findById(Long id);

    void deleteById(Long id);

    void create(ELEMENT element);

    void update(ELEMENT element);
}
