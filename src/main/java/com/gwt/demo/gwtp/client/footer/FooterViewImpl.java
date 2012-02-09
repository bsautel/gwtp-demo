package com.gwt.demo.gwtp.client.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class FooterViewImpl extends ViewImpl implements FooterView {
	public interface Binder extends UiBinder<HTMLPanel, FooterViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private HTMLPanel panel;

	public FooterViewImpl() {
		panel = BINDER.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
