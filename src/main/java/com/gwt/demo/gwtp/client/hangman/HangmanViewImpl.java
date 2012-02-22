package com.gwt.demo.gwtp.client.hangman;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HangmanViewImpl extends ViewImpl implements HangmanView {
	protected interface Binder extends UiBinder<HTMLPanel, HangmanViewImpl> {
	}

	private static final Binder BINDER = GWT.create(Binder.class);
	private final HTMLPanel panel;

	public HangmanViewImpl() {
		panel = BINDER.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
