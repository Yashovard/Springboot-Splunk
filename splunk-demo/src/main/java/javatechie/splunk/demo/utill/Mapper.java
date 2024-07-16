package javatechie.splunk.demo.utill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	
	public static String mapTOJsonString(Object object)
	{
		try {
			return new ObjectMapper().writeValueAsString(object);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
