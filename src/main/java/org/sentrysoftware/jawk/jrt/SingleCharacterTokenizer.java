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

import java.util.Enumeration;

/**
 * Similar to StringTokenizer, except that tokens are delimited
 * by a single character.
 *
 * @author Danny Daglas
 */
public class SingleCharacterTokenizer implements Enumeration<Object> {

	private String input;
	private int splitChar;
	private int idx = 0;

	/**
	 * Construct a RegexTokenizer.
	 *
	 * @param input The input string to tokenize.
	 * @param splitChar The character which delineates tokens
	 *   within the input string.
	 */
	public SingleCharacterTokenizer(String input, int splitChar) {
		// input + sentinel
		this.input = input + ((char) splitChar);
		this.splitChar = splitChar;
	}

	/** {@inheritDoc} */
	@Override
	public boolean hasMoreElements() {
		return idx < input.length();
	}

	private StringBuffer sb = new StringBuffer();

	/** {@inheritDoc} */
	@Override
	public Object nextElement() {
		sb.setLength(0);
		while (idx < input.length()) {
			if (input.charAt(idx) == splitChar) {
				++idx;
				break;
			} else {
				sb.append(input.charAt(idx++));
			}
		}

		return sb.toString();
	}
}
