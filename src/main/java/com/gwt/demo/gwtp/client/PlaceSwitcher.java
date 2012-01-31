package com.gwt.demo.gwtp.client;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

@Singleton
public class PlaceSwitcher {
	private final PlaceManager placeManager;
	private Timer timer;

	@Inject
	public PlaceSwitcher(PlaceManager placeManager) {
		this.placeManager = placeManager;
		timer = null;
	}

	public void stopDelayedSwap() {
		if (timer != null) {
			timer.cancel();
		}
	}

	public void swapFromCurrentRequest() {
		PlaceRequest request = placeManager.getCurrentPlaceRequest();
		String to = request.getParameter("and", "");
		if (to.length() > 0) {
			swap(to, NameTokens.swapDelay);
		} else {
			stopDelayedSwap();
		}
	}

	public void swap(final String nameToken, final int delay) {

		final String swapTo = placeManager.getCurrentPlaceRequest()
				.getNameToken();

		stopDelayedSwap();
		timer = new Timer() {
			@Override
			public void run() {
				goTo(nameToken, swapTo);
			}

		};

		timer.schedule(delay);
	}

	public void goTo(final String nameToken, final int delay) {
		stopDelayedSwap();
		timer = new Timer() {
			@Override
			public void run() {
				goTo(nameToken);
			}

		};

		timer.schedule(delay);
	}

	public void goTo(final String nameToken) {
		if (nameToken.length() > 0) {
			stopDelayedSwap();
			PlaceRequest request = new PlaceRequest(nameToken);
			placeManager.revealPlace(request);
		}
	}

	public void goTo(final String nameToken, final String swapTo) {
		if (nameToken.length() > 0 && swapTo.length() > 0) {
			stopDelayedSwap();
			PlaceRequest request = new PlaceRequest(nameToken);
			request = request.with("and", swapTo);
			placeManager.revealPlace(request);
		}
	}
}
