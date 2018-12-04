package com.se.dces.cmm.ducache.duservicemanager;

import java.util.LinkedList;
import java.util.List;

import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.model.DoubleListObject;

public interface DUCacheServiceManager {

	public void runSchedulerManager(ActionLog actionLog);

	public void deleteDUsFromMongo(List<String> dUList);

	public LinkedList<String> getExistingGuidList();

	public DoubleListObject updateDatabase(String fileName);

	public ActionLog updateActionLogAfterCompletion(ActionLog newActionLog, DoubleListObject doubleListObject);

}
