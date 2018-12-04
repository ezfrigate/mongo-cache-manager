package com.se.dces.cmm.ducache.duservicemanagerimpl;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.se.dces.cmm.ducache.actionlogservice.ActionLogService;
import com.se.dces.cmm.ducache.duservicemanager.DUCacheServiceManager;
import com.se.dces.cmm.ducache.model.ActionLog;
import com.se.dces.cmm.ducache.model.ActionLogStatus;
import com.se.dces.cmm.ducache.model.DUDefinition;
import com.se.dces.cmm.ducache.model.DoubleListObject;
import com.se.dces.cmm.ducache.mongo.DUDefinitionRepository;
import com.se.dces.cmm.ducache.mongo.DUDefinitionRepositoryCustom;

@Service
public class DUCacheServiceManagerImpl implements DUCacheServiceManager {
	
	//@Autowired
	//private DUDelimWSClientService dUDelimWSClientService;
	
	@Autowired
	private DUDefinitionRepository dUDefinitionRepository;
	
	@Autowired
	private DUDefinitionRepositoryCustom dUDefinitionRepositoryCustom;
	
	@Autowired
	private ActionLogService actionLogService;
	
	@Value("${du_list_dump_path}")
	private String duListDumpFile;
	
	private Unmarshaller unmarshaller;
	
	/*
	 * This is main method called by DUCacheService layer
	 * 
	 */
	@Override
	public void runSchedulerManager(ActionLog actionLog) {
		DoubleListObject doubleListObject = new DoubleListObject();
		//TODO: read file using the path
		
		//TODO: calculate whether du isLocalDU for newly added dus
		
		//String fileName = String.format(duListDumpFile, "ALL");
		//dUDelimWSClientService.dumpDUList("ALL",fileName);
		doubleListObject = this.updateDatabase("");
		actionLog.setAddedDus(doubleListObject.getNewList());
		System.out.println("new dus" + doubleListObject.getNewList());
		this.deleteDUsFromMongo(doubleListObject.getDeletedList());
		System.out.println("deleteddus" + doubleListObject.getDeletedList());
		this.updateActionLogAfterCompletion(actionLog, doubleListObject);
	}
	
	
	
	@Override 
	public void deleteDUsFromMongo(List<String> guids){
		guids.forEach(guid->{
			dUDefinitionRepository.deleteById(guid); 
		});
	}
	
	
	@Override
	public LinkedList<String> getExistingGuidList() {
		LinkedList<String> guidList = new LinkedList<>(dUDefinitionRepositoryCustom.getAllGuid());
		return guidList;
	}
	
	
	
	/*
	 * method to prepare unmarshaller
	 */
	private Unmarshaller getUnmarshaller() throws JAXBException {
		if(unmarshaller==null) {
			JAXBContext jc = JAXBContext.newInstance(DUDefinition.class);
			this.unmarshaller= jc.createUnmarshaller();
		}
		return this.unmarshaller;
	}
	
	
	
	/*
	 * method to parse xml file, returns 2 lists - deleted dus and newly added dus
	 */
	@Override
    public DoubleListObject updateDatabase(String fileName) {
    	LinkedList<String> existingDUsList = this.getExistingGuidList();
    	LinkedList<String> newDUsList = new LinkedList<>();
    	Path dumpPath = Paths.get("C:/DUCache/dulist_dump_21-NovSmall.xml");
    	XMLStreamReader xsr = null;
    	try(BufferedReader bufferReader = Files.newBufferedReader(dumpPath)){  		
    		XMLInputFactory xif = XMLInputFactory.newInstance();
    		xsr = xif.createXMLStreamReader(bufferReader);
    		xsr.nextTag();
    		Unmarshaller unmarshaller = getUnmarshaller();
    		while(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
    		    DUDefinition du = unmarshaller.unmarshal(xsr, DUDefinition.class).getValue();
    		    if(existingDUsList.contains(du.getGuid())== true) {
    		    	existingDUsList.remove(du.getGuid());
    		    }else {
    		    	newDUsList.add(du.getGuid());
    		    }
    		  dUDefinitionRepository.save(du);
    		}

    	}catch(Exception e){
    	    e.printStackTrace();
    	}finally {
    		
    	}
	    	DoubleListObject doubleListObject = new DoubleListObject();
	    	doubleListObject.setDeletedList(existingDUsList);
	    	doubleListObject.setNewList(newDUsList);
    	return doubleListObject;
    }

	
	
	@Override
	public ActionLog updateActionLogAfterCompletion(ActionLog newActionLog, DoubleListObject doubleListObject) {
			newActionLog.setStatus(ActionLogStatus.COMPLETED);
			newActionLog.setAddedDus(doubleListObject.getNewList());
			newActionLog.setDeletedDus(doubleListObject.getDeletedList());
			actionLogService.saveActionLogToMongo(newActionLog);
		return newActionLog;
	}
}
