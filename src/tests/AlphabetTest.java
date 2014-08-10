package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Alphabet;

public class AlphabetTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnglishAlphabet() {
		Alphabet abc = new Alphabet(Alphabet.ENGLISH);
		assertEquals('A', abc.character(0));
		assertEquals('B', abc.character(1));
		assertEquals(5, abc.index('F'));
		assertEquals(5, abc.index('f'));
		assertEquals(26, abc.length());
	}

	@Test
	public void testMultipleAlphabets() {
		Alphabet abc = new Alphabet(Alphabet.ENGLISH);
		Alphabet abc123 = new Alphabet(Alphabet.ENGLISH_NUMS);
		Alphabet abc123punct = new Alphabet(Alphabet.ENGLISH_NUMS_PUNCTUATION);
		assertFalse(abc.equals(abc123));
		assertFalse(abc123.equals(abc));
		assertFalse(abc123.equals(abc123punct));
		assertFalse(abc123punct.equals(abc123));
		assertFalse(abc123punct.equals(abc));
		assertFalse(abc.equals(abc123punct));
		char[] alph = new char[26];
		char curr = 'A';
		for (int i = 0; i < alph.length; i++)
			alph[i] = curr++;
		Alphabet abcAlt = new Alphabet(alph);
		assertTrue(abc.equals(abcAlt));
		assertFalse(abcAlt.equals(abc123));
		assertFalse(abcAlt.equals(abc123punct));
		alph[1] = 'A';
		alph[0] = 'B';
		assertFalse(abc.equals(abcAlt));
	}
	
	@Test
	public void testHashCodeCommon() {
		Alphabet abc = new Alphabet(Alphabet.ENGLISH);
		Alphabet abc123 = new Alphabet(Alphabet.ENGLISH_NUMS);
		Alphabet abc123punct = new Alphabet(Alphabet.ENGLISH_NUMS_PUNCTUATION);
		assertTrue(abc.hashCode() == abc.hashCode());
		assertTrue(abc123.hashCode() == abc123.hashCode());
		assertTrue(abc123punct.hashCode() == abc123punct.hashCode());
		assertTrue(abc.hashCode() == 
						new Alphabet(Alphabet.ENGLISH).hashCode());
		assertTrue(abc123.hashCode() ==
						new Alphabet(Alphabet.ENGLISH_NUMS).hashCode());
		assertTrue(abc123punct.hashCode() ==
						new Alphabet(Alphabet.ENGLISH_NUMS_PUNCTUATION).hashCode());
		assertTrue(abc.hashCode() != abc123.hashCode());
		assertTrue(abc123.hashCode() != abc123punct.hashCode());
		assertTrue(abc123punct.hashCode() != abc.hashCode());
	}
}
