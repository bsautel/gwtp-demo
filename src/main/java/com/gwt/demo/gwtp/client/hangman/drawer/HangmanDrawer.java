package com.gwt.demo.gwtp.client.hangman.drawer;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.CssColor;
import com.gwt.demo.gwtp.client.hangman.HangmanPresenter;

public class HangmanDrawer {
	private List<HangmanPartDrawer> drawers;

	public HangmanDrawer() {
		drawers = new LinkedList<HangmanPartDrawer>();
		drawers.add(new PedestalDrawer());
		drawers.add(new VerticalStemDrawer());
		drawers.add(new HorizontalStemDrawer());
		drawers.add(new RopeDrawer());
		drawers.add(new HeadDrawer());
		drawers.add(new BodyDrawer());
		drawers.add(new ArmsDrawer());
		drawers.add(new LegsDrawer());
	}

	public void draw(Canvas canvas, int remainingTries) {
		canvas.getContext2d().clearRect(0.0d, 0.0d,
				canvas.getCoordinateSpaceWidth(),
				canvas.getCoordinateSpaceHeight());
		canvas.getContext2d().setFillStyle(CssColor.make("black"));
		int i = HangmanPresenter.TOTAL_TRIES - remainingTries;
		for (HangmanPartDrawer drawer : drawers) {
			drawer.draw(canvas);
			if (i == 0) {
				break;
			}
			i--;
		}
	}
}
