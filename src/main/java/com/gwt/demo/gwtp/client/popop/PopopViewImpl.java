package com.gwt.demo.gwtp.client.popop;


import java.util.Date;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewImpl;


public class PopopViewImpl
    extends PopupViewImpl
    implements PopopView
{

    protected static HTML label;
    protected static final String[] days = { "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday" };


    @Inject
    @SuppressWarnings("deprecation")
    public PopopViewImpl(EventBus eventBus)
    {
        super(eventBus);

        Date dt = new Date();
        label = new HTML("Today it's " + days[dt.getDay()]);
    }


    @Override
    public Widget asWidget()
    {
        return label;
    }

}
