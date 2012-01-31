package com.gwt.demo.gwtp.client.app;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.app.AppPresenter.AppProxy;
import com.gwt.demo.gwtp.client.hello.HelloPresenter;
import com.gwt.demo.gwtp.client.popop.PopopPresenter;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;



public class AppPresenter
    extends Presenter<AppView, AppProxy>
{
    @ProxyStandard
    public interface AppProxy
        extends Proxy<AppPresenter>
    {

    }


    @ContentSlot
    public static final Type<RevealContentHandler<?>> helloSlot =
            new Type<RevealContentHandler<?>>();
    @ContentSlot
    public static final Type<RevealContentHandler<?>> mainSlot =
            new Type<RevealContentHandler<?>>();


    @Inject
    public AppPresenter(EventBus eventBus, AppView view, AppProxy proxy,
            HelloPresenter helloPresenter, PopopPresenter popopPresenter)
    {
        super(eventBus, view, proxy);
        setInSlot(helloSlot, helloPresenter);

        RevealRootPopupContentEvent.fire(this, popopPresenter);
        // addToPopupSlot(popopPresenter);
    }


    @Override
    protected void revealInParent()
    {
        RevealRootContentEvent.fire(this, this);
    }

}
