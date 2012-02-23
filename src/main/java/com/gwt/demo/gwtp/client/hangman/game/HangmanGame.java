package com.gwt.demo.gwtp.client.hangman.game;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseHandler.HasLooseHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterHandler.HasRequireCharacterHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.WinEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.WinHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.WinHandler.HasWinHandler;

public class HangmanGame implements HasWinHandler, HasLooseHandler,
		HasRequireCharacterHandler {
	private final HandlerManager handlerManager = new HandlerManager(this);
	private final HangmanComputer computer;
	private HangmanState state;

	public HangmanGame(String wordToFind, int triesCount) {
		computer = new HangmanComputer();
		state = initializeState(wordToFind, triesCount);
		if (hasWon()) {
			throw new IllegalArgumentException(
					"The entered state is already completed. Player has won.");
		}
		if (hasLost()) {
			throw new IllegalArgumentException(
					"It remains 0 tries, you cannot play, you have already lost!");
		}
	}

	private HangmanState initializeState(String wordToFind, int triesCount) {
		StringBuilder currentWordBuilder = new StringBuilder();
		for (int i = 0; i < wordToFind.length(); i++) {
			currentWordBuilder.append("*");
		}
		return new HangmanState(wordToFind, currentWordBuilder.toString(),
				triesCount);
	}

	public void startPlaying() {
		RequireCharacterEvent.fireEvent(this, state);
	}

	public void setReadCharacter(char character) {
		state = computer.compute(state, character);
		if (hasWon()) {
			WinEvent.fire(this, state);
		} else if (hasLost()) {
			LooseEvent.fire(this, state);
		} else {
			RequireCharacterEvent.fireEvent(this, state);
		}
	}

	private boolean hasWon() {
		return state.getCurrentWord().equals(state.getWordToFind());
	}

	private boolean hasLost() {
		return state.getRemainingTries() == 0;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}

	@Override
	public HandlerRegistration addWinHandler(WinHandler handler) {
		return handlerManager.addHandler(WinEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addLooseHandler(LooseHandler handler) {
		return handlerManager.addHandler(LooseEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addRequireCharacterHandler(
			RequireCharacterHandler handler) {
		return handlerManager.addHandler(RequireCharacterEvent.getType(),
				handler);
	}
}
