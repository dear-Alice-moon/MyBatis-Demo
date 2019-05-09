package test04.dao;

import test04.model.Country;

public interface CountryMapper {
    Country selectByPrimaryKey(Integer id);
}