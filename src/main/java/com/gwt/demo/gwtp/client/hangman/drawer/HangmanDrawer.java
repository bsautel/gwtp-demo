package com.gwt.demo.gwtp.client.hangman.drawer;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.CssColor;

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
		canvas.getContext2d().setFillStyle(CssColor.make("black"));
		for (HangmanPartDrawer drawer : drawers) {
			drawer.draw(canvas);
		}
	}
}
