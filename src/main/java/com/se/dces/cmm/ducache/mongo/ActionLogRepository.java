package com.se.dces.cmm.ducache.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.se.dces.cmm.ducache.model.ActionLog;

@Repository
public interface ActionLogRepository extends MongoRepository<ActionLog, String> {

	public ActionLog findFirstByOrderByTimeStampDesc();
}
