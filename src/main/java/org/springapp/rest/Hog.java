package org.springapp.rest;

import java.util.List;
import java.util.Vector;

import org.springapp.domain.MLBPark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hog")
public class Hog {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String eatTheMemory() {
		System.out.println(" java.lang.OutOfMemoryError");
		System.out.println("java.lang.OutOfMemoryError");
		return new String("Done...");
	}	
	
	public void EatMemory() {
		Vector v = new Vector();
		try {
			while (true) {
				byte b[] = new byte[10000000];
				v.add(b);
				Runtime rt = Runtime.getRuntime();
				System.out.println("free memory: " + rt.freeMemory());
			}
		} catch (java.lang.OutOfMemoryError e) {
			e.printStackTrace();
			System.out.println(" java.lang.OutOfMemoryError");
		}
	}
}
