package core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an alphabet of particular characters from which words can be
 * created. The set of all words that are valid in a given alphabet is the
 * infinitely large set of all permutations (allowing repeats) of all, any,
 * or none of the characters in said alphabet. Note that the "order" of
 * characters defined in the alphabet matters; for example, an alphabet created
 * from the character array {'A', 'B', 'C'} is distinct from the alphabet
 * created from the character array {'C', 'B', 'A'} (even though in this case
 * every word valid in one alphabet is valid in the other). Note that the
 * behavior of the Alphabet class is undefined if an individual character is
 * repeated in a single alphabet (i.e. {'A', 'B', 'A'}).
 * 
 * @author Nicholas Meyer
 *
 */
public class Alphabet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7539134313619545797L;
	public static final int ENGLISH = 0;
	public static final int ENGLISH_NUMS = 1;
	public static final int ENGLISH_NUMS_PUNCTUATION = 2;
	public static final int FRENCH = 3;
	public static final Map<Integer, char[]> map;
	static {
		map = new HashMap<>();
		char[] arr = new char[26];
		char curr = 'A';
		for (int i = 0; i < arr.length; i++)
			arr[i] = curr++;
		map.put(ENGLISH, arr);
		arr = new char[36];
		curr = 'A';
		for (int i = 0; i < 26; i++)
			arr[i] = curr++;
		curr = '0';
		for (int i = 0; i < 10; i++)
			arr[i + 26] = curr++;
		map.put(ENGLISH_NUMS, arr);
		arr = new char[44];
		curr = 'A';
		for (int i = 0; i < 44; i++)
			arr[i] = curr++;
		curr = '0';
		for (int i = 0; i < 10; i++)
			arr[i + 26] = curr++;
		char[] add = {'\'', '"', ';', ':', '.', ',', '?', '!'};
		for (int i = 0; i < add.length; i++)
			arr[i + 36] = add[i];
		map.put(ENGLISH_NUMS_PUNCTUATION, arr);
	}
	
	private final int length;
	private final char[] arr;
	private final Map<Character, Integer> charToInt;
	
	public Alphabet(int type)
	{
		arr = map.get(type);
		length = arr.length;
		charToInt = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			charToInt.put(arr[i], i);
	}
	
	public Alphabet(char[] characters)
	{
		arr = characters;
		length = arr.length;
		charToInt = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			charToInt.put(arr[i], i);
	}
	
	public int length()
	{
		return length;
	}
	
	/**
	 * Gets the index of the particular character
	 * 
	 * @param c
	 * @return
	 */
	public int index(char c)
	{
		c = (""+c).toUpperCase().charAt(0);
		Integer ans = charToInt.get(c);
		if (ans == null)
			return -1;
		else
			return ans;
	}
	
	/**
	 * Gets the character at the particular index
	 * 
	 * @param i
	 * @return
	 */
	public char character(int i)
	{
		return arr[i];
	}
	
	/**
	 * Gets whether the provided string is a valid word in this alphabet
	 * 
	 * @param s
	 * @return  true if the word represented by s contains only characters from
	 * 			this alphabet, false otherwise
	 */
	public boolean isValid(String s)
	{
		for (int i = 0; i < s.length(); i++)
			if (index(s.charAt(i)) == -1)
				return false;
		return true;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Alphabet)
		{
			Alphabet a = (Alphabet)o;
			if (length != a.length)
				return false;
			for (int i = 0; i < arr.length; i++)
				if (arr[i] != a.arr[i])
					return false;
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int hash = 1;
		hash *= length;
		for (int i = 0; i < arr.length; i++) {
			hash += arr[i];
			String chaos = "" + arr[i];
			hash *= chaos.hashCode();
		}
		return hash;
	}
}
