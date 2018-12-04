package com.se.dces.cmm.ducache.actionlogserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dces.cmm.ducache.actionlogservice.ActionLogService;
import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.mongo.ActionLogRepository;

@Service
public class ActionLogServiceImpl implements ActionLogService{
	
	@Autowired
	private ActionLogRepository actionLogRepository;
	
	@Override
	public ActionLog getLatestActionLog() {
		return actionLogRepository.findFirstByOrderByTimeStampDesc();
	}
	
	@Override
	public ActionLog saveActionLogToMongo(ActionLog actionLog) {
		return actionLogRepository.save(actionLog);
	}
}
