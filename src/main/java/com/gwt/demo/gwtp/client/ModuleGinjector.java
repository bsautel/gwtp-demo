package com.gwt.demo.gwtp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwt.demo.gwtp.client.about.AboutPresenter;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.browser.BrowserPresenter;
import com.gwt.demo.gwtp.client.hangman.HangmanPresenter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ ModuleConfig.class })
public interface ModuleGinjector extends Ginjector {
	PlaceManager getPlaceManager();

	EventBus getEventBus();

	Provider<BrowserPresenter> getBrowserPresenter();

	Provider<AboutPresenter> getAboutPresenter();

	Provider<AppPresenter> getAppPresenter();

	Provider<HangmanPresenter> getHangmanPresenter();
}
