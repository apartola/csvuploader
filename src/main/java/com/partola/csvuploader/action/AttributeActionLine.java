package com.partola.csvuploader.action;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class AttributeActionLine {
	
	@CsvBindByName
	private String action;
	
	@CsvBindByName
	private String id;
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private String value;
	
	@CsvBindByName
	private Integer counter;
}
