package com.kcubero27.backend.taskTracker.domain.service

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.repository.TaskRepository

class TaskService(private val taskRepository: TaskRepository) {
    fun createTask(description: String) {
        val task = Task(description = description)
        taskRepository.save(task)
    }
    
    fun updateTaskStatus(id: TaskId, status: Task.Status) {
        val task = taskRepository.findById(id) ?: throw IllegalArgumentException("Task not found")
        task.status = status
        taskRepository.update(task)
    }
    
    fun deleteTask(id: TaskId) {
        taskRepository.deleteById(id)
    }
    
    fun updateTask(id: TaskId, description: String) {
        val task = taskRepository.findById(id) ?: throw IllegalArgumentException("Task not found")
        task.description = description
        taskRepository.update(task)
    }

    fun findAllTasks(): List<Task> {
        return taskRepository.findAll()
    }
}