
### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

### 2. practice git using the platform. list the git commands you learned
```
git checkout,pull,reset,push,commit,rebase 
```

### 3. What is the basic steps to init a git repo in your local?
```
git init
```

### 4. How to clone a repo from Github?
```
git clone url
```

### 5. How to create a new branch and checkout to that branch?
```
git checkout -b branch
```


### 6. How to merge the branch_test to master branch in command?
```
git apply commit_id
```

### 7. How to stash your new code before leaving branch `branch_learn_stash` and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.
```
git stash push -m "xxx"
git checkout target_branch
git checkout branch_learn_stash
git stash pop
```

### 8. How do you understand PR is based on Branch?
```
you can merge your change from a branch into another branch
```

### 9. What is Maven role? What is it used to do?
```
Maven is a automation build tool. More easy to Compiling, testing, and packaging projects.
```

### 10. What is the lifecycle of Maven? Could you tell me the details?
```
compile stage: compile java source code.
package stage: package the code to jar file.
install stage: install package to the local repository.
deploy stage: deploy package to the remote repository.
```

### 11. What is the difference between package and install in Maven lifecycle?
```
package stage: package the code to jar file.
install stage: install package to the local repository.
```

### 12. What are plugins in Maven? List some plugins.
```
maven compiler plugin: help you compiler the source code
maven-clean-plugin: help you cleans the project directory
```
