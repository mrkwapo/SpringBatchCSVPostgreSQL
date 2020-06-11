package impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dao.StateAndCityDao;
import model.StateAndCity;

@Repository
	public class StateAndCityDaoImpl extends JdbcDaoSupport implements StateAndCityDao {
	 
	  @Autowired
	  DataSource dataSource;
	 
	  @PostConstruct
	  private void initialize() {
	    setDataSource(dataSource);
	  }
	 
	  @Override
	  public void insert(List<? extends StateAndCity> StatesAndCities) {
	    String sql = "INSERT INTO statesandcities " + "(id, city, abbr, state) VALUES (?, ?, ?, ?)";
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
}
