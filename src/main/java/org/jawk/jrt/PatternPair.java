package org.jawk.jrt;

/*-
 * ╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲
 * Jawk
 * ჻჻჻჻჻჻
 * Copyleft 2006 - 2023 Danny Daglas, Robin Vobruba, Sentry Software
 * ჻჻჻჻჻჻
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * ╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱
 */

import java.util.regex.Pattern;

/**
 * A pair of regular expressions such that matching means
 * previous text has matched the first regex, but not the
 * second regex.
 * When text matches the second regex, it is still considered
 * a match. However, subsequent matching attempts are false
 * unless the first regex is matched again.
 * <p>
 * If text matches both the first and second regex, the entry
 * is considered a match, but subsequent entries are not considered
 * matched (unless the text matches the first regex).
 *
 * @author Danny Daglas
 */
public class PatternPair {

	private Pattern p1;
	private Pattern p2;
	private boolean within = false;

	/**
	 * <p>Constructor for PatternPair.</p>
	 *
	 * @param s1 a {@link java.lang.String} object
	 * @param s2 a {@link java.lang.String} object
	 */
	public PatternPair(String s1, String s2) {
		p1 = Pattern.compile(s1);
		p2 = Pattern.compile(s2);
	}

	/**
	 * Text is matched against this regex pair, returning true only
	 * if this or previous text matches the first regex, up until
	 * the text is matched against the second regex.
	 *
	 * @param str Text to match against the first and second
	 *   regular expressions.
	 * @return true if this or previous text matches the first regex,
	 *   up until text matches the second regex, which is still considered
	 *   a match, but subsequent text is not considered a match
	 *   (unless, of course, the text matches the first regex).
	 */
	public boolean matches(String str) {
		if (p1.matcher(str).find()) {
			within = true;
		}
		if (within && p2.matcher(str).find()) {
			within = false;
			return true; // inclusive
		}
		return within;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return p1 + "," + p2;
	}
}
