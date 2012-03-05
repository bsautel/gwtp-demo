package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;

public class PedestalDrawer implements HangmanPartDrawer {
	private static final double HEIGHT_PERCENTAGE = 0.05d;

	@Override
	public void draw(Canvas canvas) {
		int canvasHeight = canvas.getCoordinateSpaceHeight();
		double pedestalHeight = HEIGHT_PERCENTAGE * canvasHeight;
		int canvasWidth = canvas.getCoordinateSpaceWidth();
		canvas.getContext2d().fillRect(0.0d, canvasHeight - pedestalHeight,
				canvasWidth, pedestalHeight);
	}
}
