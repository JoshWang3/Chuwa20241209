#  Write your hw1 in hw1.md 
## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md 
### 1.https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax 
**This is bold text**  
_This text is italicized_  
~~This was mistaken text~~  
**This text is _extremely_ important*  
This is an <ins>underlined</ins> text  

### 2. practice git using the platform. list the git commands you learned 1. https://learngitbranching.js.org/ 
```
git commit
git branch
git checkout
git merge
git rebase
```

## 3. What is the basic steps to init a git repo in you local ? 
- Open Git Bash.  
- Navigate to the root directory of your project.  
- Initialize the local directory as a Git repository. By default, the initial branch is called main. 
 
```
$git init -b main
```

## 4. How to clone a repo from Github ?
- To clone a repository from GitHub, open the terminal, navigate to the desired directory where you want to clone the repo, and run the command：

```
 "git clone <repository-url>"
```
- replacing <repository-url> with the URL of the GitHub repository you want to clone; you can find this URL on the repository's page on GitHub by clicking "Code" and copying the HTTPS link  

## 5. How to create a new branch and checkout to that branch ?
- Use the single command:  
```
$ git checkout -b your-branch-name
```
- Alternatively, we can create the branch first and then switch:
```
$ git branch your-branch-name
$ git checkout your-branch-name
```


## 6. How to merge the branch_test to master branch in command ? show me the commands 
```
$ git checkout master
$ git pull origin master
$ git merge branch_test
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
- To stash changes in the branch_learn_stash branch, use：
```
git stash push -m "message" 
```
   
Then, we can safely switch to another branch with：
```
git checkout another_branch
```
When we return to branch_learn_stash, use：
```
git checkout branch_learn_stash 
```
to switch back, and restore your saved work with： 
```
git stash pop. 
```
- In IntelliJ, we stash our changes by going to *VCS > Git > Stash Changes*, adding a message, and clicking Stash. 
- When we return to branch_learn_stash, we go to *VCS > Git > Unstash Changes*, select our stash, and click Pop to restore the changes.




## 8. How do you understand PR is based on Branch? 
- Because it involves proposing changes from one branch to another, typically from a feature or development branch into the main branch. This allows developers to work on separate features independently and then merge their changes after review. 
- Branch-based PRs help organize and manage code changes efficiently, ensuring that the main codebase remains stable.

## 9. What is maven role ? what it be used to do ? 
- **Manage Dependencies (Package):** 
Maven is widely used for dependency management. By defining dependencies in the pom.xml file, Maven automatically downloads the required libraries and their transitive dependencies from repositories. This ensures all required packages are available and compatible for the project.
- **Build Project (Cycle):**
Maven automates the entire build process using its predefined lifecycle phases, such as compile, test, package, and install. This makes building projects consistent and efficient across different environments.
- **Documentation:**   
Maven can generate project documentation based on the project structure and the pom.xml file. This includes information about dependencies, configurations, and other project details, which is useful for both developers and stakeholders.
- **Reporting:**   
Maven generates various reports, such as code quality analysis, test results, and dependency analysis. These reports help in monitoring and improving the quality of the project.
- **Others:**   
Maven also supports additional tasks like deploying applications, integrating plugins, and managing multi-module projects. It simplifies complex workflows and ensures project consistency.


## 10. What is the lifecycle of maven? could you tell me the details ? 
- **prepare** - Resource copying can be customized in this phase. 
- **validate** - the information Validates if the project is correct and if all necessary information is available.
- **compile** - Source code compilation is done in this phase.
- **Test** - Tests the compiled source code suitable for testing framework. 
- **package** - This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.
- **Install** - This phase installs the package in local/remote maven repository.
- **Deploy** - Copies the final package to the remote repository.

## 11. what is the difference between package and install in maven lifecycle ?
- package: Creates the build artifact (e.g., JAR/WAR) but does not make it available to other local projects.
- install: Creates the build artifact and places it in the local Maven repository, allowing other projects on the same machine to use it as a dependency.

## 12. What is plugins in maven, list some plugins.
- Plugins are the central feature of Maven that allow it to be highly extensible. Each plugin can contain one or more goals, which are executed during the build lifecycle.  
- **Common Maven Plugins**  
- **Compiler Plugin:** Compiles Java source code.  
- **Surefire Plugin:** Executes tests.  
- **Jar Plugin:** Packages compiled code into a JAR file.  
- **Install Plugin:** Installs the artifact into the local repository.  
- **Deploy Plugin:** Deploys the artifact to a remote repository.  


## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows: 1. groupID: com.chuwa.learn 2. artifactID: java-core 
you can find in the Project folder  

## 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it