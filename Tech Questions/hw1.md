## HW1 Short Questions
### Question 1
**This is bold text**  
_This text is italicized_  
~~This was mistaken text~~  
This is an <ins>underlined</ins> text  
> Text that is a quote  
# A first-level heading
## A second-level heading
### A third-level heading
Some basic Git commands are:
```
git status
git add
git commit
```
<br>

### Question 2
- **git commit -m "description message"**: commit changes  
- **git branch <branch_name>**: create a new branch
- **git checkout <branch_name>**: switch to a different branch
- **git checkout -b**: create and switch to a new branch
- **git merge <branch_name>**: merge a branch into a current branch
- **git rebase**: rebase the current branch onto another branch, simplified commit history
- **git revert**: creates a new commit that undoes the changes of a previous commit without changing the project history
- **git reset**: moves the HEAD to a previous state and can alter the commit history.
- **git cherry-pick**: apply the changes from a specific commit from one branch onto another branch
- **git tag**: create a reference to a specific commit in the repository
- **git describe**: show the most recent tag

<br>

### Question 3
1. Create and go to the directory where you want to initialize the Git repository.  
```
mkdir my-repo
cd my-repo
```
2. Initialize the git repo
```
git init
```
3. Add files to git
```
git add .
```
4. Make the first commit
```
git commit -m "Initial commit"
```

<br>

### Question 4
1. Find the github repository URL
2. Open the terminal and run git clone command
```
git clone https://github.com/JoshWang3/Chuwa20241209.git
```
<br>

### Question 5
1. Create a new branch, then switch to the new branch
```
git branch new_branch
git checkout new_branch
```
2. Create and switch to a new branch in one command
```
git checkout -b new_branch
```
<br>

### Question 6
1. Switch to master branch
```
git checkout master
```
2. Ensure the master branch is up to date
```
git pull origin master
```
3. Merge branch_test into master
```
git merge branch_test
```
4. Push the merged changes to the remote repository
```
git push origin master 
```
<br>

### Question 7
Git commands:
```
git stash save "stash my code"
git checkout main
git checkout branch_learn_stash 
git stash pop
```
<br>

### Question 8
Because we make changes on a separate branch and then request to merge those changes into another branch (such as the main branch).
A PR essentially displays the changes we have made on a branch, allowing others to review them before they are merged into the main branch.
<br>

### Question 9
Maven is a build automation tool used primarily for Java projects, but it can be applied to other languages as well. It helps manage project dependencies, build, package, and deploy applications efficiently.

**Maven roles**：
- Manage Dependencies(Package).  
  - Maven downloads and includes these libraries from a central repository, so you don't have to manually handle them.
- Build Project (Cycle)  
  - Maven automates the process of compiling the code, running tests, and packaging the project.
- Documentation (include project-related reports, javadocs)
- Reporting (include testing results, code coverage, quality metrics)
- Others (running integration tests, deploying the project to a repository)


<br>

### Question 10
**Life cycle of Maven**  
`prepare-resources` Resource copying can be customized in this phase.  
`validate` Validates if the project is correct and if all necessary information
is available.  
`compile` Source code compilation is done in this phase.  
`test` Tests the compiled source code suitable for testing framework.  
`package` This phase creates the JAR/WAR package as mentioned in the
packaging in POM.xml.  
`install` This phase installs the package in local/remote maven
repository.  
`deploy` Copies the final package to the remote repository.


<br>

### Question 11
**package**：  
- takes the compiled code and packaging it into a format that is suitable for distribution or deployment (such as a .jar, .war file).
- occurs after the source code is compiled and the tests are run  
- at the end of the package phase, you get a packaged artifact that is stored locally in the target/ directory of your project  

**install**：
- installs the packaged artifact into your local Maven repository (usually located in ~/.m2/repository/). This allows other projects or modules on your local system to reference and use the artifact.  
- comes after the package phase. It installs the artifact into the local repository so it can be used by other Maven projects 
- at the end of the install phase, the packaged artifact is stored in your local Maven repository  

<br>

### Question 12
**Plugins in Maven**:  
In Maven, plugins are tools that extend the functionality of Maven and allow you to perform various tasks during the build lifecycle, such as compiling code, packaging files, running tests, deploying artifacts, and more. Plugins are a fundamental part of Maven's flexibility, and they help automate the build process.  

**Common Maven plugins**:
1. **Maven Compiler Plugin**
  - Purpose: Compiles your project's source code.
  - Common Goals:
    - `compile`: Compiles the main source code.
    - `testCompile`: Compiles the test source code.

2. **Maven Surefire Plugin**
  - Purpose: Runs unit tests during the build process.
  - Common Goals:
    - `test`: Runs the unit tests in your project.

3. **Maven Clean Plugin**
  - Purpose: Cleans up the target directory to remove previous build artifacts.
  - Common Goals:
    - `clean`: Deletes the target/ directory.

4. **Maven Jar Plugin**
  - Purpose: Creates a JAR file from your project's compiled classes.
  - Common Goals:
    - `jar`: Packages your project into a JAR file.

5. **Maven Deploy Plugin**
  - Purpose: Deploys your project to a remote repository.
  - Common Goals:
    - `deploy`: Uploads the packaged artifact to a remote repository.

6. **Maven Install Plugin**
  - Purpose: Installs the artifact into your local Maven repository.
  - Common Goals:
    - `install`: Copies the built artifact into the local repository.

7. **Maven Dependency Plugin**
  - Purpose: Resolves and manages project dependencies.
  - Common Goals:
    - `copy`: Copies dependencies to a specific location.
    - `tree`: Displays the dependency tree for the project.

8. **Maven Site Plugin**
  - Purpose: Generates project documentation.
  - Common Goals:
    - `site`: Generates the site documentation.
<br>

### Question 13
See details in repo/Projects/MavenProject
<br>



