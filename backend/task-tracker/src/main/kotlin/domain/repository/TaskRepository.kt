package com.kcubero27.backend.taskTracker.domain.repository

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId

interface TaskRepository {
    fun save(task: Task)
    fun findAll(): List<Task>
    fun findById(id: TaskId): Task?
    fun deleteById(id: TaskId)
    fun update(task: Task)
}