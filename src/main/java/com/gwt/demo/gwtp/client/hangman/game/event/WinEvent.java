package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.GwtEvent;

public class WinEvent extends GwtEvent<WinHandler> {
	@Override
	public Type<WinHandler> getAssociatedType() {
		return null;
	}

	@Override
	protected void dispatch(WinHandler handler) {
		handler.onWin(this);
	}

}
