package com.gwt.demo.gwtp.client;


import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.app.AppView;
import com.gwt.demo.gwtp.client.app.AppViewImpl;
import com.gwt.demo.gwtp.client.app.AppPresenter.AppProxy;
import com.gwt.demo.gwtp.client.date.DatePresenter;
import com.gwt.demo.gwtp.client.date.DateView;
import com.gwt.demo.gwtp.client.date.DateViewImpl;
import com.gwt.demo.gwtp.client.date.DatePresenter.DateProxy;
import com.gwt.demo.gwtp.client.hello.HelloPresenter;
import com.gwt.demo.gwtp.client.hello.HelloView;
import com.gwt.demo.gwtp.client.hello.HelloViewImpl;
import com.gwt.demo.gwtp.client.popop.PopopPresenter;
import com.gwt.demo.gwtp.client.popop.PopopView;
import com.gwt.demo.gwtp.client.popop.PopopViewImpl;
import com.gwt.demo.gwtp.client.time.TimePresenter;
import com.gwt.demo.gwtp.client.time.TimeView;
import com.gwt.demo.gwtp.client.time.TimeViewImpl;
import com.gwt.demo.gwtp.client.time.TimePresenter.TimeProxy;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;



public class ModuleConfig
    extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        install(new DefaultModule(ModulePlaceManager.class));

        // Presenters
        bindPresenter(AppPresenter.class, AppView.class, AppViewImpl.class,
                AppProxy.class);
        bindPresenter(TimePresenter.class, TimeView.class, TimeViewImpl.class,
                TimeProxy.class);
        bindPresenter(DatePresenter.class, DateView.class, DateViewImpl.class,
                DateProxy.class);

        bindSingletonPresenterWidget(HelloPresenter.class, HelloView.class,
                HelloViewImpl.class);
        bindSingletonPresenterWidget(PopopPresenter.class, PopopView.class,
                PopopViewImpl.class);

        // bind(PopopPresenter.class).asEagerSingleton();
        // bind(PopopView.class).to(PopopViewImpl.class).in(Singleton.class);
    }

}