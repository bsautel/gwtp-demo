package com.gwt.demo.gwtp.client.hangman.game.event;

import com.google.gwt.event.shared.GwtEvent;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterHandler.HasRequireCharacterHandler;

public class RequireCharacterEvent extends GwtEvent<RequireCharacterHandler> {
	private static Type<RequireCharacterHandler> TYPE;
	private final HangmanState state;

	private RequireCharacterEvent(HangmanState state) {
		this.state = state;
	}

	public HangmanState getState() {
		return state;
	}

	@Override
	public Type<RequireCharacterHandler> getAssociatedType() {
		return getType();
	}

	@Override
	protected void dispatch(RequireCharacterHandler handler) {
		handler.onRequireCharacter(this);
	}

	public static Type<RequireCharacterHandler> getType() {
		if (TYPE == null) {
			TYPE = new Type<RequireCharacterHandler>();
		}
		return TYPE;
	}

	public static void fireEvent(HasRequireCharacterHandler source,
			HangmanState state) {
		source.fireEvent(new RequireCharacterEvent(state));
	}
}
