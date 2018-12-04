package com.se.dces.cmm.ducache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.dces.cmm.ducache.actionlogservice.ActionLogService;
import com.se.dces.cmm.ducache.duservice.DUCacheService;
import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.model.DUCacheResponse;

@RestController
public class Controller {
	
	@Autowired
	private ActionLogService actionLogService;
	
	@Autowired
	private DUCacheService dUCacheService;
	
	@GetMapping(value = "/refresh")
	public DUCacheResponse updateDuCache() {
		return dUCacheService.updateDuCache();
	}
	
	@GetMapping(value = "/latest",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ActionLog getLatestActionLog() {
		return actionLogService.getLatestActionLog();
	}
	
	@GetMapping(value = "/health")
	public String health() {
		return "DU Cache Manager is up and running";
	}
}