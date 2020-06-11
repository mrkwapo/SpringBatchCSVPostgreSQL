package dao;

import java.util.List;

import model.StateAndCity;

public interface StateAndCityDao {
	public void insert(List<? extends StateAndCity> statesAndCities);
	List<StateAndCity> loadAllStatesAndCities();
}
