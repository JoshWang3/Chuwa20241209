# Short Questions
## Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
Will show the basic usage in this readme.md

## practice git using the platform. list the git commands you learned
git commit: make changes to the repository and save them as a commit
git branch: create a new branch
git merge bugFix: Merges the bugFix branch into the current branch.
git rebase: Move commits to a new base for a cleaner history.
(^): find the parent of the specified commit.
(~): move a lot of levels up in the commit tree.

## What is the basic steps to init a git repo in you local ?
> Open Git Bash.
> Navigate to the project directory.
```
cd my_project
```
> Initialize a new git repository.
```
git init
```
> Add files into the local repository
```
git add .
```
> Coomit the files in local repository
```
git commit -m "some message"
```
> Connect to a remote repository
```
git remote add origin <URL>
```

## How to clone a repo from Github ?
> Open the terminal
```
cd <your_work_dir> 
```
> and run the command:
```
git clone <Repository-url>
```

## How to create a new branch and checkout to that branch ?
> Create a New Branch: 
```
git branch <branch-name>
```
> Checkout to that branch:
```
git checkout <branch-name>
```

## How to merge the branch_test to master branch in command ? show me the commands
git checkout master
git merge branch_test

## How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.


## How do you understand PR is based on Branch?
A pull request is a proposal to merge a set of changes from one branch into another. In a pull request, collaborators can review and discuss the proposed set of changes before they integrate the changes into the main codebase. 

## What is maven role ? what it be used to do ?
*Manage dependencies:* Maven simplifies the process of adding, updating, and managing dependencies in a project.
*Build projects:* Maven automates the build process through predefined phases in its build lifecycle.
*Documentation:* Maven can generate project documentation, including dependency analysis, plugin usage, and more.
*Reporting:* Maven provides reporting capabilities through its reporting plugins.

## What is the lifecycle of maven? could you tell me the details ?
*clean:* handles project cleaning
*validate:* validate the project is correct and all necessary information is available
*compile:* compile the source code of the project
*test:* test the compiled source code using a suitable unit testing framework. Thses tests should not require the code be packaged or deployed
*package:* take the compiled code and package it in its distributable format, such as JAR
*verify:* run any checks on results of integration tests to ensure quality criteria are met
*install:* install the package into the local repository, for use as a dependency in other projects locally
*site:* handles the creation of the project's website
*deploy:* done in the build environment, copies the final package to the remote repository for sharing with other developers and projects

## what is the difference between package and install in maven lifecycle ?
- mvn package command will compile source code and also package it as a jar or war as per pom file and put it  into the target folder(by default).
- mvn install command will compile and package, but it will also put the package in your local repository. So that other projects can refer to it and grab it from your local repository.

## What is plugins in maven, list some plugins.
Plugins are reusable components that provide specific functionality to extend the build and management process.
The plugins are divided into two types.Build Plugins and Reporting Plugins.
Build Plugins are defined in the <build> section in the pom.xml file. For example, Compiler Plugin, Surefire Plugin, and Assembly Plugin.
Reporting Plugins are defined in the <reporting> section in the pom.xml file. For example, Surefire Report Plugin for generating test reports and Javadoc Plugin for generating API documentation.

## In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
```
<groupId>com.chuwa.learn</groupId>
<artifactId>java-core</artifactId>
```

## Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
students' PR, please don't merge it.
git pull origin first_name/notes
git pull origin main # you will see hw1.md in shortQuestions directory
