package com.gwt.demo.gwtp.client.hangman.game;

public class HangmanState {
	private final String wordToFind;
	private final String currentWord;
	private final int remainingTries;

	public HangmanState(String wordToFind, String currentWord,
			int remainingTries) {
		this.wordToFind = wordToFind;
		this.currentWord = currentWord;
		this.remainingTries = remainingTries;
	}

	public String getWordToFind() {
		return wordToFind;
	}

	public String getCurrentWord() {
		return currentWord;
	}

	public int getRemainingTries() {
		return remainingTries;
	}
}
