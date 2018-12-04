package com.se.dces.cmm.ducache.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.se.dces.cmm.ducache.model.DUDefinition;

@Repository
public interface DUDefinitionRepository extends MongoRepository<DUDefinition, String> {
	
	public DUDefinition findDUDefinitionByGuid (String guid);
	
	public void deleteByGuid(String guid);
	
	//@Query(fields = "{'guid' : 1}")
	//public List<DUDefinition> findAllGuid();
}
