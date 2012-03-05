package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class BodyDrawer implements HangmanPartDrawer {
	@Override
	public void draw(Canvas canvas) {
		Context2d context = canvas.getContext2d();
		context.fillRect(92.0d, 65.0d, 3.0d, 25.0d);
	}
}
