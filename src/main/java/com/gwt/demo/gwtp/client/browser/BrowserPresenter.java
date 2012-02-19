package com.gwt.demo.gwtp.client.browser;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.browser.BrowserPresenter.BrowserProxy;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class BrowserPresenter extends Presenter<BrowserView, BrowserProxy> {
	private static final String HOME_URL = "http://fr.wikipedia.org";
	private final AppPresenter appPresenter;

	@ProxyStandard
	@NameToken(NameTokens.BROWSER)
	public interface BrowserProxy extends ProxyPlace<BrowserPresenter> {
	}

	@Inject
	public BrowserPresenter(EventBus eventBus, BrowserView view,
			BrowserProxy proxy, AppPresenter appPresenter) {
		super(eventBus, view, proxy);
		this.appPresenter = appPresenter;
		view.setPresenter(this);
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		getView().displayUrl(HOME_URL);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(appPresenter, AppPresenter.MAIN_SLOT, this);
	}

	public void changeUrl(String url) {
		getView().goToUrl(url);
	}
}
