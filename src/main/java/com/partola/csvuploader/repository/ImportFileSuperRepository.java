package com.partola.csvuploader.repository;

import com.partola.csvuploader.domain.ImportFileDO;
import org.springframework.stereotype.Repository;

@Repository
public class ImportFileSuperRepository implements SuperRepository<ImportFileDO> {
	
	@Override
	public ImportFileDO get(String id) {
		System.out.println("getting from repository");
		return null;
	}
	
	@Override
	public ImportFileDO create(ImportFileDO attributeDO) {
		System.out.println("creating in repository");
		return attributeDO;
	}
	
	@Override
	public ImportFileDO update(ImportFileDO attributeDO) {
		System.out.println("updating in repository");
		return null;
	}
	
	@Override
	public ImportFileDO delete(ImportFileDO attributeDO) {
		System.out.println("deleting from repository");
		return null;
	}
}
