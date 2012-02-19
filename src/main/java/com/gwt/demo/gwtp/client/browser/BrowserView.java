package com.gwt.demo.gwtp.client.browser;

import com.gwtplatform.mvp.client.View;

public interface BrowserView extends View {
	void displayUrl(String url);

	void setPresenter(BrowserPresenter browserPresenter);

	void goToUrl(String url);
}
