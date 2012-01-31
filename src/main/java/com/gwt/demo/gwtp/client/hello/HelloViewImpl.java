package com.gwt.demo.gwtp.client.hello;


import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;


public class HelloViewImpl
    extends ViewImpl
    implements HelloView
{
    protected static final HTML label = new HTML("<h2>Hello !</h2>");


    @Override
    public Widget asWidget()
    {
        return label;
    }

}
