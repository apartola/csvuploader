package com.partola.csvuploader.repository;

import com.partola.csvuploader.domain.AttributeDO;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeSuperRepository implements SuperRepository<AttributeDO> {
	
	@Override
	public AttributeDO get(String id) {
		System.out.println("getting from repository");
		return null;
	}
	
	@Override
	public AttributeDO create(AttributeDO attributeDO) {
		System.out.println("creating in repository");
		return attributeDO;
	}
	
	@Override
	public AttributeDO update(AttributeDO attributeDO) {
		System.out.println("updating in repository");
		return attributeDO;
	}
	
	@Override
	public AttributeDO delete(AttributeDO attributeDO) {
		System.out.println("deleting from repository");
		return attributeDO;
	}
}
