package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;

public class VerticalStemDrawer implements HangmanPartDrawer {
	public static final double HEIGHT_OFFSET_PERCENTAGE = 0.1d;
	public static final double WIDTH_OFFSET_PERCENTAGE = 0.66d;
	public static final double WIDTH_PERCENTAGE = 0.05d;

	@Override
	public void draw(Canvas canvas) {
		int canvasWidth = canvas.getCoordinateSpaceWidth();
		int canvasHeight = canvas.getCoordinateSpaceHeight();
		double width = canvasWidth * WIDTH_PERCENTAGE;
		double verticalOffset = HEIGHT_OFFSET_PERCENTAGE * canvasHeight;
		canvas.getContext2d().fillRect(WIDTH_OFFSET_PERCENTAGE * canvasWidth,
				verticalOffset, width, canvasHeight - verticalOffset);
	}
}
