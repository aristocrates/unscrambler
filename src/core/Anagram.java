package core;

import java.io.Serializable;

/**
 * An Anagram is a wrapper over a String that does not concern the order in
 * which characters are arranged. Two Anagrams are equal if they represent
 * strings that are permutations of each other.
 * 
 * @author Nicholas Meyer
 *
 */
public class Anagram implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8694336925402088551L;
	private final Alphabet a;
	private final int[] chars;
	private final String word;
	
	public Anagram(String s, Alphabet a)
	{
		this.a = a;
		chars = new int[a.length()];
		for (int i = 0; i < s.length(); i++)
		{
			int index = a.index(s.charAt(i));
			chars[index]++;
		}
		this.word = s;
	}
	
	/**
	 * Constructs an anagram with an English alphabet. Equivalent to
	 * new Anagram(s, new Alphabet(Alphabet.ENGLISH))
	 */
	public Anagram(String s)
	{
		this(s, new Alphabet(Alphabet.ENGLISH));
	}
	
	@Override
	public int hashCode()
	{
		int ans = 0;
		for (int i = 0; i < chars.length; i++)
			ans += (""+a.character(i)).hashCode() * chars[i];
		return ans * a.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Anagram)
		{
			Anagram other = (Anagram)o;
			//make sure same alphabet is being used
			if (!a.equals(other.a))
				return false;
			//make sure count array is the same
			if (chars.length != other.chars.length)
				return false;
			for (int i = 0; i < chars.length; i++)
				if (chars[i] != other.chars[i])
					return false;
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the actual word represented by the Anagram. Note that it is
	 * possible for two Anagrams to be equal by the equals() method but
	 * return different values for this method.
	 * 
	 * @return the word that this Anagram represents
	 */
	public String getWord()
	{
		return this.word;
	}
}
