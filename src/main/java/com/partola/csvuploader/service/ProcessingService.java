package com.partola.csvuploader.service;

import com.partola.csvuploader.domain.ImportFileDO;

import java.io.File;

public interface ProcessingService {
	
	ImportFileDO process(File file);
}
