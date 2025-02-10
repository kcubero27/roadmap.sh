# 📝 Task Tracker CLI
Project based on: [Task Tracker](https://roadmap.sh/projects/task-tracker)

## 🚀 Description
Task tracker is a project used to track and manage your tasks. In this task, you will build a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on. This project will help you practice your programming skills, including working with the filesystem, handling user inputs, and building a simple CLI application.

## ⚙️ Pre-requisites
Before running the project, ensure you have the followings installed:
```sh
sdk install java 23-open
sdk install kotlin
sdk install gradle
```

## 🔧 Technologies Used
- **Kotlin**
- **kotlinx-cli** (CLI framework)

## 📦 Installation
1. Clone the repository:
```sh
git clone https://github.com/your-username/task-tracker-cli.git
cd task-tracker-cli
```

2. Build the project and download dependencies:  
```sh
./gradlew build
```

3. Generate the distribution scripts:
```sh
./gradlew installDist
```

## Commands

The cli name is not the name specified to the TaskCli class, but the name specified in the `settings.gradle.kts` file:
```gradle
rootProject.name = "task-tracker"
```

Commands can be run either from the root directory or from the `./build/install/task-tracker/bin` directory or using gradle `./gradlew run --args="add 'TASK_DESCRIPTION'"`

```sh
cd build/install/task-tracker/bin
./task-tracker add 'TASK_DESCRIPTION'
```