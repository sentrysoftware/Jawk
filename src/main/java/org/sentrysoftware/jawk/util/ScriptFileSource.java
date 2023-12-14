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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents one AWK-script file content source.
 *
 * @author Danny Daglas
 */
public class ScriptFileSource extends ScriptSource {

	private static final Logger LOG = LoggerFactory.getLogger(ScriptFileSource.class);

	private String filePath;
	private Reader fileReader;
	private InputStream fileInputStream;

	/**
	 * <p>Constructor for ScriptFileSource.</p>
	 *
	 * @param filePath a {@link java.lang.String} object
	 */
	public ScriptFileSource(String filePath) {
		super(filePath, null, filePath.endsWith(".ai"));

		this.filePath = filePath;
		this.fileReader = null;
		this.fileInputStream = null;
	}

	/**
	 * <p>Getter for the field <code>filePath</code>.</p>
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getFilePath() {
		return filePath;
	}

	/** {@inheritDoc} */
	@Override
	public Reader getReader() {

		if ((fileReader == null) && !isIntermediate()) {
			try {
				fileReader = new FileReader(filePath);
			} catch (FileNotFoundException ex) {
				LOG.error("Failed to open script source for reading: " + filePath, ex);
			}
		}

		return fileReader;
	}

	/** {@inheritDoc} */
	@Override
	public InputStream getInputStream() {

		if ((fileInputStream == null) && isIntermediate()) {
			try {
				fileInputStream = new FileInputStream(filePath);
			} catch (FileNotFoundException ex) {
				LOG.error("Failed to open script source for reading: " + filePath, ex);
			}
		}

		return fileInputStream;
	}
}
