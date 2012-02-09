package com.gwt.demo.gwtp.client.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderViewImpl extends ViewImpl implements HeaderView {
	protected interface Binder extends UiBinder<HTMLPanel, HeaderViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private HTMLPanel panel;

	public HeaderViewImpl() {
		panel = BINDER.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
