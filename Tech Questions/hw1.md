### Short Questions

#### Learn MarkDown and show all basic usage

```
# Header 1
## Header 2
### Header 3
**bold**
_italic_
```

#### practice git, list the git commands you learned

```
git commit
git push
git pull
git branch
git checkout
git stash
git merge
git rebase
```

#### What are the basic steps to init a git repo in your local?

1. Navigate to the project directory.
```
cd <your_work_dir>
```
2. Create a new git repository.
```
git init
```
3. Add files to the repository.
```
git add .
```

#### How to clone a repo from github?
```
git clone <repo_url>
```

#### How to create a new branch and checkout to that branch?
```
git branch <branch_name>
git checkout <branch_name>
```

#### How to merge the branch_test to master branch in command?
```
git checkout master
git merge branch_test
```

#### How to stash your new code before leaving **branch_learn_stash** and pop the stash when you checkout back to **branch_learn_stash**?

```
git stash
git checkout <other_branch>
git checkout branch_learn_stash
git stash pop
```

#### How do you understand PR is based on Branch?
Pull Request is to merge the changes from a branch to another branch.

#### What is maven role? What's it used to do?
Maven's role: manage dependencies, build project, documentation, reporting, etc. Maven makes it easy to download add
and remove the dependencies or libraries.

#### What is the lifecycle of maven?

- clean: clean up the project
- prepare-resources: handles resource copying
- validate: validate the project is correct and all necessary information is available
- compile: compile the source code of the project
- test: test the compiled source code using a suitable unit testing framework
- package: take the compiled code and package it in its distributable format, such as a JAR/WAR.
- install: install the package into the local/remote repository.
- deploy: Copies the final package to the remote repository.

#### What's the difference between package and install in maven lifecycle?

- package: compile the source code, run tests, and create the final artifact (eg: JAR, WAR) in the **target** directory
- install: compile the package, and save a copy of the package in the local repository, so that it can be used as a dependency for other projects locally.

#### What is plugins in maven, list somme plugins

Plugins are executed during various phases of the maven build lifecycle, and are tools that perform tasks like compiling code,
running tests, packaging artifacts, deploying, etc.

Commonly used plugins:
- maven-compiler-plugin: Compiles Java code
- maven-surefire-plugin: Runs unit tests
- maven-jar-plugin: Packages the project as a JAR file
- maven-site-plugin: Generates project documentation site