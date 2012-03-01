package com.gwt.demo.gwtp.client.hangman;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwtplatform.mvp.client.ViewImpl;

public class HangmanViewImpl extends ViewImpl implements HangmanView {
	protected interface Binder extends UiBinder<FocusPanel, HangmanViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	@UiField
	protected FocusPanel panel;
	@UiField
	protected Label currentWordLabel, remainingTriesLabel, winLabel,
			looseLabel, typeACharacterLabel;
	@UiField
	protected Button restartButton;
	private boolean characterExpected = false;
	private HangmanPresenter presenter;

	public HangmanViewImpl() {
		BINDER.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	@Override
	public void startGame() {
		characterExpected = false;
		winLabel.setVisible(false);
		looseLabel.setVisible(false);
		remainingTriesLabel.setVisible(true);
		currentWordLabel.setVisible(true);
		typeACharacterLabel.setVisible(false);
	}

	@Override
	public void askCharacter(HangmanState state) {
		characterExpected = true;
		currentWordLabel.setText(state.getCurrentWord());
		remainingTriesLabel.setText(String.valueOf(state.getRemainingTries()));
		winLabel.setVisible(false);
		looseLabel.setVisible(false);
		typeACharacterLabel.setVisible(true);
	}

	@Override
	public void displayHasWonMessage(HangmanState state) {
		currentWordLabel.setText(state.getWordToFind());
		remainingTriesLabel.setVisible(false);
		winLabel.setVisible(true);
	}

	@Override
	public void displayHasLostMessage(HangmanState state) {
		currentWordLabel.setText(state.getWordToFind());
		remainingTriesLabel.setVisible(false);
		looseLabel.setVisible(true);
	}

	@UiHandler("panel")
	protected void onKeyPressed(KeyPressEvent event) {
		if (characterExpected) {
			char character = event.getCharCode();
			if ((character >= 'a' && character <= 'z')
					|| (character >= 'A' && character <= 'Z')) {
				characterExpected = false;
				typeACharacterLabel.setVisible(false);
				presenter.onCharacterRead(character);
			}
		}
	}

	@UiHandler("restartButton")
	protected void onRestart(ClickEvent event) {
		presenter.restart();
	}

	@Override
	public void setPresenter(HangmanPresenter presenter) {
		this.presenter = presenter;
	}
}
