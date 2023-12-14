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
 * A placeholder for an object which has a reference to
 * a function address, but which may not be realized yet.
 * This is particularly important for forward-referenced
 * functions. For example:
 * <blockquote>
 * <pre>
 * BEGIN { f(3) }
 * function f(x) { print x*x }
 * </pre>
 * </blockquote>
 * f() is referred to prior to its definition. Therefore,
 * the getFunctionAddress() call within the BEGIN block
 * will not return a meaningful address. However, anytime
 * after f(x) is defined, getFunctionAddress() will return
 * the correct function address.
 *
 * @author Danny Daglas
 */
public interface HasFunctionAddress {

	/**
	 * Get an address to the tuple where this function is
	 * defined.
	 * <p>
	 * If getFunctionAddress() is called prior to defining
	 * the function address (prior to parsing the function
	 * block), the result is undefined. (As of this writing,
	 * a NullPointerException is thrown.)
	 *
	 * @return a {@link org.sentrysoftware.jawk.intermediate.Address} object
	 */
	Address getFunctionAddress();
}
