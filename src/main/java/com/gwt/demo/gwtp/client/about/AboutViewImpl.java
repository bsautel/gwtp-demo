package com.gwt.demo.gwtp.client.about;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class AboutViewImpl extends ViewImpl implements AboutView {
	protected interface Binder extends UiBinder<HTMLPanel, AboutViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private HTMLPanel panel;

	public AboutViewImpl() {
		panel = BINDER.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
