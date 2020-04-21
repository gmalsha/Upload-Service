package com.upload.server.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import reactor.core.publisher.Mono;

@Document
public class FileInfo {

    @Id
    private String id;
	private String zipFileName;
    private String extractedFileName;
    private String fileContent;
    private String countryName;
    private String status;
    private Date date;
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZipFileName() {
		return zipFileName;
	}
	public void setZipFileName(String zipFileName) {
		this.zipFileName = zipFileName;
	}
	public String getExtractedFileName() {
		return extractedFileName;
	}
	public void setExtractedFileName(String extractedFileName) {
		this.extractedFileName = extractedFileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName2) {
		this.countryName = countryName2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


}
