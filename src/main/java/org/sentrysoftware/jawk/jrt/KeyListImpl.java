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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implement the KeyList interface with an ArrayList.
 *
 * @author Danny Daglas
 */
//public class KeyListImpl extends ArrayList<Object> implements KeyList
public class KeyListImpl implements KeyList {

	private List<Object> list;

	/**
	 * Convert the set to a KeyList.
	 * We could have used an ArrayList directly. However, tagging
	 * the implementation with a KeyList interface improves type
	 * checking within the parsing / semantic analysis phase.
	 *
	 * @param set a {@link java.util.Set} object
	 */
	public KeyListImpl(Set<Object> set) {
		//super(set);
		list = new ArrayList<Object>(set);
	}

	/** {@inheritDoc} */
	@Override
	public final Object getFirstAndRemove() {
		return list.remove(0);
	}

	/** {@inheritDoc} */
	@Override
	public int size() {
		return list.size();
	}
}
