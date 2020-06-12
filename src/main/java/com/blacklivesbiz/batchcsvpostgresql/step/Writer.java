package com.blacklivesbiz.batchcsvpostgresql.step;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.blacklivesbiz.batchcsvpostgresql.dao.StateAndCityRepository;
import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public class Writer implements ItemWriter<StateAndCity> {
	private final StateAndCityRepository stateAndCityDao;
	  
	public Writer(StateAndCityRepository stateAndCityDao) {
	    this.stateAndCityDao = stateAndCityDao;
	}
	 
	@Override
	public void write(List<? extends StateAndCity> statesAndCities) throws Exception {
		stateAndCityDao.insert(statesAndCities);
	}	
}
