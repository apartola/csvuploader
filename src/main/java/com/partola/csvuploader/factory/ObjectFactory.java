package com.partola.csvuploader.factory;

import com.partola.csvuploader.domain.ImportFileDO;
import org.springframework.stereotype.Component;

@Component
public class ObjectFactory {
	
	public ImportFileDO createImportFileDO() {
		return new ImportFileDO();
	}
}
