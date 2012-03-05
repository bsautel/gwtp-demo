package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class LegsDrawer implements HangmanPartDrawer {
	@Override
	public void draw(Canvas canvas) {
		Context2d context = canvas.getContext2d();
		drawArm(context, 0.2d * Math.PI);
		drawArm(context, 0.8d * Math.PI);
	}

	private void drawArm(Context2d context, double angle) {
		context.save();
		context.translate(95.0d, 90.0d);
		context.rotate(angle);
		context.fillRect(0.0d, 0.0d, 50.0d, 2.0d);
		context.restore();
	}
}
