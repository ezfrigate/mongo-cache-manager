package com.se.dces.cmm.ducache.model;

import java.util.List;

public class DoubleListObject {
	
	private List<String> newList;
	
	private List<String> deletedList;

	public List<String> getNewList() {
		return newList;
	}

	public void setNewList(List<String> newList) {
		this.newList = newList;
	}

	public List<String> getDeletedList() {
		return deletedList;
	}

	public void setDeletedList(List<String> deletedList) {
		this.deletedList = deletedList;
	}

}
