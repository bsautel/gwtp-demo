package com.gwt.demo.gwtp.client.app;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.app.AppPresenter.AppProxy;
import com.gwt.demo.gwtp.client.footer.FooterPresenter;
import com.gwt.demo.gwtp.client.header.HeaderPresenter;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class AppPresenter extends Presenter<AppView, AppProxy> {
	@ProxyStandard
	public interface AppProxy extends Proxy<AppPresenter> {

	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> HEADER_SLOT = new Type<RevealContentHandler<?>>();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> FOOTER_SLOT = new Type<RevealContentHandler<?>>();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> MAIN_SLOT = new Type<RevealContentHandler<?>>();

	@Inject
	public AppPresenter(EventBus eventBus, AppView view, AppProxy proxy,
			HeaderPresenter headerPresenter, FooterPresenter footerPresenter) {
		super(eventBus, view, proxy);
		setInSlot(HEADER_SLOT, headerPresenter);
		setInSlot(FOOTER_SLOT, footerPresenter);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

}
