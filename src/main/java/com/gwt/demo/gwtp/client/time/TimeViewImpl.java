package com.gwt.demo.gwtp.client.time;


import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;


public class TimeViewImpl
    extends ViewImpl
    implements TimeView
{
    protected interface Binder
        extends UiBinder<FlowPanel, TimeViewImpl>
    {
    }


    FlowPanel panel;

    @UiField
    HTML html;
    @UiField
    Anchor link;

    protected static final Binder binder = GWT.create(Binder.class);

    private TimePresenter timePresenter;


    @Inject
    @SuppressWarnings("deprecation")
    public TimeViewImpl()
    {
        panel = binder.createAndBindUi(this);

        Date dt = new Date();

        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        builder.appendHtmlConstant("<h1>");
        builder.appendEscaped(dt.getHours() + ":" + dt.getMinutes() + ":"
                + dt.getSeconds());
        builder.appendHtmlConstant("</h1>");

        html.setHTML(builder.toSafeHtml());
    }


    @Override
    public Widget asWidget()
    {
        return panel;
    }


    @UiHandler("link")
    protected void onClick(@SuppressWarnings("unused") ClickEvent event)
    {
        timePresenter.goToDate();
    }


    @Override
    public void setPresenter(TimePresenter timePresenter)
    {
        this.timePresenter = timePresenter;

    }

}
