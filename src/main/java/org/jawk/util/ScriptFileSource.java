package org.jawk.util;

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
 * @version $Id: $Id
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
