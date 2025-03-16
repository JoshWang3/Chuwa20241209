### HW1: Git

#### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
	1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formattin
g-on-github/basic-writing-and-formatting-syntax


#### 2. practice git using the platform. list the git commands you learned
	1. https://learngitbranching.js.org/


#### 3. What is the basic steps to init a git repo in you local ?
```
	Go to to the directory
	git init – Initialize a new Git repository.
	git add . – Add all files to the staging area.
	git commit -m "message" – Commit changes with a message.

```
#### 4. How to clone a repo from Github ?

```
	Get the repository URL
	Navigate to the directory where I want to clone the repo
	Use the git clone command  to clone the reo
	Navigate into the cloned repository folder.
	git status – Check the status of your repository.
```

#### 5. How to create a new branch and checkout to that branch ?
```
	Create a new branch:	git branch <branch-name>
	Switch (checkout) to the new branch:	git checkout <branch-name>
	Or	create and switch to the new branch in one command:	git checkout -b <branch-name>
	Verify the new branch:	git branch
```

#### 6. How to merge the branch_test to master branch in command ? show me the commands
```	
git checkout master
git pull origin master
git merge branch_test

Resolve any merge conflicts:
	git add <file1> <file2>
	git commit
	git push origin master

Or, Rebase Instead of Merge:
	git checkout branch_test
	git rebase master
	git checkout master
	git merge branch_test
	git push origin master
```

#### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? 
#### try commands way and intellij way.

```
Stashing Changes:
	git status
	git stash
	git stash list
	git checkout master

Popping Stash:
	git checkout branch_learn_stash
	git stash pop

Stash with a message:
	git stash save "A message"
	git stash apply stash@{n}
	git stash drop stash@{n}
	git stash clear
```

#### 8. How do you understand PR is based on Branch?

```
A Pull Request (PR) is a feature in Git-based platforms, such as GitHub, GitLab, that allows developers to propose changes to a codebase.

The key concepts are Branch, Pull Request (PR), Base Branch(main, master), Compare Branch(feature branch)

Base Branch is the target branch where we want to merge the changes.
Compare Branch is the source branch containing your changes.

Steps to Create a PR Based on a Branch:
	1, Create a New Branch:	git checkout -b feature-branch
	2, Make Changes and Commit:	
		git add .
		git commit -m "Add new feature"
	3, Push the Branch to Remote:
		git push origin feature-branch
	4, Create a PR:
		Go to your Git hosting platform, such as GitHub, GitLab.
		Navigate to the repository and click on "New Pull Request".
		Select the Base Branch(main) and the Compare Branch (feature-branch).
		Add a title and description for the PR.
		Click "Create Pull Request".
```

#### 9. What is maven role ? what it be used to do ?

```
Maven is a powerful build automation and project management tool primarily used for Java projects. 

It simplifies the process of building, managing, and deploying projects.

Maven's Role are:
	Build Automation
	Dependency Management
	Project Standardization
	Lifecycle Management, such as compile, test, package, install, and deploy.
	Plugin Ecosystem

Maven is Used For:
	Compiling Code
	Running Tests
	Packaging Applications
	Installing Artifacts
	Deploying Artifacts
	Managing Dependencies
	Generating Documentation
	Running Custom Build Tasks
 
Key Components of Maven:
	POM (Project Object Model):
		The pom.xml file is the core of a Maven project. It defines:
		Project metadata (e.g., groupId, artifactId, version).
		Dependencies.
		Build plugins and configurations.
		Build lifecycle phases and goals.
	
	Build Lifecycle:
		Maven's build lifecycle consists of phases like:
			validate: Validate the project.
			compile: Compile the source code.
			test: Run unit tests.
			package: Package the compiled code.
			install: Install the package into the local repository.
			deploy: Deploy the package to a remote repository.
	
Advantages of Maven:
	Standardization: 	Enforces a consistent project structure and build process.
	Dependency Management: 	Simplifies dependency management and avoids version conflicts.
	Reusability: 	Allows sharing of artifacts across projects.
	Extensibility: 	Supports plugins for custom tasks.
	Integration: 	Integrates with CI/CD tools like Jenkins, GitLab CI, and Travis CI.

```


