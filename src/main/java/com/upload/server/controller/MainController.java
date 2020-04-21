package com.upload.server.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.upload.server.model.FileInfo;
import com.upload.server.service.MainService;
import com.upload.server.utils.Constants;
import reactor.core.publisher.Flux;

@RestController
public class MainController {

	@Autowired
	MainService mainService;
	
	@PostMapping(value = "/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Flux<FileInfo> handleUpload(@RequestPart("zipFile") FilePart filePart ) throws IOException{
		if(!filePart.filename().split("\\.")[1].equals("zip")) {
			return Flux.error(new Throwable(Constants.UPLOAD_ZIP));
		}
		return mainService.processFile(filePart).onErrorResume(throwable -> Flux.error(throwable));
	}

	@GetMapping(value = "/getAllInfo" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<FileInfo> getAllInfo(){
		return mainService.getAllInfo();
	}
}
