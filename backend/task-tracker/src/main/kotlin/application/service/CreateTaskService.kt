package com.kcubero27.backend.taskTracker.application.service

import com.kcubero27.backend.taskTracker.domain.service.TaskService

class CreateTaskService (
    private val taskService: TaskService
){
    // TODO: pass command here (?)
    fun createTask(description: String) {
        taskService.createTask(description)
    }
}