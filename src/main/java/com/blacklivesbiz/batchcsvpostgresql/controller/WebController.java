package com.blacklivesbiz.batchcsvpostgresql.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebController {
	@Autowired
	  JobLauncher jobLauncher;
	 
	  @Autowired
	  Job job;
	  
	  @Autowired
	  private RestTemplate restTemplate;
	  
	  @RequestMapping("/admin/runjob")
	  public String handle() throws Exception {
	    Logger logger = LoggerFactory.getLogger(this.getClass());
	    try {
	      JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	          .toJobParameters();
	      jobLauncher.run(job, jobParameters);
	    } catch (Exception e) {
	      logger.info(e.getMessage());
	    }
	    return "Done! Check Console Window for more details";
	  }
}
