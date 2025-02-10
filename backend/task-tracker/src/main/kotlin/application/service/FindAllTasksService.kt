package com.kcubero27.backend.taskTracker.application.service

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.service.TaskService

class FindAllTasksService(private val taskService: TaskService) {
    fun findAll(): List<Task> {
        return taskService.findAllTasks()
    }
}