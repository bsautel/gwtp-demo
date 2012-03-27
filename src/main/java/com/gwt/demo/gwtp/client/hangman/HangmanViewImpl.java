package com.gwt.demo.gwtp.client.hangman;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.demo.gwtp.client.hangman.drawer.HangmanDrawer;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwtplatform.mvp.client.ViewImpl;

public class HangmanViewImpl extends ViewImpl implements HangmanView {
	protected interface Binder extends UiBinder<HTMLPanel, HangmanViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	@UiField
	protected Label currentWordLabel, remainingTriesLabel, winLabel,
			looseLabel, typeACharacterLabel;
	@UiField
	protected Button restartButton;
	@UiField(provided = true)
	protected Canvas hangmanCanvas;
	private boolean characterExpected = false;
	private HangmanPresenter presenter;
	private HangmanDrawer drawer;
	private HandlerRegistration keypressHandler;
	private HTMLPanel panel;

	public HangmanViewImpl() {
		if (Canvas.isSupported()) {
			hangmanCanvas = Canvas.createIfSupported();
		}
		panel = BINDER.createAndBindUi(this);
		drawer = new HangmanDrawer();
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
		drawer.draw(hangmanCanvas, HangmanPresenter.TOTAL_TRIES);
	}

	@Override
	public void askCharacter(HangmanState state) {
		characterExpected = true;
		currentWordLabel.setText(state.getCurrentWord());
		remainingTriesLabel.setText(String.valueOf(state.getRemainingTries()));
		winLabel.setVisible(false);
		looseLabel.setVisible(false);
		typeACharacterLabel.setVisible(true);
		drawer.draw(hangmanCanvas, state.getRemainingTries());
		startWaitingKeyPressEvent();
	}

	private void startWaitingKeyPressEvent() {
		keypressHandler = RootPanel.get().addDomHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (characterExpected) {
					char character = event.getCharCode();
					if ((character >= 'a' && character <= 'z')
							|| (character >= 'A' && character <= 'Z')) {
						stopWaitingForCharacter();
						presenter.onCharacterRead(character);
					}
				}
			}
		}, KeyPressEvent.getType());
	}

	@Override
	public void stopWaitingForCharacter() {
		characterExpected = false;
		keypressHandler.removeHandler();
		keypressHandler = null;
		typeACharacterLabel.setVisible(false);
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
		drawer.draw(hangmanCanvas, 0);
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
