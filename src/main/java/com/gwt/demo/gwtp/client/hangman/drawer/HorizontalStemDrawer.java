package com.gwt.demo.gwtp.client.hangman.drawer;

import com.google.gwt.canvas.client.Canvas;

public class HorizontalStemDrawer implements HangmanPartDrawer {
	private static final double THICKNESS_PERCENTAGE = 0.05d;
	private static final double HORIZONTAL_OFFSET_PERCENTAGE = 0.3d;

	@Override
	public void draw(Canvas canvas) {
		int canvasHeight = canvas.getCoordinateSpaceHeight();
		double heightStart = VerticalStemDrawer.HEIGHT_OFFSET_PERCENTAGE
				* canvasHeight;
		double heightThickness = THICKNESS_PERCENTAGE * canvasHeight;
		int canvasWidth = canvas.getCoordinateSpaceWidth();
		double leftOffset = HORIZONTAL_OFFSET_PERCENTAGE * canvasWidth;
		double rightOffset = (VerticalStemDrawer.WIDTH_OFFSET_PERCENTAGE + VerticalStemDrawer.WIDTH_PERCENTAGE)
				* canvasWidth;
		canvas.getContext2d().fillRect(leftOffset, heightStart,
				rightOffset - leftOffset, heightThickness);
	}
}
