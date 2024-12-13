# Homework 1
## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
## [Basic Writing And Formatting Syntax](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
1. Headings
2. Styling Text
3. Quoting text
4. Quoting code
5. Supported color models
6. Links
7. Section links
8. Relative links
9. Custom anchors
10. Images
11. Specifying the theme an image is shown to
12. Lists
13. Nested Lists
14. Task lists
15. Mentioning people and teams
16. Referencing issues and pull requests
17. Referencing external resources
18. Uploading assets
19. Using emojis
20. Paragraphs
21. Footnotes
22. Alerts
23. Hiding content with comments
24. Ignoring Markdown formatting
25. Disabling Markdown rendering

## 2. Practice git using the platform. List the git commands you learned [Learn Git Branching](https://learngitbranching.js.org/)
1. Basic Operations
- git init: Initialize a new Git repository.
- git clone <repo_url>: Clone a remote repository to your local machine.
- git status: Check the current status of your working directory (modified, untracked files, etc.).
- git add <file>: Stage a specific file for the next commit.
- git add .: Stage all changes in the current directory.
- git commit -m "description message": Commit staged changes with a descriptive message.
- git log: View the commit history.
- git diff: Show differences between the working directory and the staging area.

2. Branch Management
- git branch: List all branches in the repository.
- git branch <branch_name>: Create a new branch.
- git checkout <branch_name>: Switch to a specific branch.
- git checkout -b <branch_name>: Create and switch to a new branch.
- git merge <branch_name>: Merge a specified branch into the current branch.
- git branch -d <branch_name>: Delete a branch (only if merged).
- git branch -D <branch_name>: Force delete a branch.

3. History and Changes
- git log --oneline: View the commit history in a concise format.
- git revert <commit_hash>: Create a new commit that undoes changes made by a previous commit.
- git reset <commit_hash>: Move the HEAD to a specific commit (can alter commit history).
- git cherry-pick <commit_hash>: Apply changes from a specific commit to the current branch.
- git stash: Temporarily save changes that are not ready to commit.
- git stash pop: Reapply the most recently stashed changes and remove it from the stash.

4. Tags
- git tag: List all tags in the repository.
- git tag <tag_name>: Create a new tag pointing to the current commit.
- git tag -d <tag_name>: Delete a tag locally.
- git push origin <tag_name>: Push a tag to the remote repository.
- git describe: Show the most recent tag reachable from the current commit.

5. Remote Repository
- git remote -v: List the remote repositories linked to the local repository.
- git pull: Fetch and merge changes from the remote repository into the current branch.
- git push: Push local changes to the remote repository.
- git push origin <branch_name>: Push a specific branch to the remote repository.
- git fetch: Fetch changes from the remote repository without merging.

6. Rewriting History
- git rebase <branch_name>: Reapply commits from the current branch onto another branch, creating a cleaner commit history.
- git rebase -i: Interactively rebase to edit, squash, or reorder commits.

7. Viewing and Comparing
- git show <commit_hash>: Show detailed information about a specific commit.
- git blame <file>: Show commit history for each line of a file.

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
- Install: Adds the package to the local repository for use by other projects.
  - Command: mvn install

## 12. What is plugins in maven, list some plugins.
Maven plugins add extra functionality to the build process:
1. maven-compiler-plugin: Compiles source code.
2. maven-surefire-plugin: Runs unit tests.
3. maven-jar-plugin: Creates JAR files.
4. maven-clean-plugin: Cleans project directories.
5. maven-deploy-plugin: Deploys artifacts to remote repositories.
6. maven-war-plugin: Packages web applications (WAR).
7. maven-shade-plugin: Creates an uber-jar with dependencies.



























