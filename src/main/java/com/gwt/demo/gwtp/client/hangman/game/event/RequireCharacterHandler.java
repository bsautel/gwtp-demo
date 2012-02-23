package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface RequireCharacterHandler extends EventHandler {
	public interface HasRequireCharacterHandler extends HasHandlers {
		HandlerRegistration addRequireCharacterHandler(
				RequireCharacterHandler handler);
	}

	void onRequireCharacter(RequireCharacterEvent requireCharacterEvent);
}
