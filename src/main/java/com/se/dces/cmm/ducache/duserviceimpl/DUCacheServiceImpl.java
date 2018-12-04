package com.se.dces.cmm.ducache.duserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.se.dces.cmm.ducache.actionlogservice.ActionLogService;
import com.se.dces.cmm.ducache.duservice.DUCacheService;
import com.se.dces.cmm.ducache.duservicemanager.DUCacheServiceManager;
import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.model.ActionLogStatus;
import com.se.dces.cmm.ducache.model.DUCacheResponse;
import com.se.dces.cmm.ducache.timestamp.TimeStamp;

@Service
public class DUCacheServiceImpl implements DUCacheService {

	@Autowired
	private ActionLogService actionLogService;
	
	@Autowired
	private DUCacheServiceManager dUCacheServiceManager;
	
	@Autowired
	private TimeStamp timeStamp;
	
	@Override
	public DUCacheResponse updateDuCache() {
		ActionLog latestActionLog = new ActionLog();
		latestActionLog = actionLogService.getLatestActionLog();
		if(latestActionLog == null || checkActionLogStatus(latestActionLog)) {
			latestActionLog = this.saveActionLogAsProcessing();
			dUCacheServiceManager.runSchedulerManager(latestActionLog);
			return new DUCacheResponse(HttpStatus.ACCEPTED.value(), "request accepted.");
		}else {
			return new DUCacheResponse(HttpStatus.TOO_MANY_REQUESTS.value(), "caching is already in progress.");
		}
	}
	
	
	@Override
	public boolean checkActionLogStatus(ActionLog actionLog) {
		return (actionLog.getStatus().equals(ActionLogStatus.COMPLETED) || actionLog.getStatus().equals(ActionLogStatus.FAILED));
	}
	
	
	@Override
	public ActionLog saveActionLogAsProcessing() {
		ActionLog newActionLog = new ActionLog();
		ActionLog savedActionLog = new ActionLog();
			newActionLog.setStatus(ActionLogStatus.PROCESSING);
			newActionLog.setTimeStamp(timeStamp.createTimeStamp());
			newActionLog.setProjectCode("ALL");
		savedActionLog = actionLogService.saveActionLogToMongo(newActionLog);
		return savedActionLog;
	}
}
