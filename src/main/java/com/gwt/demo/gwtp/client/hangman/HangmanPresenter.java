package com.gwt.demo.gwtp.client.hangman;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Random;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.hangman.HangmanPresenter.HangmanProxy;
import com.gwt.demo.gwtp.client.hangman.game.HangmanGame;
import com.gwt.demo.gwtp.client.hangman.game.HangmanState;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.LooseHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.RequireCharacterHandler;
import com.gwt.demo.gwtp.client.hangman.game.event.WinEvent;
import com.gwt.demo.gwtp.client.hangman.game.event.WinHandler;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class HangmanPresenter extends Presenter<HangmanView, HangmanProxy> {
	private static final String[] WORDS = { "INTERNET", "CARRIAGE", "COMPUTER",
			"LANGUAGE", "KEYBORD", "BROWSER" };
	private final AppPresenter appPresenter;
	private HangmanGame game;

	@ProxyStandard
	@NameToken(NameTokens.HANGMAN)
	public interface HangmanProxy extends ProxyPlace<HangmanPresenter> {
	}

	@Inject
	public HangmanPresenter(EventBus eventBus, HangmanView view,
			HangmanProxy proxy, AppPresenter appPresenter) {
		super(eventBus, view, proxy);
		this.appPresenter = appPresenter;
		view.setPresenter(this);
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		play();
	}

	private void play() {
		initGame();
		getView().startGame();
		game.startPlaying();
	}

	private void initGame() {
		String randomWord = WORDS[Random.nextInt(WORDS.length)];
		game = new HangmanGame(randomWord, 5);
		game.addRequireCharacterHandler(new RequireCharacterHandler() {
			@Override
			public void onRequireCharacter(RequireCharacterEvent event) {
				askCharacter(event.getState());
			}
		});
		game.addWinHandler(new WinHandler() {
			@Override
			public void onWin(WinEvent event) {
				displayHasWonMessage(event.getState());
			}
		});
		game.addLooseHandler(new LooseHandler() {
			@Override
			public void onLoose(LooseEvent event) {
				displayHasLostMessage(event.getState());
			}
		});
	}

	private void askCharacter(HangmanState state) {
		getView().askCharacter(state);
	}

	private void displayHasWonMessage(HangmanState state) {
		getView().displayHasWonMessage(state);
	}

	private void displayHasLostMessage(HangmanState state) {
		getView().displayHasLostMessage(state);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(appPresenter, AppPresenter.MAIN_SLOT, this);
	}

	public void onCharacterRead(char character) {
		game.setReadCharacter(Character.toUpperCase(character));
	}

	public void restart() {
		play();
	}
}
