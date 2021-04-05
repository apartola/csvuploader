package com.partola.csvuploader.action;

import com.partola.csvuploader.domain.AttributeDO;
import com.partola.csvuploader.domain.CsvAction;
import com.partola.csvuploader.repository.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class DeleteAction implements CsvAction {
	
	private final String action;
	
	private final String id;
	
	private final String name;
	
	private final String value;
	
	private final Integer counter;
	
	@Autowired
	private SuperRepository<AttributeDO> attributeRepository;
	
	public DeleteAction(AttributeActionLine attributeActionLine) {
		this.action = attributeActionLine.getAction();
		this.id = attributeActionLine.getId();
		this.name = attributeActionLine.getName();
		this.value = attributeActionLine.getValue();
		this.counter = attributeActionLine.getCounter();
	}
	
	public void perform() {
		System.out.println("Perform Delete");
	}
	
	@Override
	public void validate() {
		System.out.println("Validate Delete");
	}
}
