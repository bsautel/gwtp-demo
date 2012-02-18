package com.gwt.demo.gwtp.client;

import com.gwt.demo.gwtp.client.about.AboutPresenter;
import com.gwt.demo.gwtp.client.about.AboutPresenter.AboutProxy;
import com.gwt.demo.gwtp.client.about.AboutView;
import com.gwt.demo.gwtp.client.about.AboutViewImpl;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.app.AppPresenter.AppProxy;
import com.gwt.demo.gwtp.client.app.AppView;
import com.gwt.demo.gwtp.client.app.AppViewImpl;
import com.gwt.demo.gwtp.client.browser.BrowserPresenter;
import com.gwt.demo.gwtp.client.browser.BrowserPresenter.BrowserProxy;
import com.gwt.demo.gwtp.client.browser.BrowserView;
import com.gwt.demo.gwtp.client.browser.BrowserViewImpl;
import com.gwt.demo.gwtp.client.date.DatePresenter;
import com.gwt.demo.gwtp.client.date.DatePresenter.DateProxy;
import com.gwt.demo.gwtp.client.date.DateView;
import com.gwt.demo.gwtp.client.date.DateViewImpl;
import com.gwt.demo.gwtp.client.footer.FooterPresenter;
import com.gwt.demo.gwtp.client.footer.FooterView;
import com.gwt.demo.gwtp.client.footer.FooterViewImpl;
import com.gwt.demo.gwtp.client.header.HeaderPresenter;
import com.gwt.demo.gwtp.client.header.HeaderView;
import com.gwt.demo.gwtp.client.header.HeaderViewImpl;
import com.gwt.demo.gwtp.client.time.TimePresenter;
import com.gwt.demo.gwtp.client.time.TimePresenter.TimeProxy;
import com.gwt.demo.gwtp.client.time.TimeView;
import com.gwt.demo.gwtp.client.time.TimeViewImpl;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ModuleConfig extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new DefaultModule(ModulePlaceManager.class));

		// Presenters
		bindPresenter(AppPresenter.class, AppView.class, AppViewImpl.class,
				AppProxy.class);
		bindPresenter(TimePresenter.class, TimeView.class, TimeViewImpl.class,
				TimeProxy.class);
		bindPresenter(DatePresenter.class, DateView.class, DateViewImpl.class,
				DateProxy.class);
		bindPresenter(AboutPresenter.class, AboutView.class,
				AboutViewImpl.class, AboutProxy.class);

		bindPresenter(BrowserPresenter.class, BrowserView.class,
				BrowserViewImpl.class, BrowserProxy.class);

		bindSingletonPresenterWidget(HeaderPresenter.class, HeaderView.class,
				HeaderViewImpl.class);

		bindSingletonPresenterWidget(FooterPresenter.class, FooterView.class,
				FooterViewImpl.class);
	}
}
