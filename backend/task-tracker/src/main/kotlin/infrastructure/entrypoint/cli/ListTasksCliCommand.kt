package com.kcubero27.backend.taskTracker.infrastructure.entrypoint.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.kcubero27.backend.taskTracker.application.service.FindAllTasksService
import com.kcubero27.backend.taskTracker.domain.service.TaskService
import com.kcubero27.backend.taskTracker.infrastructure.repository.TaskRepositoryFile
import java.io.File

class ListTasksCliCommand : CliktCommand(name = "list") {
    private val findAllTasksService = FindAllTasksService(TaskService(TaskRepositoryFile()))

    override fun run() {
        val tasks = findAllTasksService.findAll()
        if (tasks.isEmpty()) {
            println("No tasks found.")
        } else {
            tasks.forEach { task ->
                println("ID: ${task.id}, Description: ${task.description}, Status: ${task.status}, Created At: ${task.createdAt}, Updated At: ${task.updatedAt}")
            }
        }
    }
}