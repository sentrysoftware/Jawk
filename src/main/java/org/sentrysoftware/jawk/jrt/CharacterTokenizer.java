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
 * Similar to StringTokenizer, except that tokens are characters
 * in the input string themselves.
 * <p>
 * For Jawk, this class is used when NF == "".
 *
 * @author Danny Daglas
 */
public class CharacterTokenizer implements Enumeration<Object> {

	private String input;
	private int idx = 0;

	/**
	 * Construct a CharacterTokenizer.
	 *
	 * @param input The input string to tokenize.
	 */
	public CharacterTokenizer(String input) {
		this.input = input;
	}

	/** {@inheritDoc} */
	@Override
	public boolean hasMoreElements() {
		return idx < input.length();
	}

	/** {@inheritDoc} */
	@Override
	public Object nextElement() {
		return Character.toString(input.charAt(idx++));
	}
}
