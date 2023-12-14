package org.sentrysoftware.jawk.intermediate;

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
 * A pointer to a tuple within the list of tuples.
 * Addresses are used for jumps, especially in reaction to
 * conditional checks (i.e., if false, jump to else block, etc.).
 * <p>
 * Addresses have the following properties:
 * <ul>
 * <li>A name (label).
 * <li>An index into the tuple queue.
 * </ul>
 * An address may not necessarily have an index assigned upon creation.
 * However, upon tuple traversal, all address indexes must
 * point to a valid tuple.
 *
 * <p>
 * All addresses should have a meaningful label.
 *
 * @author Danny Daglas
 */
public interface Address {

	/**
	 * The label of the address.
	 * It is particularly useful when dumping tuples to an output stream.
	 *
	 * @return The label of the tuple.
	 */
	String label();

	/**
	 * Set the tuple index of this address.
	 * This can be deferred anytime after creation of the address,
	 * but the index must be assigned prior to traversing the tuples.
	 *
	 * @param idx The tuple location within the tuple list (queue)
	 *   for this address.
	 */
	void assignIndex(int idx);

	/**
	 * <p>index.</p>
	 *
	 * @return The index into the tuple queue/array.
	 */
	int index();
}
