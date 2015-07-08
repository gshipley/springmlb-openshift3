package org.springapp.rest;

import java.util.List;

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
@RequestMapping("/parks")
public class MLBParkResource {

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MLBPark> getAllParks() {
		return mongoTemplate.findAll(MLBPark.class);
	}
	@RequestMapping(value="within", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MLBPark> findParksWithin(@RequestParam("lat1") float lat1, @RequestParam("lon1") float lon1, @RequestParam("lat2") float lat2, @RequestParam("lon2") float lon2) {
		Query query = Query.query(Criteria.where("coordinates").within(new Box(new Point(lon2,lat2), new Point(lon1,lat1))));
		return mongoTemplate.find(query , MLBPark.class);
	}	
}
