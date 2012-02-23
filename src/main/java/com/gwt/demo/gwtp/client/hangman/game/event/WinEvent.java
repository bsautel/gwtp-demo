package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;

public class WinEvent extends GwtEvent<WinHandler> {
	private static Type<WinHandler> TYPE;
	private final HangmanState state;

	private WinEvent(HangmanState state) {
		this.state = state;
	}

	public HangmanState getState() {
		return state;
	}

	@Override
	public Type<WinHandler> getAssociatedType() {
		return getType();
	}

	@Override
	protected void dispatch(WinHandler handler) {
		handler.onWin(this);
	}

	public static Type<WinHandler> getType() {
		if (TYPE == null) {
			TYPE = new Type<WinHandler>();
		}
		return TYPE;
	}

	public static void fire(HasHandlers source, HangmanState state) {
		source.fireEvent(new WinEvent(state));
	}
}
