package com.blacklivesbiz.batchcsvpostgresql.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.blacklivesbiz.batchcsvpostgresql.dao.StateAndCityRepository;
import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

@Repository
public class StateAndCityRepositoryImpl extends JdbcDaoSupport implements StateAndCityRepository {
	 
	 @Autowired
	 MongoTemplate mongoTemplate;
	 
	 @Autowired
	 StateAndCityRepositoryImpl repository;
	 
	 @Autowired
	 DataSource dataSource;
	 
	 @PostConstruct
	 private void initialize() {
	   setDataSource(dataSource);
	 }
	 
	 public void addData(List<? extends StateAndCity> StatesAndCities) {
		 System.out.println("Adding data");
		 repository.save(new StateAndCity());
		 }
		 
	 
	 
	 
	 
	 @Override
	 public void insert(List<? extends StateAndCity> StatesAndCities) {
	    String sql = "INSERT INTO statesandcities " + "(id, city, abbr, name) VALUES (?, ?, ?, ?)";
	    getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
	      public void setValues(PreparedStatement ps, int i) throws SQLException {
	        StateAndCity stateandcity = StatesAndCities.get(i);
	        ps.setLong(1, stateandcity.getId());
	        ps.setString(2, stateandcity.getCity());
	        ps.setString(3, stateandcity.getAbbr());
	        ps.setString(4, stateandcity.getName());
	      }
	 
	      public int getBatchSize() {
	        return StatesAndCities.size();
	      }
	    });
	 
	  }
	 
	  @Override
	  public List<StateAndCity> loadAllStatesAndCities() {
	    String sql = "SELECT * FROM statesandcities";
	    List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
	 
	    List<StateAndCity> result = new ArrayList<StateAndCity>();
	    for (Map<String, Object> row : rows) {
	    	StateAndCity stateandcity = new StateAndCity();
	    	stateandcity.setId((Long) row.get("id"));
	    	stateandcity.setCity((String) row.get("city"));
	    	stateandcity.setAbbr((String) row.get("abbr"));
	    	stateandcity.setName((String) row.get("name"));
	    	result.add(stateandcity);
	    }
	 
	    return result;
	  }

	@Override
	public <S extends StateAndCity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateAndCity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateAndCity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<StateAndCity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<StateAndCity> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<StateAndCity> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StateAndCity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends StateAndCity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends StateAndCity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends StateAndCity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends StateAndCity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
}
