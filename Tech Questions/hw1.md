# hw1

---

### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

### 2. practice git using the platform. list the git commands you learned
1. https://learngitbranching.js.org/

### 3. What is the basic steps to init a git repo in your local?
1. Navigate to the desired directory:
   ```
   cd /path/to/your/project
   ```
2. Initialize the Git repository:
   ```
   git init
   ``` 

### 4. How to clone a repo from Github?
```
git clone <repo_url>
```

### 5. How to create a new branch and checkout to that branch?
- Run the following commands:
```
git branch <branch_name>
git checkout <branch_name>
```
- Or use a single command:
```
git checkout -b <branch_name>
```

### 6. How to merge the branch_test to master branch in command?
1. Switch to the `master` branch:
```
git checkout master
```
2. Merge `branch_test` into `master`:
```
git merge branch_test
```

### 7. How to stash your new code before leaving branch `branch_learn_stash` and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.
1. Save uncommitted changes:
```
git stash
```
2. Switch to another branch:
```
git checkout <other_branch>
```
3. Switch back to `branch_learn_stash` and restore changes:
```
git checkout branch_learn_stash
git stash pop
```

Using IntelliJ:
- Stash changes: Go to Git > Stash Changes.
- Apply stash: Go to Git > Unstash Changes.

### 8. How do you understand PR is based on Branch?
A Pull Request (PR) is based on a branch because:

- It allows you to merge changes from a feature branch into another branch (e.g., `main`).
- PRs isolate specific features or fixes for review without affecting other branches.

### 9. What is Maven role? What is it used to do?
Maven is a project management and build automation tool. It is used for:

- Managing project dependencies.
- Compiling, testing, and packaging Java projects.
- Running automated tests.
- Deploying projects.

### 10. What is the lifecycle of Maven? Could you tell me the details?
Maven's default lifecycle includes the following phases:

1. `validate` - Validate the project structure.
2. `compile` - Compile the source code.
3. `test` - Run unit tests.
4. `package` - Package the compiled code into a JAR/WAR file.
5. `verify` - Run checks on the package.
6. `install` - Install the package to the local repository.
7. `deploy` - Deploy the package to a remote repository.

### 11. What is the difference between package and install in Maven lifecycle?
- `package`: Creates the distributable package (e.g., JAR/WAR file).
- `install`: Installs the package into the local Maven repository for use by other projects.

### 12. What are plugins in Maven? List some plugins.
Plugins in Maven are used to add functionalities to the build process. Some examples include:

- `maven-compiler-plugin` - Compiles the source code.
- `maven-surefire-plugin` - Runs unit tests.
- `maven-jar-plugin` - Creates JAR files.
- `maven-clean-plugin` - Cleans the project directory.
- `maven-deploy-plugin` - Deploys artifacts to a remote repository.
