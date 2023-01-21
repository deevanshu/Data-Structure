package Testing;

import java.util.HashMap;
import java.util.Map;

public class PatternMatchingXY {

	public static void main(String args[]) throws Exception{ 

		String word = "codesleepcode";
		String pattern = "XYX";

		// create a map to store mappings between the pattern and string
		Map<Character, String> mapping = new HashMap<>();

		// check for solution
		if (isMatch(word, 0, pattern, 0, mapping)) {
			System.out.println(mapping);
		} else {
			System.out.println("Solution doesn't exist");
		}
	}
	public static boolean isMatch(String word, int i, String pattern, int j,
			Map<Character, String> map)
	{
		// invalid word
		if (word == null || pattern == null || word.length() < pattern.length()) {
			return false;
		}

		int n = word.length(), m = pattern.length();

		// if both pattern and the string reaches the end
		if (i == n && j == m) {
			return true;
		}

		// if either string or pattern reaches the end
		if (i == n || j == m) {
			return false;
		}

		// consider the next character from the pattern
		char curr = pattern.charAt(j);

		// if the character is seen before
		if (map.containsKey(curr))
		{
			String s = map.get(curr);
			int k = s.length();

			// `ss` stores next `k` characters of the given string
			String ss;
			if (i + k < word.length()) {
				ss = word.substring(i, i + k);
			}
			else {
				ss = word.substring(i);
			}

			// return false if the next `k` characters don't match with `s`
			if (ss.compareTo(s) != 0) {
				return false;
			}

			// recur for remaining characters if the next `k` characters match
			return isMatch(word, i + k, pattern, j + 1, map);
		}

		// process all remaining characters in the string if the current
		// character is never seen before
		for (int k = 1; k <= n - i; k++)
		{
			// insert substring formed by next `k` characters of the string
			// into the map
			System.out.println(word.substring(i, i + k));
			map.put(curr, word.substring(i, i + k));

			// check if it leads to the solution
			if (isMatch(word, i + k, pattern, j + 1, map)) {
				return true;
			}

			// otherwise, backtrack – remove the current character from the map
			map.remove(curr);
		}

		return false;
	}
}
