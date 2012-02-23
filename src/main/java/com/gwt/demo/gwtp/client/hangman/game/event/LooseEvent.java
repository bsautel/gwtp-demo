package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.GwtEvent;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseHandler.HasLooseHandler;

public class LooseEvent extends GwtEvent<LooseHandler> {
	private static Type<LooseHandler> TYPE;
	private final HangmanState state;

	private LooseEvent(HangmanState state) {
		this.state = state;
	}

	public HangmanState getState() {
		return state;
	}

	@Override
	public Type<LooseHandler> getAssociatedType() {
		return getType();
	}

	@Override
	protected void dispatch(LooseHandler handler) {
		handler.onLoose(this);
	}

	public static Type<LooseHandler> getType() {
		if (TYPE == null) {
			TYPE = new Type<LooseHandler>();
		}
		return TYPE;
	}

	public static void fire(HasLooseHandler source, HangmanState state) {
		source.fireEvent(new LooseEvent(state));
	}
}
