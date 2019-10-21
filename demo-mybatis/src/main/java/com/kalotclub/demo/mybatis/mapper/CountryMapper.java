package com.kalotclub.demo.mybatis.mapper;

import com.kalotclub.demo.mybatis.model.Country;

import java.util.List;

/**
 * Date: 2019-08-31 10:00
 *
 * @author hongchen.cao
 */
public interface CountryMapper {
    List<Country> selectAll();
}
