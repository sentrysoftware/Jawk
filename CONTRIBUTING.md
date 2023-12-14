# Contributing

## Boost vs LGPL vs GPL

The original code from Danny Daglas was under the Boost Software License. The current code is now mainly under LGPL, which means it's actually GPLv3, but can be used in non-GPL projects.

**Important:**

* The `Jawk.jar`` executable artifact is released under strict GPLv3.
* The `jawk`` Maven artifact is released under LGPL and can be used in non-GPL projects.

Each file includes a license header. Make sure to always include this header.

To update all Java files to include the header, simply use the command below:

```bash
$ mvn license:update-file-header
```

## How to build

Jawk uses Maven 2+ as build system, which you have to install first.
If you did so, you can:

compile & package:

	mvn package

execute:

	mvn exec:java

create project documentation (to be found under `target/site/index.html`):

	mvn site

Jawk relies on [BCEL](http://commons.apache.org/bcel/) for parsing AWK scripts.


## Release

### Prepare "target/" for the release process

	mvn release:clean

### Prepare the release
* asks for the release and new snapshot versions to use (for all modules)
* packages
* signs with GPG
* commits
* tags
* pushes to origin

		mvn release:prepare

### Perform the release
* checks-out the release tag
* builds
* deploy into Sonatype staging repository

		mvn release:perform

### Promote it on Maven
Moves it from the Sonatype staging to the main Sonatype repo.

1. using the Nexus staging plugin:

		mvn nexus:staging-close
		mvn nexus:staging-release

2. ... alternatively, using the web-interface:
	* firefox https://oss.sonatype.org
	* login
	* got to the "Staging Repositories" tab
	* select "org.sentrysoftware..."
	* "Close" it
	* select "org.sentrysoftware..." again
	* "Release" it

