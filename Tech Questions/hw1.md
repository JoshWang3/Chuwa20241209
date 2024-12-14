2. git commands:
   1. git init
   2. git clone
   3. git add
   4. git commit
   5. git status
   6. git log
   7. git branch
   8. git checkout
   9. git merge
   10. git stash
   11. git stash pop
   12. git push
   13. git pop
3. basic steps to init a git repo:
   1. cd <working-dir>
   2. git init
   3. git add .
   4. git commit -m "initial commit"
4. clone a repo;
   1. git clone <repo-url>
5. create a new branch nd checkout:
   1. git branch <branch-name>
   2. git checkout <branch-name>
6. merge:
   1. git checkout master
   2. git merge branch_test
7. stash:
   1. command
      1. git stash
      2. git checkout branch_learn_stash
      3. git stash pop
   2. intelliJ:
      1. open git menu
      2. stash changes
      3. checkout branch_learn_stash
      4. unstash changes
8. PR
   1. PR compares changes between branches. It helps review and avoid merge conflicts between branches.
9. maven:
   1. maven is a build automation tool
10. maven lifecycle:
    1. validate
    2. compile
    3. test
    4. package
    5. verify
    6. install
    7. deploy
11. package vs install
    1. package creates a JAR/WAR file
    2. install places the JAR/WAR into the Maven Repository
12. plugins:
    1. They are used for specific tasks during the build lifecycle.
    2. examples:
       1. maven-compiler-plugin
       2. maven-surefire-plugin
       3. maven-clean-plugin
