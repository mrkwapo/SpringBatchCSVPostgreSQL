package com.blacklivesbiz.batchcsvpostgresql.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public interface StateAndCityRepository extends MongoRepository<StateAndCity, String>{
	public void insert(List<? extends StateAndCity> statesAndCities);
	List<StateAndCity> loadAllStatesAndCities();
}
