package step;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import model.StateAndCity;

public class Processor implements ItemProcessor<StateAndCity, StateAndCity> {
	 
	  private static final Logger log = LoggerFactory.getLogger(Processor.class);
	 
	  @Override
	  public StateAndCity process(StateAndCity stateandcity) throws Exception {
	    Random r = new Random();
	    

	    final String city = stateandcity.getCity().toUpperCase();
	    final String abbr = stateandcity.getAbbr().toUpperCase();
	    final String name = stateandcity.getName().toUpperCase();
	 
	    final StateAndCity fixedStateAndCity = new StateAndCity(r.nextLong(), city, abbr, name);
	 
	    log.info("Converting (" + stateandcity + ") into (" + fixedStateAndCity + ")");
	 
	    return fixedStateAndCity;
	  }
}
