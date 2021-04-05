package com.partola.csvuploader.factory;

import com.partola.csvuploader.action.AttributeActionLine;
import com.partola.csvuploader.domain.CsvAction;

public interface ActionFactory {
	
	CsvAction create(AttributeActionLine attributeActionLine);
}
