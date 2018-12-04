package com.se.dces.cmm.ducache.actionlogservice;

import com.se.dces.cmm.ducache.model.ActionLog;

public interface ActionLogService {
	
	public ActionLog getLatestActionLog();

	public ActionLog saveActionLogToMongo(ActionLog actionLog);
}
