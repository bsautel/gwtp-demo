package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.EventHandler;

public interface WinHandler extends EventHandler {
	void onWin(WinEvent winEvent);
}
