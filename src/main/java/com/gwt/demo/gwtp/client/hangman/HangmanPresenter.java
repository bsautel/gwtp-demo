package com.gwt.demo.gwtp.client.hangman;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.hangman.HangmanPresenter.HangmanProxy;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class HangmanPresenter extends Presenter<HangmanView, HangmanProxy> {
	private final AppPresenter appPresenter;

	@ProxyStandard
	@NameToken(NameTokens.HANGMAN)
	public interface HangmanProxy extends ProxyPlace<HangmanPresenter> {
	}

	@Inject
	public HangmanPresenter(EventBus eventBus, HangmanView view,
			HangmanProxy proxy, AppPresenter appPresenter) {
		super(eventBus, view, proxy);
		this.appPresenter = appPresenter;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(appPresenter, AppPresenter.MAIN_SLOT, this);
	}
}
