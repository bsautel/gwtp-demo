package com.gwt.demo.gwtp.client;


import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;


public class ModulePlaceManager
    extends PlaceManagerImpl
{

    @Inject
    public ModulePlaceManager(EventBus eventBus, TokenFormatter tokenFormatter)
    {
        super(eventBus, tokenFormatter);
    }


    @Override
    public void revealDefaultPlace()
    {
        PlaceRequest request = new PlaceRequest(NameTokens.getDatePage());
        request = request.with("and", NameTokens.getTimePage());
        revealPlace(request);
    }

}
