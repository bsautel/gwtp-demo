package com.gwt.demo.gwtp.client.popop;


import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.app.AppPresenter;
import com.gwtplatform.mvp.client.PresenterWidget;



public class PopopPresenter
    extends PresenterWidget<PopopView>
{
    @Inject
    public PopopPresenter(EventBus eventBus, PopopView view,
            AppPresenter appPresenter)
    {
        super(eventBus, view);
    }

}
