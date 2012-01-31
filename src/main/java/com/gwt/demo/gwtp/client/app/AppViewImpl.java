package com.gwt.demo.gwtp.client.app;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;


public class AppViewImpl
    extends ViewImpl
    implements AppView
{
    protected interface Binder
        extends UiBinder<HTMLPanel, AppViewImpl>
    {
    }


    private static Binder binder = GWT.create(Binder.class);
    private HTMLPanel panel;

    @UiField
    protected SimplePanel mainPanel, helloPanel;


    public AppViewImpl()
    {
        panel = binder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget()
    {
        return panel;
    }


    @Override
    public void addToSlot(Object slot, Widget content)
    {
        if (slot == AppPresenter.helloSlot) {
            helloPanel.setWidget(content);
        }
        else if (slot == AppPresenter.mainSlot) {
            mainPanel.setWidget(content);
        }
        else {
            super.addToSlot(slot, content);
        }
    }


    @Override
    public void setInSlot(Object slot, Widget content)
    {
        if (slot == AppPresenter.helloSlot) {
            helloPanel.setWidget(content);
        }
        else if (slot == AppPresenter.mainSlot) {
            mainPanel.setWidget(content);
        }
        else {
            super.setInSlot(slot, content);
        }
    }
}
