package com.kcubero27.backend.taskTracker.infrastructure.repository

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.repository.TaskRepository

class TaskRepositoryInMemory: TaskRepository {
    private val tasks = mutableListOf<Task>()

    override fun save(task: Task) {
        if (tasks.none { it.id == task.id }) {
            tasks.add(task)
        }
    }

    override fun findAll(): List<Task> {
        return tasks
    }

    override fun findById(id: TaskId): Task? {
        return tasks.find { it.id == id }
    }

    override fun deleteById(id: TaskId) {
        tasks.find { it.id == id }?.let { tasks.remove(it) }
    }

    override fun update(task: Task) {
        tasks.replaceAll { if (it.id == task.id) task else it }
    }
}