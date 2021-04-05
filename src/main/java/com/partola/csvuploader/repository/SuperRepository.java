package com.partola.csvuploader.repository;

public interface SuperRepository<T> {
	
	T get(String id);
	
	T create(T attributeDO);
	
	T update(T attributeDO);
	
	T delete(T attributeDO);
}
