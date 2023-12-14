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

/**
 * A list of keys into an associative array.
 * <p>
 * KeyList is provided to differentiate between associative
 * array key lists and other types of lists on the operand stack
 * or as contained by variables. However, this is the only
 * List in used in this manner within Jawk at the time of
 * this writing.
 *
 * @see KeyListImpl
 * @author Danny Daglas
 */
//public interface KeyList extends java.util.List<Object>
public interface KeyList {

	/**
	 * Retrieve the number of elements in the KeyList.
	 *
	 * @return a int
	 */
	int size();

	/**
	 * <p>getFirstAndRemove.</p>
	 *
	 * @return a {@link java.lang.Object} object
	 */
	Object getFirstAndRemove();
}
