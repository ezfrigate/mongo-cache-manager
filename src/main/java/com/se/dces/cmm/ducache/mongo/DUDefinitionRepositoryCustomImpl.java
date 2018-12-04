package com.se.dces.cmm.ducache.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.se.dces.cmm.ducache.model.DUDefinition;

@Repository
public class DUDefinitionRepositoryCustomImpl implements DUDefinitionRepositoryCustom{

	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public DUDefinitionRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<String> getAllGuid(){
		List<String> guidList = new ArrayList<>();
		Query query = new Query();
		query.fields().include("guid");
		List<DUDefinition> jsonStringObjectList = mongoTemplate.find(query, DUDefinition.class,"DU-Cache-DUs");
		
		jsonStringObjectList.forEach(guid->{
			guidList.add(guid.getGuid());
		});
		System.out.println( "List of Guids" + guidList);
		return guidList;
	}

}
