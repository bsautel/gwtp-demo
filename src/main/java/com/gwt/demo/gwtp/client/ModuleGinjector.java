package com.gwt.demo.gwtp.client;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.date.DatePresenter;
import com.gwt.demo.gwtp.client.time.TimePresenter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;



@GinModules({ ModuleConfig.class })
public interface ModuleGinjector
    extends Ginjector
{
    PlaceManager getPlaceManager();


    EventBus getEventBus();


    AsyncProvider<TimePresenter> getTimePresenter();


    Provider<DatePresenter> getDatePresenter();


    Provider<AppPresenter> getAppPresenter();

}
