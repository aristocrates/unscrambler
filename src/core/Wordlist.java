package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wordlist implements Serializable {
	
	private Map<Anagram, List<Anagram>> map;
	/**
	 * Serial version uid
	 */
	private static final long serialVersionUID = -7166208436789404279L;

	public Wordlist()
	{
		map = new HashMap<>();
	}
	
	public boolean addWord(String s)
	{
		return addWord(s, new Alphabet(Alphabet.ENGLISH));
	}
	
	public boolean addWord(String s, Alphabet al)
	{
		if (!al.isValid(s))
			return false;
		Anagram a = new Anagram(s, al);
		List<Anagram> anagrams = map.get(a);
		if (anagrams == null)
		{
			anagrams = new ArrayList<>();
		}
		anagrams.add(a);
		map.put(a, anagrams);
		return true;
	}
	
	public List<Anagram> getWords(String s)
	{
		return map.get(new Anagram(s));
	}
	
	public List<Anagram> getWords(String s, Alphabet al)
	{
		return map.get(new Anagram(s, al));
	}
	
	public void addList(File f) throws FileNotFoundException
	{
		BufferedReader r = new BufferedReader(new FileReader(f));
		
		String s = null;
		try {
			while ((s = r.readLine()) != null)
			{
				addWord(s);
			}
		} catch (IOException e) {
			System.err.println("Error: problem reading file");
			System.err.println(e);
		}
		try {
			r.close();
		} catch (IOException e) {
			System.err.println("Error: unable to close file");
			System.err.println(e);
		}
	}
	
	public void addList(File f, Alphabet a) throws FileNotFoundException
	{
		BufferedReader r = new BufferedReader(new FileReader(f));
		
		String s = null;
		try {
			while ((s = r.readLine()) != null)
			{
				addWord(s, a);
			}
		} catch (IOException e) {
			System.err.println("Error: problem reading file");
			System.err.println(e);
		}
		try {
			r.close();
		} catch (IOException e) {
			System.err.println("Error: unable to close file");
			System.err.println(e);
		}
	}
}
