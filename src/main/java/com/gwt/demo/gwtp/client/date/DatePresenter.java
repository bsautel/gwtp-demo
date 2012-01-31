package com.gwt.demo.gwtp.client.date;


import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.PlaceSwitcher;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.date.DatePresenter.DateProxy;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;



public class DatePresenter
    extends Presenter<DateView, DateProxy>
{

    private final PlaceSwitcher placeSwitcher;

    private final AppPresenter appPresenter;


    @ProxyStandard
    @NameToken(NameTokens.datePage)
    public interface DateProxy
        extends ProxyPlace<DatePresenter>
    {

    }


    @Inject
    public DatePresenter(EventBus eventBus, DateView view, DateProxy proxy,
            PlaceSwitcher placeSwitcher, AppPresenter appPresenter)
    {
        super(eventBus, view, proxy);

        this.placeSwitcher = placeSwitcher;
        this.appPresenter = appPresenter;
    }


    @Override
    protected void revealInParent()
    {
        RevealContentEvent.fire(appPresenter, AppPresenter.mainSlot, this);
    }


    @Override
    public void prepareFromRequest(PlaceRequest request)
    {
        super.prepareFromRequest(request);

        placeSwitcher.swapFromCurrentRequest();
    }


    protected void goToTime()
    {
        placeSwitcher.goTo(NameTokens.getTimePage());
    }
}
