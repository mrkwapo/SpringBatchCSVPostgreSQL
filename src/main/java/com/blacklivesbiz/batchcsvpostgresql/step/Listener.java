package com.blacklivesbiz.batchcsvpostgresql.step;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import com.blacklivesbiz.batchcsvpostgresql.dao.StateAndCityRepository;
import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public class Listener extends JobExecutionListenerSupport  {
	private static final Logger log = LoggerFactory.getLogger(Listener.class);
	 
	private final StateAndCityRepository stateAndCityDao;
	 
	public Listener(StateAndCityRepository stateAndCityDao) {
	  this.stateAndCityDao = stateAndCityDao;
	}
	 
	@Override
	public void afterJob(JobExecution jobExecution) {
	  if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
	   log.info("Finish Job! Check the results");
	 
	   List<StateAndCity> statesAndCities = stateAndCityDao.loadAllStatesAndCities();
	 
	   for (StateAndCity stateAndCity : statesAndCities) {
	        log.info("Found <" + stateAndCity + "> in the database.");
	   }
	  }
	}
}
