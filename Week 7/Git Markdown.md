# Git Hands-on Lab

A hands-on Git laboratory project demonstrating the fundamental concepts of Git and GitHub, including repository creation, version control, branching, merging, conflict resolution, and publishing a repository to GitHub.

---

## 📌 Project Information

| Attribute | Details |
|-----------|---------|
| **Project Name** | Git Hands-on Lab |
| **Repository Name** | GitDemo |
| **Technology** | Git & GitHub |
| **IDE** | Visual Studio Code |
| **Terminal** | PowerShell |
| **Status** | Completed |

---

## 📖 Project Overview

This project was completed as part of the Git Hands-on Laboratory. It demonstrates the complete Git workflow, starting from creating a local repository to resolving merge conflicts and successfully pushing the project to GitHub.

---

## 🎯 Objectives

- Learn Git fundamentals
- Configure Git
- Create a local repository
- Track file changes
- Commit source code
- Create and manage branches
- Merge branches
- Resolve merge conflicts
- Connect Git with GitHub
- Push the repository to GitHub

---

## 🛠 Technologies Used

- Git
- GitHub
- Visual Studio Code
- PowerShell

---

## 📂 Repository Structure

```text
GitDemo/
│
├── hello.xml
├── welcome.txt
└── README.md
```

---

# Git Workflow

## Step 1 – Create Local Repository

- Created a new project folder
- Initialized a Git repository
- Configured Git username and email

### Commands

```bash
mkdir GitDemo
cd GitDemo
git init

git config user.name "Prince Maurya"
git config user.email "your-email@example.com"
```

---

## Step 2 – Create Initial Commit

- Created the project files
- Added files to the staging area
- Created the first commit

### Commands

```bash
git add .
git commit -m "Add welcome.txt as initial commit"
```

---

## Step 3 – Create and Switch Branch

- Created a new branch named **GitWork**
- Switched to the new branch
- Modified project files
- Committed changes

### Commands

```bash
git branch GitWork
git checkout GitWork

git add hello.xml
git commit -m "Add hello.xml with initial content on GitWork"
```

---

## Step 4 – Modify Master Branch

- Switched back to the master branch
- Modified the same file
- Created another commit

### Commands

```bash
git checkout master

git add hello.xml
git commit -m "Add hello.xml with master-specific content"
```

---

## Step 5 – Resolve Merge Conflict

- Attempted to merge branches
- Merge conflict occurred
- Edited the conflicting file
- Removed conflict markers
- Committed the resolved version

### Commands

```bash
git merge GitWork

git add hello.xml

git commit -m "Resolve merge conflict in hello.xml"
```

---

## Step 6 – Connect Repository to GitHub

- Added remote repository
- Connected local repository with GitHub

### Commands

```bash
git remote add origin https://github.com/Prince-morya/GitDemo.git
```

---

## Step 7 – Push Repository

Successfully uploaded the local repository to GitHub.

### Command

```bash
git push -u origin master
```

---

# Git Commands Practiced

```bash
git init
git config
git status
git add
git commit
git branch
git checkout
git merge
git log
git remote add origin
git push
```

---

## 📚 Learning Outcomes

After completing this lab, I gained practical experience in:

- Git installation and configuration
- Repository initialization
- Tracking project files
- Creating commits
- Branch creation and switching
- Merging branches
- Resolving merge conflicts
- Connecting local repositories with GitHub
- Uploading projects to GitHub

---

## ✅ Conclusion

This Git Hands-on Lab successfully demonstrated the complete Git workflow. The project included repository initialization, version control, branch management, merge conflict resolution, and GitHub integration. The repository was successfully uploaded to GitHub, providing practical experience with real-world Git operations.

---

## 👨‍💻 Author

**Prince Maurya**

- GitHub: https://github.com/Prince-morya

---

## 📄 License

This project is intended for educational and learning purposes.