package org.sentrysoftware.jawk.jrt;

/*-
 * ╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲╱╲
 * Jawk
 * ჻჻჻჻჻჻
 * Copyright 2006 - 2023 Sentry Software
 * ჻჻჻჻჻჻
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
