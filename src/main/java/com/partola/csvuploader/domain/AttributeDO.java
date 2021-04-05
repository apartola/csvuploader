package com.partola.csvuploader.domain;

import lombok.Data;

@Data
public class AttributeDO {
	
	private String id;
	
	private String name;
	
	private String value;
	
	private Integer counter;
	
	private Integer additionalField;
}
