package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface LooseHandler extends EventHandler {
	public interface HasLooseHandler extends HasHandlers {
		HandlerRegistration addLooseHandler(LooseHandler handler);
	}

	void onLoose(LooseEvent looseEvent);
}
