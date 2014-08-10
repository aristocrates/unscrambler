package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Alphabet;
import core.Anagram;

public class AnagramTest {
	private Anagram a, b, c, d, e, f;
	@Before
	public void setUp() throws Exception {
		a = new Anagram("hello", new Alphabet(Alphabet.ENGLISH));
		b = new Anagram("lehlo", new Alphabet(Alphabet.ENGLISH));
		c = new Anagram("HELLO");
		d = new Anagram("lHeLo");
		e = new Anagram("nope");
		f = new Anagram("helloo");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEquals() {
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		assertTrue(b.equals(c));
		assertTrue(c.equals(d));
		assertFalse(d.equals(e));
		assertFalse(e.equals(f));
		assertFalse(f.equals(c));
		assertFalse(f.equals(a));
	}

	@Test
	public void testHashCode() {
		assertTrue(a.hashCode() == b.hashCode());
		assertTrue(b.hashCode() == c.hashCode());
		assertTrue(c.hashCode() == d.hashCode());
		assertFalse(d.hashCode() == e.hashCode());
		assertFalse(e.hashCode() == f.hashCode());
		assertFalse(f.hashCode() == c.hashCode());
		assertFalse(f.hashCode() == a.hashCode());
	}
	
	@Test
	public void testOriginalWord() {
		assertTrue(a.getWord().equals("hello"));
		assertTrue(b.getWord().equals("lehlo"));
		assertTrue(c.getWord().equals("HELLO"));
		assertTrue(d.getWord().equals("lHeLo"));
		assertTrue(e.getWord().equals("nope"));
		assertTrue(f.getWord().equals("helloo"));
	}
}
