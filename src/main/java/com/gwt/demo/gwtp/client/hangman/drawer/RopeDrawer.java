package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;

public class RopeDrawer implements HangmanPartDrawer {
	@Override
	public void draw(Canvas canvas) {
		canvas.getContext2d().fillRect(90.0d, 15.0d, 3.0d, 30.0d);
	}
}
