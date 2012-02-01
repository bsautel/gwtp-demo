package com.gwt.demo.gwtp.client.date;

import java.util.Date;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwt.demo.gwtp.client.NameTokens;
import com.gwtplatform.mvp.client.ViewImpl;

public class DateViewImpl extends ViewImpl implements DateView {
	FlowPanel panel = new FlowPanel();

	@Inject
	@SuppressWarnings("deprecation")
	public DateViewImpl() {
		HTML html = new HTML("<div>Date</div>");

		Date dt = new Date();

		SafeHtmlBuilder builder = new SafeHtmlBuilder();
		builder.appendHtmlConstant("<h1>");
		builder.appendEscaped(dt.getDate() + "/" + (dt.getMonth() + 1) + "/"
				+ (dt.getYear() + 1900));
		builder.appendHtmlConstant("</h1>");

		html.setHTML(builder.toSafeHtml());

		panel.add(html);

		Hyperlink hl = new Hyperlink("Display the time",
				NameTokens.getTimePage());
		panel.add(hl);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

}
