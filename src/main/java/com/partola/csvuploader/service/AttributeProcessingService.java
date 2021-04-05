package com.partola.csvuploader.service;

import com.partola.csvuploader.action.AttributeActionLine;
import com.partola.csvuploader.domain.AttributeDO;
import com.partola.csvuploader.domain.CsvAction;
import com.partola.csvuploader.domain.ImportFileDO;
import com.partola.csvuploader.factory.ActionFactory;
import com.partola.csvuploader.factory.ObjectFactory;
import com.partola.csvuploader.repository.SuperRepository;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
class AttributeProcessingService implements ProcessingService {
	
	@Autowired
	private CsvFileReader<AttributeActionLine> csvFileReader;
	
	@Autowired
	private SuperRepository<AttributeDO> attributeRepository;
	
	@Autowired
	private SuperRepository<ImportFileDO> importFileRepository;
	
	@Autowired
	private ObjectFactory objectFactory;
	
	@Autowired
	private AutowireCapableBeanFactory beanFactory;
	
	@Autowired
	private ActionFactory actionFactory;
	
	@Override
	public ImportFileDO process(File file) {
		
		ImportFileDO importFileDO = objectFactory.createImportFileDO();
		final ImportFileDO importFileDOCreated = importFileRepository.create(importFileDO);
		
		Observable.just(file)
				.observeOn(Schedulers.io())
				.filter(csvFileReader::checkIsCsv)
				.filter(file1 -> csvFileReader.checkHeaders(file1, AttributeActionLine.class))
				.flatMap(fileLocal -> csvFileReader.read(fileLocal, AttributeActionLine.class))
				.map(actionFactory::create)
				.doOnNext(beanFactory::autowireBean)
				.doOnNext(CsvAction::validate)
				.forEach(CsvAction::perform);
		
		return importFileDOCreated;
	}
}
