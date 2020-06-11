package com.blacklivesbiz.batchcsvpostgresql.dao;

import java.util.List;

import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public interface StateAndCityDao {
	public void insert(List<? extends StateAndCity> statesAndCities);
	List<StateAndCity> loadAllStatesAndCities();
}
