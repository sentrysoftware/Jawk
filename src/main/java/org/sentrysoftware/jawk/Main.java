package org.sentrysoftware.jawk;

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

import java.io.InputStream;
import java.io.PrintStream;

import org.sentrysoftware.jawk.util.AwkParameters;
import org.sentrysoftware.jawk.util.AwkSettings;

/**
 * Entry point into the parsing, analysis, and execution/compilation
 * of a Jawk script.
 * This entry point is used when Jawk is executed as a stand-alone application.
 * If you want to use Jawk as a library, please use {@see Awk}.
 *
 * @author Danny Daglas
 */
public class Main {

	/**
	 * Prohibit the instantiation of this class, other than the
	 * way required by JSR 223.
	 */
	@SuppressWarnings("unused")
	private Main() {}

	/**
	 * Class constructor to support the JSR 223 scripting interface
	 * already provided by Java SE 6.
	 *
	 * @param args String arguments from the command-line.
	 * @param is The input stream to use as stdin.
	 * @param os The output stream to use as stdout.
	 * @param es The output stream to use as stderr.
	 * @throws java.lang.Exception enables exceptions to propagate to the callee.
	 */
	public Main(String[] args, InputStream is, PrintStream os, PrintStream es)
			throws Exception
	{
		System.setIn(is);
		System.setOut(os);
		System.setErr(es);

		AwkSettings settings = AwkParameters.parseCommandLineArguments(args);
		Awk awk = new Awk();
		awk.invoke(settings);
	}

	/**
	 * The entry point to Jawk for the VM.
	 * <p>
	 * The main method is a simple call to the invoke method.
	 * The current implementation is basically as follows:
	 * <blockquote>
	 * <pre>
	 * System.exit(invoke(args));
	 * </pre>
	 * </blockquote>
	 *
	 * @param args Command line arguments to the VM.
	 */
	public static void main(String[] args) {

		try {
			AwkSettings settings = AwkParameters.parseCommandLineArguments(args);
			Awk awk = new Awk();
			awk.invoke(settings);
		} catch (ExitException e) {
			System.exit(e.getCode());
		} catch (Exception e) {
			System.err.printf("%s: %s", e.getClass().getSimpleName(), e.getMessage());
			System.exit(1);
		}

	}


}
