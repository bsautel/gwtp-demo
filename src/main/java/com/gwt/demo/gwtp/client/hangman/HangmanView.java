package com.gwt.demo.gwtp.client.hangman;

import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwtplatform.mvp.client.View;

public interface HangmanView extends View {
	void startGame();

	void askCharacter(HangmanState state);

	void setPresenter(HangmanPresenter presenter);

	void displayHasWonMessage(HangmanState state);

	void displayHasLostMessage(HangmanState state);
}
