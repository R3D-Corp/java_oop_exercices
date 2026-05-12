package io;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private StringUtils() {}
	
	/**
	 * Returns the index within this string of the first occurrence of the character matching the 
	 * specified regular expression.
	 * @param search
	 * @param regex the regex, already compiled.
	 * @return the index of the first occurrence of the character matching the specified regular
	 * expression in the search String, or -1 if the character does not occur.
	 */
	public static int indexOfPattern(String search, Pattern regex) {
		return indexOfPattern(search, regex, 0);
	}
	
	/**
	 * Returns the index within this string of the first occurrence of the first occurrence of the character
	 * matching the specified regular expression, starting the search at the specified index.
	 * @param search
	 * @param regex the regex, already compiled.
	 * @param fromIndex the index to start the search from.
	 * @return the index of the first occurrence of the character matching the specified regular
	 * expression in the search String that is greater than or equal to fromIndex, or -1 if the
	 * character does not occur. 
	 */
	public static int indexOfPattern(String search, Pattern regex, int fromIndex) {
		Matcher result = Objects.requireNonNull(regex).matcher(Objects.requireNonNull(search));
		if (result.find(fromIndex)) {
			return result.start();
		} else
			return -1;
	}
}
