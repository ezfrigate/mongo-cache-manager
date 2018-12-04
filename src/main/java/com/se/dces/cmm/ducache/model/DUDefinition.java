package com.se.dces.cmm.ducache.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DU-Cache-DUs")
@XmlRootElement(name="du")
public class DUDefinition {
	
	@Id
	private String guid;	
	
	private String parentGuid;	
	
	private String duCode;

	private String duBuild;
	
	private String duStatus;

	private String kbCode;
	
	private String kbVersion;	
	
	private String scope;	
	
	private String language;

	private String aliasCode;

	private String projectCode;
	
	private String projectVersion;
	
	private String buCode;	
	
	private String active;

	private String duVersion;
	
	private String stdVersion;	
	
	private String desc;	
	
	private String comment;	

	private String changeDate;	
	
	private String author;	
	
	private String country;
	
	private String scpType;

	private String scpPrefix;

	private short kbType;
	
	@XmlElement
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	@XmlElement(name="parent_guid")
	public String getParentGuid() {
		return parentGuid;
	}

	public void setParentGuid(String parentGuid) {
		this.parentGuid = parentGuid;
	}
	@XmlElement(name="du_code")
	public String getDuCode() {
		return duCode;
	}

	public void setDuCode(String duCode) {
		this.duCode = duCode;
	}
	@XmlElement(name="du_build")
	public String getDuBuild() {
		return duBuild;
	}

	public void setDuBuild(String duBuild) {
		this.duBuild = duBuild;
	}
	@XmlElement(name="du_status")
	public String getDuStatus() {
		return duStatus;
	}

	public void setDuStatus(String duStatus) {
		this.duStatus = duStatus;
	}
	@XmlElement(name="kb_code")
	public String getKbCode() {
		return kbCode;
	}

	public void setKbCode(String kbCode) {
		this.kbCode = kbCode;
	}
	@XmlElement(name="kb_version")
	public String getKbVersion() {
		return kbVersion;
	}

	public void setKbVersion(String kbVersion) {
		this.kbVersion = kbVersion;
	}
	@XmlElement
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	@XmlElement
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	@XmlElement(name="alias_code")
	public String getAliasCode() {
		return aliasCode;
	}

	public void setAliasCode(String aliasCode) {
		this.aliasCode = aliasCode;
	}
	@XmlElement(name="project_code")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	@XmlElement(name="project_version")
	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
	@XmlElement(name="bu_code")
	public String getBuCode() {
		return buCode;
	}

	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	@XmlElement
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	@XmlElement(name="du_version")
	public String getDuVersion() {
		return duVersion;
	}

	public void setDuVersion(String duVersion) {
		this.duVersion = duVersion;
	}
	@XmlElement
	public String getStdVersion() {
		return stdVersion;
	}

	public void setStdVersion(String stdVersion) {
		this.stdVersion = stdVersion;
	}
	@XmlElement
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@XmlElement
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@XmlElement
	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlElement
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement
	public String getScpType() {
		return scpType;
	}

	public void setScpType(String scpType) {
		this.scpType = scpType;
	}
	@XmlElement
	public String getScpPrefix() {
		return scpPrefix;
	}

	public void setScpPrefix(String scpPrefix) {
		this.scpPrefix = scpPrefix;
	}
	@XmlElement
	public short getKbType() {
		return kbType;
	}

	public void setKbType(short kbType) {
		this.kbType = kbType;
	}
	
	@Override
    public String toString() {
        return "DU:: guid="+this.guid+" ParentGuid=" + this.parentGuid + " DUCode=" + this.duCode +" DUBuild=" +this.duBuild+" DUStatus=" +this.duStatus;
    }
}
