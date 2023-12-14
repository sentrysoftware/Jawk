package org.sentrysoftware.jawk.util;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Represents one AWK-script content source.
 * This is usually either a string,
 * given on the command line with the first non-"-" parameter,
 * or an "*.awk" (normal) or "*.ai" (intermediate) script,
 * given as a path with a "-f" command line switch.
 *
 * @author Danny Daglas
 */
public class ScriptSource {

	/** Constant <code>DESCRIPTION_COMMAND_LINE_SCRIPT="&lt;command-line-supplied-script&gt;"</code> */
	public static final String DESCRIPTION_COMMAND_LINE_SCRIPT
			= "<command-line-supplied-script>";

	private String description;
	private Reader reader;
	private boolean intermediate;

	/**
	 * <p>Constructor for ScriptSource.</p>
	 *
	 * @param description a {@link java.lang.String} object
	 * @param reader a {@link java.io.Reader} object
	 * @param intermediate a boolean
	 */
	public ScriptSource(String description, Reader reader, boolean intermediate) {

		this.description = description;
		this.reader = reader;
		this.intermediate = intermediate;
	}

	/**
	 * <p>Getter for the field <code>description</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * Obtain the InputStream containing the intermediate file.
	 * This returns non-null only if {@see #isIntermediate()}
	 * returns <code>false</code>.
	 *
	 * @return The reader which contains the intermediate file, null if
	 *   either the -f argument is not used, or the argument does not
	 *   refer to an intermediate file.
	 * @throws java.io.IOException if any.
	 */
	public Reader getReader()
			throws IOException
	{
		return reader;
	}

	/**
	 * Returns the <code>InputStream</code> serving the contents of this source.
	 * This returns non-<code>null</code> only if {@see #isIntermediate()}
	 * returns <code>true</code>.
	 *
	 * @return a {@link java.io.InputStream} object
	 * @throws java.io.IOException if any.
	 */
	public InputStream getInputStream()
			throws IOException
	{
		return null;
	}

	/**
	 * Indicates whether the underlying source is an intermediate file.
	 * Intermediate files end with the ".ai" extension.
	 * No other determination is made whether the file is an intermediate
	 * one or not.
	 * That is, the content of the file is not checked.
	 *
	 * @return <code>true</code> if the "-f optarg" is an intermediate file
	 *   (a file ending in ".ai"), <code>false</code> otherwise.
	 */
	public final boolean isIntermediate() {
		return intermediate;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return getDescription();
	}
}
