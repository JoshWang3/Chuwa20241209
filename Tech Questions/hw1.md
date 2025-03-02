### Short Questions

#### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md  

~~~markdown
# A first-level heading
## A second-level heading
### A third-level heading
**bold text**
*italic text*
~~Strikethrough~~

to quote code:
```
git status
git add
git commit
```
~~~

#### 2. practice git using the platform. list the git commands you learned  

```
git init
git clone <repository-url>
git status
git add <file-name>
git add .
git commit -m "some message"
git branch <branch-name>
git checkout -b <branch-name>
git merge <branch-name>
git remote add origin <repository-url>
git push origin <branch-name>
git diff
```

#### 3. What is the basic steps to init a git repo in you local ? 

```
mkdir <directory-name>
cd <directory-name>
git init
```

#### 4. How to clone a repo from Github ?  

```
git clone https://github.com/JoshWang3/Chuwa20241209.git
```

#### 5. How to create a new branch and checkout to that branch ?  

```
git checkout -b <branch-name>
```

#### 6. How to merge the branch_test to master branch in command ? show me the commands  

```
git checkout master
git pull origin master
git merge branch_test
git push origin master
```

#### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.  
```
//command way:
git stash
git checkout <someotherbranch>
git checkout branch_learn_stash 
git stash pop
//intellij way:
Git-> Unicommitted Changes-> Stash Changes...-> Create Stash
Git-> Unicommitted Changes-> Unstash Changes... -> click Pop stash checkbox, Pop Stash
```

#### 8. How do you understand PR is based on Branch?  

```
We make changes on our own branch and then request to merge those changes into another branch. PR displays the changes we have made on that branch, allowing others to review them before they are merged into the main branch.
```

#### 9. What is maven role ? what it be used to do ?  

```
Maven has roles such as build management, dependency management and plugin integration.
It can compile source code and packages it into JAR or WAR files, automatically download required libraries and frameworks, integrate with testing frameworks and other plugins and deploy build artifacts to remote repositories for sharing.
```

#### 10. What is the lifecycle of maven? could you tell me the details ?  

```
validate: Checking for missing or invalid configurations
compile: Compiles the project’s source code. (from .java to .class)
test: Runs unit tests using frameworks like JUnit
package: Packages the compiled code and resources into a distributable format (e.g., JAR, WAR).
install: Installs the package into the local Maven repository for use in other projects. (~/.m2/repository)
deploy: Copies the final package to a remote repository for sharing with team members or systems.
```

#### 11. what is the difference between package and install in maven lifecycle ?  

```
package builds the artifact: jar/war, placing it in the target/ directory
install stores it locally for reuse, placing it in ~/.m2/repository for use in other projects.
```

#### 12. What is plugins in maven, list some plugins.  

```
plugins: tools to extend Maven's capabilities.
maven-shade-plugin: Creates a self-contained application fat JAR.
maven-compiler-plugin: Compiles the source code.
maven-javadoc-plugin: Generates Javadoc HTML files.
```

#### 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows: groupID: com.chuwa.learn, artifactID: java-core  
```
created in repo/Projects/java-core
```

#### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.  
