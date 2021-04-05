package com.partola.csvuploader.factory;

import com.partola.csvuploader.action.AttributeActionLine;
import com.partola.csvuploader.action.CreateAction;
import com.partola.csvuploader.action.DeleteAction;
import com.partola.csvuploader.action.UnknownAction;
import com.partola.csvuploader.action.UpdateAction;
import com.partola.csvuploader.domain.CsvAction;
import com.partola.csvuploader.service.Action;
import org.springframework.stereotype.Component;

@Component
public class DefaultActionFactory implements ActionFactory {
	
	@Override
	public CsvAction create(AttributeActionLine attributeActionLine) {
		return switch (Action.get(attributeActionLine.getAction())) {
			case CREATE -> new CreateAction(attributeActionLine);
			case UPDATE -> new UpdateAction(attributeActionLine);
			case DELETE -> new DeleteAction(attributeActionLine);
			case UNKNOWN -> new UnknownAction(attributeActionLine);
		};
	}
}
