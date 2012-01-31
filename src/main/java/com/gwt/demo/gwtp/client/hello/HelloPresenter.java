package com.gwt.demo.gwtp.client.hello;


import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


public class HelloPresenter
    extends PresenterWidget<HelloView>
{
    @Inject
    public HelloPresenter(EventBus eventBus, HelloView view)
    {
        super(eventBus, view);
    }

}
