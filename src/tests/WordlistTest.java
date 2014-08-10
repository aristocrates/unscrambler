package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Anagram;
import core.Wordlist;

public class WordlistTest {
	private Wordlist w;
	@Before
	public void setUp() throws Exception {
		w = new Wordlist();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListFileIO() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testStorageSimple() {
		String[] testList = new String[]{"test", "set", "tests", "subtext",
				"sets", "spines", "lither", "spine", "penis", "pines"
		};
		for (String s : testList)
			w.addWord(s);
		String[] searchList = new String[]{"ets", "EST", "EsT", "sET", "set"};
		for (String s : searchList) {
			List<Anagram> test = w.getWords(s);
			assertTrue(test.size() == 1);
			assertTrue(test.get(0).getWord().equals("set"));
		}
		searchList = new String[]{"pines", "spine", "penis", "pneis",
				"spnei", "senpi"
		};
		for (String s : searchList) {
			List<Anagram> test = w.getWords(s);
			assertTrue(test.size() == 3);
			for (String str : new String[]{"spine", "penis", "pines"} ) {
				assertTrue(test.contains(new Anagram(str)));
			}
		}
	}
	
	@Test
	public void testStorageMultipleAlphabets() {
		
	}
}
