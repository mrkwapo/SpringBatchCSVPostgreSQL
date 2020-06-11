package com.blacklivesbiz.batchcsvpostgresql.step;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.blacklivesbiz.batchcsvpostgresql.model.StateAndCity;

public class Reader {
	public static FlatFileItemReader<StateAndCity> reader(String path) {
	    FlatFileItemReader<StateAndCity> reader = new FlatFileItemReader<StateAndCity>();
	 
	    reader.setResource(new ClassPathResource(path));
	    reader.setLineMapper(new DefaultLineMapper<StateAndCity>() {
	      {
	        setLineTokenizer(new DelimitedLineTokenizer() {
	          {
	            setNames(new String[] { "id", "city", "abbr","name" });
	          }
	        });
	        setFieldSetMapper(new BeanWrapperFieldSetMapper<StateAndCity>() {
	          {
	            setTargetType(StateAndCity.class);
	          }
	        });
	      }
	    });
	    return reader;
	  }
}
