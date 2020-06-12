package com.blacklivesbiz.batchcsvpostgresql.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 


import lombok.Data;

@Data
@Document(collection = "states")
public class StateAndCity {
	
	@Id
	private long id;
	private String city;
	private String abbr;
	private String name;
	
	public StateAndCity() {		
	}

	public StateAndCity(long id, String city, String abbr, String name) {
		this.id = id;
		this.city = city;
		this.abbr = abbr;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	  public String toString() {
	    return String.format("StateAndCity[id=%d , city='%s', abbr='%s', name='%s']", id, city, abbr, name);
	  }
	
}
