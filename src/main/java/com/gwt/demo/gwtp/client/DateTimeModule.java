package com.gwt.demo.gwtp.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;


public class DateTimeModule
    implements EntryPoint
{
    public final ModuleGinjector ginjector = GWT.create(ModuleGinjector.class);


    @Override
    public void onModuleLoad()
    {
        DelayedBindRegistry.bind(ginjector);

        ginjector.getPlaceManager().revealCurrentPlace();
    }
}
