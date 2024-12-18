**1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md**

**Bold.** \
_Italicized._ \
~~Error!~~ \
<ins> underlined text </ins>

**2. practice git using the platform. list the git commands you learned**
```bash
git add .
git commit -m "first commit"
git merge
git rebase
```

**3. What is the basic steps to init a git repo in you local?**
```bash
cd <working_dir>
git init
```

**4. How to clone a repo from Github?**
```bash
git clone <repo_url>
```

**5. How to create a new branch and checkout to that branch?**

Method 1:
```bash
git branch branch_name
git checkout branch_name
```
Method 2:
```brach
git checkout -b branch_name
```
**6. How to merge the branch_test to master branch in command? show me the commands**
```bash
# ensure we are on the master branch
git checkout master
git pull origin master

# merge
git merge brach_test

## solve conflicts if they occurs ##

# push the updated master branch
git push origin master
```

**7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash? try commands way and intellij way.**
- Command way
```bash
git stash
git checkout branch_2
```

```bash
git checkout branch_learn_stash
git stash pop
```

- Intellij way

1. Find "Stash" to stash changes in Version Control window
2. Switch branches
3. Open stash list in Version Control window and select pop when back to branch_learn_stash

**8. How do you understand PR is based on Branch?**

PR is a request to merge changes from the branch where our work has been done into the main branch,
which means it would related to a set of commits on a particular branch.


**9. What is maven role ? what it be used to do?**

- Manage dependencies automatically (Package)
- Standardize project structure and lifecycle
- Compile, test, and deploy code
- Integrate plugins


**10. What is the lifecycle of maven? could you tell me the details?**

- Prepare-resources: customized resource copying
- Validate: validates if the project is correct and if all necessary information is available.
- Compile: source code compilation is done in this phase.
- Test: tests the compiled source code suitable for testing framework.
- Package: creates the JAR/WAR package as mentioned in the packaging in POM.xml.
- Install: installs the package in local/remote maven repository.
- Deploy: copies the final package to the remote repository.


**11. What is the difference between package and install in maven lifecycle?**

Both of them would compile, test, and package the code. However, `package` only places codes in the target directory,
while `install`  would then install the resulting into local Maven repository.

**12. What is plugins in maven, list some plugins.**

- maven-compiler-plugin: Compiles the Java source code.
- maven-jar-plugin: Packages the project as a JAR.
- maven-deploy-plugin: Deploys the artifact to a remote repository.
- maven-clean-plugin: Cleans the project by removing the target directory.

**13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:**
1. groupID: com.chuwa.learn
2. artifactID: java-core

