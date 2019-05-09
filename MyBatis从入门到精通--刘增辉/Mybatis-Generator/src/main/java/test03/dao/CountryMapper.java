package test03.dao;

import test03.model.Country;

public interface CountryMapper {
    Country selectByPrimaryKey(Integer id);
}