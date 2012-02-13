package com.gwt.demo.gwtp.client.browser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class BrowserViewImpl extends ViewImpl implements BrowserView {
	protected interface Binder extends UiBinder<HTMLPanel, BrowserViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private HTMLPanel panel;
	@UiField
	protected TextBox urlTextBox;
	@UiField
	protected Frame webPageFrame;

	public BrowserViewImpl() {
		panel = BINDER.createAndBindUi(this);
	}

	@Override
	public void displayUrl(String url) {
		urlTextBox.setText(url);
		webPageFrame.setUrl(url);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
