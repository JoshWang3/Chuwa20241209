# Homework 1
## Questions
### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

### 2. practice git using the platform. list the git commands you learned
The commonly used git commands are:
- `git init` for initializing a repository locally
- `git status` for displaying the state of working directory and staging area
- `git add .` for adding all new and/or updated files
- `git commit -m "message"` for committing changes with a message
- `git push origin main` for pushing to remote url
- `git pull origin main` for pulling new codes to our local project
- `git clone <repo_name.git>` for cloning a new repo in our directory
- `git checkout -b <branch_name>` for creating and checking out to "branch-name" branch

### 3. What is the basic steps to init a git repo in you local ?
The basic steps to initialize a git repo in our local machine are as follows.
- change directory to our project folder using `cd <project-name>`
- initialize git with `git init`

### 4. How to clone a repo from Github ?
For cloning a repo from Github, we can use the command
```
git clone https://github.com/JoshWang3/Chuwa20241209.git
```

### 5. How to create a new branch and checkout to that branch?
We can use `git branch` and `git checkout` to create a new branch and checkout to that branch.
1. `git branch <branch_name>`
2. `git checkout <branch_name>`

- (or) We can use one-line `git checkout -b <branch_name>`

### 6. How to merge the branch_test to master branch in command? show me the commands
To merge the branch_test to master branch safely, 
1. `git checkout branch_test`
2. `git pull`
3. `git checkout master`
4. `git pull`
5. test merge before commit and avoid a fast-forward commit by using --no-ff `git merge --no-ff --no-commit test`
6. if there is confict, run `git status` command and solve the conflict
7. `git commint -m "merged test_branch"`
8. `git push`

### 7. How to stash your new code before leaving branch **branch_learn_stash** and pop your stash when you checkout back to **branch_learn_stash**? try commands way and intellij way.
We can
- use `git stash` for stashing our new codes before leaving **branch_learn_stash** 
- do some work...
- when we are ready to checkout back to **branch_learn_stash**, use `git stash pop`

### 8. How do you understand PR is based on Branch?
PR means "Pull Request". It is a proposal to merge our newly-updated codes from a specific branch to another branch and it allows reviewing and discussion before integrating those changes.

### 9. What is maven role ? what it be used to do?
Maven is an OSS tool mainly used in Java projects, like "npm" in Node.js projects, for automating the tasks such as compiling codes, managing depedencies, running tests, generating documentation, and deploying applications. It uses a Project Object Model (pom.xml) to standardize the building of software development lifecycle.  

### 10. What is the lifecycle of maven? could you tell me the details?
The lifecyle of a maven project is 
- `clean` 
- `validate` for validating if the project is correct and all necessary information is available
- `compile` for compiling the source code
- `test` for testing the compiled source code using a suitable unit testing framework
- `package` for taking the compiled code and package it in its distributable format, such as a JAR
- `verify` to run any checks on results of integration tests to ensure quality criteria are met
- `install` the package into the local repository, and use as a dependency in other projects locally
- `site` and 
- `deploy` is done in the build environment by copying the final package to the remote repository for sharing with other developers and projects 

Every build follows the order of execution process: `clean -> prepare-resources -> validate  -> compile -> test (optional) -> package -> verify -> install -> deploy`, and we can only skip the `test` phase in order to not waste our time in building project every time, since we can setup the `test` phase in our CI/CD pipeline before pushing to production and only try to solve the errors at that time.

### 11. What is the difference between package and install in maven lifecycle?
The command `package` is used for taking the compiled code and package it in its distributable format, such as a JAR as per POM file, while `install` commands install the package (generated JAR file) into the local repository, and we can also use as a dependency in other projects locally. `install` phase comes after `package` phase.

`package` -> target folder pwd
`install` ->  ./m2 folder local

### 12. What is plugins in maven, list some plugins.
In maven, plugins are used to perform tasks for a maven build. There are two types of plugins: 'build' and 'reporting'. Build plugins will be executed during the build and they should be configured in the <build/> element from the POM. Reporting plugins will be executed during the site generation and they should be configured in the <reporting/> element from the POM.

Some popular plugins are "Lombok Maven Plugin" for reducing boilerplate code and "Maven Javadoc Plugin" for generating the API documentation. 

### 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core

### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.
