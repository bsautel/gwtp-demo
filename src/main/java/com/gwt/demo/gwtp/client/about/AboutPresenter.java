package com.gwt.demo.gwtp.client.about;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.about.AboutPresenter.AboutProxy;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class AboutPresenter extends Presenter<AboutView, AboutProxy> {
	private final AppPresenter appPresenter;

	@ProxyStandard
	@NameToken(NameTokens.ABOUT)
	public interface AboutProxy extends ProxyPlace<AboutPresenter> {
	}

	@Inject
	public AboutPresenter(EventBus eventBus, AboutView view, AboutProxy proxy,
			AppPresenter appPresenter) {
		super(eventBus, view, proxy);
		this.appPresenter = appPresenter;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(appPresenter, AppPresenter.MAIN_SLOT, this);
	}
}
