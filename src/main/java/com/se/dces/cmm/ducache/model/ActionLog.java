package com.se.dces.cmm.ducache.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DU-Cache-ActionLog")
public class ActionLog {
	
	private String _id;
	
	private double timeStamp;
	
	private ActionLogStatus status;
	
	private String projectCode;

	private List<String> addedDus;
	
	private List<String> deletedDus;
	
	public double getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(double timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public List<String> getAddedDus() {
		return addedDus;
	}

	public void setAddedDus(List<String> addedDus) {
		this.addedDus = addedDus;
	}

	public List<String> getDeletedDus() {
		return deletedDus;
	}

	public void setDeletedDus(List<String> deletedDus) {
		this.deletedDus = deletedDus;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public ActionLogStatus getStatus() {
		return status;
	}

	public void setStatus(ActionLogStatus status) {
		this.status = status;
	}
	
	
}
