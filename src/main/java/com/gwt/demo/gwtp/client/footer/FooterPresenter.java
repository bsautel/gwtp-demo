package com.gwt.demo.gwtp.client.footer;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class FooterPresenter extends PresenterWidget<FooterView> {
	@Inject
	public FooterPresenter(EventBus eventBus, FooterView view) {
		super(eventBus, view);
	}
}