#### 10. What is the lifecycle of maven? could you tell me the details ?

```
Maven's lifecycle provides a standardized way to build and manage projects.

When we run a specific phase, Maven executes all phases up to and including that phase in the defined order.

The Default Lifecycle is the most commonly used lifecycle. It handles the compilation, testing, packaging, and deployment of the project.

Phase		Description
validate	Validates the project structure and ensures all necessary information is available.
compile		Compiles the source code of the project.
test		Runs unit tests using a suitable testing framework, such as JUnit.
package		Packages the compiled code into a distributable format, such as JAR, WAR.
verify		Runs integration tests and checks to ensure the package is valid.
install		Installs the package into the local repository for use in other projects.
deploy		Deploys the package to a remote repository for sharing with others.

The Clean Lifecycle is used to clean up the project by removing previous build artifacts. 
It has phases like pre-clean, clean, post-clean.

The Site Lifecycle is used to generate project documentation and reports.
```

#### 11. what is the difference between package and install in maven lifecycle ?

```
package: Creates the final artifact in the target directory.
install: Installs the artifact into the local Maven repository for use in other projects.

Use cases:
	package:
		When we want to create the final artifact for deployment or distribution.
		When we don't need the artifact to be available in the local repository.
	install:
		When we want to make the artifact available for other projects on the same machine.
		When we are developing multiple modules and need to share artifacts between them.
	
The package phase is responsible for packaging the compiled code and resources into a distributable format, such as JAR, WAR, EAR.
It creates the final artifact in the target directory.
The command is mvn package.
The output of the package phase is the packaged artifact, such as a .jar file, located in the target directory.

The install phase is responsible for installing the packaged artifact into the local Maven repository.
Usually located at ~/.m2/repository.

Example:
	Use the Artifact in Another Project:
	<dependency>
		<groupId>com.example</groupId>
		<artifactId>my-app</artifactId>
		<version>1.0</version>
	</dependency>
```

#### 12. What is plugins in maven, list some plugins.

```
Plugins extend Maven's functionality by providing additional goals.
Common plugins include maven-compiler-plugin, maven-surefire-plugin, maven-jar-plugin, and maven-site-plugin.
Plugins are configured in the pom.xml file and can be executed during specific phases of the Maven lifecycle.

Common Maven Plugins are:
1, core plugins:
	maven-compiler-plugin, maven-surefire-plugin(running unit tests), maven-jar-plugin, maven-jar-plugin
2, Reporting Plugins:
	maven-site-plugin(Generates project documentation and reports)， maven-javadoc-plugin	
3, Utility Plugins:
	maven-clean-plugin(Cleans the project by removing the target directory.)
	maven-resources-plugin(Copies resources (e.g., configuration files) to the output directory.)
	maven-dependency-plugin(Manages project dependencies)，
	maven-assembly-plugin（Creates custom distributions of the project, such as ZIP, TAR.
```

#### 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:

#### 1. groupID: com.chuwa.learn 

#### 2. artifactID: java-core

```
See Coding/hw1:

The pom.xml of Java-core module is:
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0"
			 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		<modelVersion>4.0.0</modelVersion>
		<parent>
			<groupId>org.example</groupId>
			<artifactId>HW1_Q13</artifactId>
			<version>1.0-SNAPSHOT</version>
		</parent>

		<groupId>com.chuwa.learn</groupId>
		<artifactId>java-core</artifactId>
		<version>1.0-SNAPSHOT</version>

		<properties>
			<maven.compiler.source>8</maven.compiler.source>
			<maven.compiler.target>8</maven.compiler.target>
			<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		</properties>

	</project>

The pom.xml of parent is:
	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0"
			 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		<modelVersion>4.0.0</modelVersion>

		<groupId>org.example</groupId>
		<artifactId>HW1_Q13</artifactId>
		<version>1.0-SNAPSHOT</version>
		<packaging>pom</packaging>
		<modules>
			<module>java-core</module>
		</modules>

		<properties>
			<maven.compiler.source>8</maven.compiler.source>
			<maven.compiler.target>8</maven.compiler.target>
			<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		</properties>

	</project>
```

#### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.