package com.gwt.demo.gwtp.client.header;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;

public class HeaderPresenter extends PresenterWidget<HeaderView> {
	@Inject
	public HeaderPresenter(EventBus eventBus, HeaderView view) {
		super(eventBus, view);
	}
}
