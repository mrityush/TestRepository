package com.restservices.app.dao.interfaces;

import com.restservices.app.domains.BaseEntity;

/**
 * Created by mj on 25/5/16.
 */
public interface BaseDao<T extends BaseEntity> {

    void save(T t);

    void update(T t);

    T get(Long id);

}
