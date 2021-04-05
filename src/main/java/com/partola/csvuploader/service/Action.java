package com.partola.csvuploader.service;

public enum Action {
	UNKNOWN,
	CREATE,
	UPDATE,
	DELETE;
	
	public static Action get(String str) {
		if (str != null && !str.isBlank()) {
			for (Action value : Action.values()) {
				if (str.equalsIgnoreCase(value.toString())) {
					return value;
				}
			}
		}
		return UNKNOWN;
	}
}
