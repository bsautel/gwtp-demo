package com.gwt.demo.gwtp.client.hangman.game;

public class HangmanComputer {
	public HangmanState compute(HangmanState state, char character) {
		String wordToFind = state.getWordToFind();
		if (wordContainsCharacter(wordToFind, character)) {
			String newCurrentWord = insertCharacterInCurrentWord(state,
					character);
			return new HangmanState(wordToFind, newCurrentWord,
					state.getRemainingTries());
		}
		return new HangmanState(wordToFind, state.getCurrentWord(),
				state.getRemainingTries() - 1);
	}

	private String insertCharacterInCurrentWord(HangmanState state,
			char character) {
		StringBuffer wordToFind = new StringBuffer(state.getWordToFind());
		StringBuffer currentWord = new StringBuffer(state.getCurrentWord());
		for (int index = 0; index < wordToFind.length(); index++) {
			if (wordToFind.charAt(index) == character) {
				currentWord.setCharAt(index, character);
			}
		}
		return currentWord.toString();
	}

	private boolean wordContainsCharacter(String word, char character) {
		return word.indexOf(character) >= 0;
	}
}
