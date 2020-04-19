package com.upload.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.upload.server.service.FileUploadService;
import com.upload.server.utils.Constants;

import reactor.core.publisher.Flux;

@RestController
public class MainController {
	
	@Autowired
	FileUploadService fileUploadService;

	@PostMapping(value = "/upload")
	public Flux<String> handleUpload(@RequestPart("zipFile") FilePart filePart ){
		
		if(filePart.filename().split("\\")[1].equals("zip")) {
			return Flux.error(new Throwable(Constants.UPLOAD_ZIP));
			  }
		return fileUploadService.fileUpload(filePart);
		
	
		
		
		
	}
}
