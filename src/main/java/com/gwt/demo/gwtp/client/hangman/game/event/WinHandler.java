package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface WinHandler extends EventHandler {
	public interface HasWinHandler extends HasHandlers {
		HandlerRegistration addWinHandler(WinHandler handler);
	}

	void onWin(WinEvent winEvent);
}
