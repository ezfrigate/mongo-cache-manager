package com.se.dces.cmm.ducache.duservice;

import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.model.DUCacheResponse;

public interface DUCacheService {
	
	public DUCacheResponse updateDuCache();

	public boolean checkActionLogStatus(ActionLog actionLog);

	public ActionLog saveActionLogAsProcessing();

}
