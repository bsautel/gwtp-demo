package com.gwt.demo.gwtp.client.hangman.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HangmanComputerTest {
	private HangmanComputer computer;

	@Before
	public void setUp() {
		computer = new HangmanComputer();
	}

	@Test
	public void testWithNoMatch() {
		HangmanState state = computer.compute(new HangmanState("SANGLIER",
				"********", 6), 'P');
		assertEquals(5, state.getRemainingTries());
		assertEquals("********", state.getCurrentWord());
	}

	@Test
	public void testWithACharacterMatching() {
		HangmanState state = computer.compute(new HangmanState("SANGLIER",
				"**N***E*", 4), 'G');
		assertEquals(4, state.getRemainingTries());
		assertEquals("**NG**E*", state.getCurrentWord());
	}

	@Test
	public void testWithTheFirstCharacterMatching() {
		HangmanState state = computer.compute(new HangmanState("SANGLIER",
				"**N***E*", 4), 'S');
		assertEquals(4, state.getRemainingTries());
		assertEquals("S*N***E*", state.getCurrentWord());
	}

	@Test
	public void testWithTheLastCharacterMatching() {
		HangmanState state = computer.compute(new HangmanState("SANGLIER",
				"**N*L*E*", 4), 'R');
		assertEquals(4, state.getRemainingTries());
		assertEquals("**N*L*ER", state.getCurrentWord());
	}

	@Test
	public void testWithSeveralCharactersMatching() {
		HangmanState state = computer.compute(new HangmanState("OLIVIER",
				"O*****R", 4), 'I');
		assertEquals(4, state.getRemainingTries());
		assertEquals("O*I*I*R", state.getCurrentWord());
	}
}
