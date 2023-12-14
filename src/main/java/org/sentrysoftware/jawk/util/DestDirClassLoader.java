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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Load classes from a particular directory, disregarding the
 * environmental class-path setting.
 * This is useful when a directory is specified for class files,
 * and it would not make sense to deviate from that directory.
 * So this ClassLoader does practically the same
 * like a <code>URLClassLoader</code> with a "file://.../" URL,
 * except that it does not forward calls to its parent,
 * if it can not find the class its self.
 * <p>
 * For Jawk, this is used when the -d argument is present.
 *
 * @author Danny Daglas
 */
public final class DestDirClassLoader extends ClassLoader {

	private String dirname;

	/**
	 * <p>Constructor for DestDirClassLoader.</p>
	 *
	 * @param dirname a {@link java.lang.String} object
	 */
	public DestDirClassLoader(String dirname) {
		this.dirname = dirname;
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?> findClass(String name)
			throws ClassNotFoundException
	{
		byte[] b = loadClassData(name);
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name)
			throws ClassNotFoundException
	{
		String fileName = dirname + File.separator + name + ".class";
		try {
			FileInputStream f = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] b = new byte[4096];
			int len;
			while ((len = f.read(b, 0, b.length)) >= 0) {
				baos.write(b, 0, len);
			}
			f.close();
			baos.close();
			return baos.toByteArray();
		} catch (IOException ioe) {
			throw new ClassNotFoundException(
					"Could not load class " + name
					+ " from file \"" + fileName + "\"", ioe);
		}
	}
}
