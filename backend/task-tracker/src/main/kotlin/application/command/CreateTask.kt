package com.kcubero27.backend.taskTracker.application.command

import com.kcubero27.backend.taskTracker.domain.service.TaskService

data class CreateTask(val description: String)