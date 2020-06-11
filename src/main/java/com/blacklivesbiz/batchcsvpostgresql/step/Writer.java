package com.blacklivesbiz.batchcsvpostgresql.step;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.blacklivesbiz.batchcsvpostgresql.dao.StateAndCityDao;
import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public class Writer implements ItemWriter<StateAndCity> {
	private final StateAndCityDao stateAndCityDao;
	  
	public Writer(StateAndCityDao stateAndCityDao) {
	    this.stateAndCityDao = stateAndCityDao;
	}
	 
	@Override
	public void write(List<? extends StateAndCity> statesAndCities) throws Exception {
		stateAndCityDao.insert(statesAndCities);
	}	
}
