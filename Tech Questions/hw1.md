# HW1
## Questions:
### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

### 2. practice git using the platform. list the git commands you learned
1. `git commit`: Git compress a commit as a set of changes and record a snapshot in the repository
2. `git branch`: create a new branch to divide works
3. `git merge {branch}`: Merge the specific branch into main branch
4. `git checkout {branch}`: Switch to another branch
5. `git rebase {branch}`: change a series of commits
6. `git reset {commit id}`: move the repository back to previous commit
7. `git revert {commit id}`: create a new commit and undo changes in previous commit

### 3. What is the basic steps to init a git repo in you local ?
1. Switch to the directory to init a git repo
2. `git init` 


### 4. How to clone a repo from Github ?
`git clone {repository-link}`
The link format could be SSH or HTTPS

### 5. How to create a new branch and checkout to that branch ?
1. `git branch {new_branch_name}`
2. `git checkout {new_branch_name}`

### 6. How to merge the branch_test to master branch in command ? show me the commands
1. `git checkout main` (main name could be different)
2. `git merge branch_test`

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
Command way:
1. `git stach`
2. (checkout to other branch then back)
3. `git stach pop`


Intellij way:
Shelve Changes -> Unshelve Changes


### 8. How do you understand PR is based on Branch?
- PR is a request to merge changes from one Branch to another Branch. PR will show the difference between source branch and the target branch.

### 9. What is maven role ? what it be used to do ?
- Manage dependencies: manage and standardize the version in the project
- Build projects: Maven starts the automation in download dependencies then manage code compilation, packaging and artifact generation
- Documentation: Maven creates project documentation of project information, build information, and plugins.
- Reporting: Maven reports take the form of plugin goals to display the current state of the project.

### 10. What is the lifecycle of maven? could you tell me the details ?
1. `clean`: handles project cleaning, then call other build phases like dependency, `package` or `site`
2. `validate`: validate project's correctness and all necessary information is available
3. `compile`: compile the project source code
4. `test`: test the compiled source code using unit testing
5. `package`: take compiled code to create JAR/WAR packages (pom.xml)
6. `verify`: run any checks on results of integration tests
7. `install`: install the package into local repository as dependency
8. `deploy`: copy the final package to the remote repository

### 11. what is the difference between package and install in maven lifecycle ?
- `mvn install`: compiles the source codem run tests, and packages the compiled code into a JAR or WAR file. Install project's artifacts into local Maven repo.
- `mvn package`: include compile, run tests and package like `mvn install`, but it won't install the artifact to local Maven repo.

### 12. What is plugins in maven, list some plugins.
Plugins are the main feature of Maven that allow the reuse of common build functions across multiple projects.
1. Build plugins are executed during the build and configured in the `<build/>` element.
   - e.g. `compile`, `jar`, `war`, `clean`
2. Reporting Plugins are used for generating reports about the project. These are defined in the `<reporting>` section in the pom.xml file.
   - e.g. `project-info-reports:ci-management`, `project-info-reports:modules`, `project-info-reports:dependency-info`

### 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core
   <groupId>com.chuwa.learn</groupId>
   <artifactId>java-core</artifactId>

### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.