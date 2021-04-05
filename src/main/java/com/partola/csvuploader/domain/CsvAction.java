package com.partola.csvuploader.domain;

public interface CsvAction {
	
	void perform();
	
	void validate();
}
