# Homework 1
1. Learn **[MarkDown](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)** and show the basic usuage
2. Practice git using the [platform](https://learngitbranching.js.org/). List the git commands you learned.
    - `$ git add`
    - `$ git commit (-m)`
    - `$ git status`
    - `$ git remote (-v|-vv)`
    - `$ git log`
    - `$ git branch`
    - `$ git checkout (-b)`
    - `$ git diff`
    - `$ git merge`
    - `$ git rebase`
3. What is the basic steps to init a git repo in you local?
    - `$ git init`
4. How to clone a repo from Github?
    - `$ git clone`
5. How to create a new branch and checkout to that branch?
    - `$ git checkout -b <new_branch_name>` in one step
    - Or `$ git branch <new_branch_name>` then `$ git checkout <new_branch_name>`
6. How to merge the `branch_test` to master branch in command?
    - `$ git checkout master`
    - `$ git merge branch_test`
7. How to stash your new code before leaving branch `branch_learn_stash` and pop your stash when you checkout back to `branch_learn_stash`? try commands way and intellij way.
    - `$ git stash` before leaving
    - `$ git stash pop` when coming back
8. How do you understand **PR is based on Branch**?
    - A PR is set of changes that you want to merged into another branch.
9. What is maven role? what it be used to do?
    - Maven is a package management tool popular in JAVA. Similar to `npm` in NodeJS.
    - We can use Maven to manage package dependency and build the project
10. What is the lifecycle of maven? could you tell me the details?
    - Prepare Resources
    - Validate
    - Complie
    - Test
    - Package
    - Install
    - Deploy
11. what is the difference between package and install in maven lifecycle?
    - The `package` phase packed the compliled code into format like JAR or WAR, storing in `target` directory. The `install` phase will put them to `.m2/repository` and will be accessable by other projects.
12. What is plugins in maven, list some plugins.
    - Plugins are tools to extend Maven's capabilities.
    - maven-compiler-plugin
    - maven-jar-plugin
13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
    - groupID: **com.chuwa.learn**
    - artifactID: **java-core**