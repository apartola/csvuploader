package com.partola.csvuploader.controller;

import com.partola.csvuploader.domain.ImportFileDO;
import com.partola.csvuploader.service.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
public class UploadController {
	
	@Autowired
	private ProcessingService processingService;
	
	@PostMapping("/csv")
	public ResponseEntity<String> upload(MultipartFile multipartFile) throws IOException {
		//validations
		final File file = new File("/tmp/userfileName");
		multipartFile.transferTo(file);
		ImportFileDO result = processingService.process(file);
		return ResponseEntity.of(Optional.of(result)).accepted().build();
	}
}
