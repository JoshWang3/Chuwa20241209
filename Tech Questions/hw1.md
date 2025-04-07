### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

### 2. practice git using the platform. list the git commands you learned 1. https://learngitbranching.js.org/

```
git commit
git branch
git checkout
git merge
```

## 3. What is the basic steps to init a git repo in you local ?

```
mkdir my-project
cd my-project
git init
```

## 4. How to clone a repo from Github ?

```
 "git clone <repository-url>"
```

## 5. How to create a new branch and checkout to that branch ?

```
$ git checkout -b new-branch-name
```

## 6. How to merge the branch_test to master branch in command ? show me the commands

```
$ git checkout master
$ git pull origin master
$ git merge branch_test
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to \*\*branch_learn_stash ? try commands way and intellij way.

```
git stash push -m "WIP: saving my changes"
git checkout other_branch
git checkout branch_learn_stash
git stash pop
```

- Go to VCS > Git > Stash Changes

- Add a message and click Stash

- Switch to another branch

- Return to branch_learn_stash

- Go to VCS > Git > Unstash Changes, select the stash, and click Pop

## 8. How do you understand PR is based on Branch?

A PR (Pull Request) is created when you want to merge changes from one branch into another (typically from a feature branch into main or develop). It is based on the branch you are working on and includes only the changes made in that branch. This allows multiple features to be developed independently and reviewed before merging.

## 9. What is maven role ? what it be used to do ?

Maven is a build automation and dependency management tool for Java-based projects. It is used to:

**_Manage project dependencies via the pom.xml_**

**Automate the build lifecycle (compile, test, package, etc.)**

**Standardize project structure**

**Generate documentation and reports**

**Support plugins for extended functionality**

## 10. What is the lifecycle of maven? could you tell me the details ?

- **validate** – Check project structure and configuration.

- **compile** – Compile the source code.

- **test** – Run unit tests using a testing framework like JUnit.

- **package** – Bundle the compiled code into a JAR or WAR.

- **verify** – Run integration tests or other verification steps.

- **install** – Install the package into the local Maven repository.

- **deploy** – Upload the package to a remote repository for sharing.

## 11. what is the difference between package and install in maven lifecycle ?

- package: Bundles the compiled code into an artifact (like a .jar or .war).
- install: Adds that packaged artifact to your local Maven repository, making it available to other projects on your machine.

## 12. What is plugins in maven, list some plugins.

- Maven plugins extend the build functionality and are invoked during specific lifecycle phases.

- **maven-compiler-plugin:** Compiles Java source code.

- **maven-surefire-plugin:** Runs unit tests.

- **maven-jar-plugin:** Packages the project into a .jar.

- **maven-clean-plugin:** Deletes previous build outputs.

- **maven-deploy-plugin:** Uploads the artifact to a remote repo.

- **maven-install-plugin:** Installs the artifact into the local repo.

## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows: 1. groupID: com.chuwa.learn 2. artifactID: java-core

## 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it
