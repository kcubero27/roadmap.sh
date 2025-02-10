package com.kcubero27.backend.taskTracker.application.command

import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.service.TaskService

data class DeleteTask(val id: TaskId)