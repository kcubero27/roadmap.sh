package com.kcubero27.backend.taskTracker

import com.github.ajalt.clikt.core.main
import com.kcubero27.backend.taskTracker.application.service.CreateTaskService
import com.kcubero27.backend.taskTracker.application.service.FindAllTasksService
import com.kcubero27.backend.taskTracker.domain.service.TaskService
import com.kcubero27.backend.taskTracker.infrastructure.entrypoint.cli.MainCommand
import com.kcubero27.backend.taskTracker.infrastructure.repository.TaskRepositoryFile
import java.io.File

fun main() {
    val taskRepositoryFile = TaskRepositoryFile()
    val taskService = TaskService(taskRepositoryFile)
    val createTaskService = CreateTaskService(taskService)
    createTaskService.createTask("Task 1")
    createTaskService.createTask("Task 2")
    createTaskService.createTask("Task 3")

    val findAllTasksService = FindAllTasksService(taskService)

    val tasks = findAllTasksService.findAll()
    if (tasks.isEmpty()) {
        println("No tasks found.")
    } else {
        tasks.forEach { task ->
            println("ID: ${task.id}, Description: ${task.description}, Status: ${task.status}, Created At: ${task.createdAt}, Updated At: ${task.updatedAt}")
        }
    }
}