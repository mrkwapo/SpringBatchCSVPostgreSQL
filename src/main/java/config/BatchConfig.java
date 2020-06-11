package config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import dao.StateAndCityDao;
import model.StateAndCity;
import step.Listener;
import step.Processor;
import step.Reader;
import step.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	  public JobBuilderFactory jobBuilderFactory;
	 
	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;
	 
	  @Autowired
	  public StateAndCityDao stateAndCityDao;
	 
	  @Bean
	  public Job job() {
	    return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(stateAndCityDao))
	        .flow(step1()).end().build();
	  }
	  
	  @Bean
	    public TaskExecutor taskExecutor(){
	        SimpleAsyncTaskExecutor asyncTaskExecutor= new SimpleAsyncTaskExecutor("spring_batch");
	        asyncTaskExecutor.setConcurrencyLimit(5);
	        return asyncTaskExecutor;
	    }
	  
	  @Bean
	  public Step step1() {
	    return stepBuilderFactory.get("step1").<StateAndCity, StateAndCity>chunk(20000)
	        .reader(Reader.reader("uscities.csv"))
	        .processor(new Processor()).writer(new Writer(stateAndCityDao))
	        .taskExecutor(taskExecutor()).build();
	  }
}
