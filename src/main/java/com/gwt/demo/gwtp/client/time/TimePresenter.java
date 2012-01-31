package com.gwt.demo.gwtp.client.time;


import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwt.demo.gwtp.client.PlaceSwitcher;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwt.demo.gwtp.client.time.TimePresenter.TimeProxy;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;



public class TimePresenter
    extends Presenter<TimeView, TimeProxy>
{
    private final PlaceSwitcher placeSwitcher;
    private final AppPresenter appPresenter;


    @ProxyCodeSplit
    @NameToken(NameTokens.timePage)
    public interface TimeProxy
        extends ProxyPlace<TimePresenter>
    {

    }


    @Inject
    public TimePresenter(EventBus eventBus, TimeView view, TimeProxy proxy,
            PlaceSwitcher placeSwitcher, AppPresenter appPresenter)
    {
        super(eventBus, view, proxy);
        this.placeSwitcher = placeSwitcher;
        this.appPresenter = appPresenter;
        view.setPresenter(this);
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


    protected void goToDate()
    {
        placeSwitcher.goTo(NameTokens.getDatePage());
    }
}
