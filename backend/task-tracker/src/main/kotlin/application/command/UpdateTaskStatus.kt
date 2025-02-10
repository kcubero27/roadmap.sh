package com.kcubero27.backend.taskTracker.application.command

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.service.TaskService

// TODO: move status to another entity (?)
data class UpdateTaskStatus(val id: TaskId, val status: Task.Status)