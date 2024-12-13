# Homework 1

## 3. What is the basic steps to init a git repo in you local ?
1. Navigate to the project directory:
```
cd /path/to/your/project
```
2. Initialize the Git repository:
```
git init
```
3. Add files to the repository:
```
git add .
```
4. Commit the changes:
```
git commit -m "Commit messages"
```

## 4. How to clone a repo from Github?
```
git clone <repo_url>
```
_Example:_
```
git clone https://github.com/JoshWang3/Chuwa20241209
```

## 5. How to create a new branch and checkout to that branch ?
1. Create a new branch:
```
git branch <branch_name>
```
2. Checkout to the new branch:
```
git checkout <branch_name>
```
_Or use a single command:_
```
git checkout -b <branch_name>
```

## 6. How to merge the branch_test to master branch in command ? show me the commands
1. Switch to the master branch:
```
git checkout master
```
2. Merge branch_test into master:
```
git merge branch_test
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to **branch_learn_stash ? try commands way and intellij way.
### Using Command Line:
1. Stash changes:
```
git stash
```
2. Switch to other branches:
```
git checkout <other_branch>
```
3. Return to branch_learn_stash:
```
git checkout branch_learn_stash
```
4. Pop the stash:
```
git stash pop
```
### Using IntelliJ Idea:
1. Stash Changes: Go to VCS > Git > Stash Changes...
2. Apply Stash: Go to VCS > Git > Unstash Changes... and select the stash to apply.

## 8. How do you understand PR is based on Branch?
1. Isolates changes for specific tasks or features.
2. Enables team collaboration through reviews.
3. Controls integration to the target branch safely.

## 9. What is maven role ? what it be used to do ?
1. Build: Automates compiling and packaging (JAR/WAR).
2. Boost: Manages dependencies efficiently.
3. Test: Runs automated tests.
4. Deploy: Pushes projects to repositories.

## 10. What is the lifecycle of maven? could you tell me the details ?
1. Validate: Check project structure.
2. Compile: Compile the source code.
3. Test: Run unit tests
4. Package: Bundle code into JAR/WAR.
5. Verify: Perform quality checks.
6. Install: Add to the local repository.
7. Deploy: Push to a remote repository.

## 11. what is the difference between package and install in maven lifecycle ?
- Package: Creates the final distributable (e.g., JAR/WAR file).
  - Command: mvn package
-Install: Adds the package to the local repository for use by other projects.
  - Command: mvn install





























