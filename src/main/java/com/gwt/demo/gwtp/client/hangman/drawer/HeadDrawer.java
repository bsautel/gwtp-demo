package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class HeadDrawer implements HangmanPartDrawer {
	@Override
	public void draw(Canvas canvas) {
		Context2d context = canvas.getContext2d();
		context.beginPath();
		context.arc(92.0d, 55.0d, 10.0d, 0.0d, Math.PI * 2.0);
		context.closePath();
		context.stroke();
	}
}
