package com.kcubero27.backend.taskTracker.infrastructure.repository

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.repository.TaskRepository
import com.kcubero27.backend.taskTracker.infrastructure.serialization.LocalDateTimeSerializer
import com.kcubero27.backend.taskTracker.infrastructure.serialization.UUIDSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime
import java.util.UUID

class TaskRepositoryFile() : TaskRepository {
    private val file = File("src/main/resources/tasks.json")

    private val json = Json {
        serializersModule = SerializersModule {
            contextual(LocalDateTime::class, LocalDateTimeSerializer)
            contextual(UUID::class, UUIDSerializer)
        }
    }

    override fun save(task: Task) {
        val tasks = findAll().toMutableList()
        tasks.add(task)
        saveTasks(tasks)
    }

    override fun findAll(): List<Task> {
        if (!file.exists()) return emptyList()
        val jsonContent = file.readText()
        return json.decodeFromString(jsonContent)
    }

    override fun findById(id: TaskId): Task? {
        return findAll().find { it.id == id }
    }

    override fun deleteById(id: TaskId) {
        val tasks = findAll().toMutableList()
        val taskToRemove = tasks.find { it.id == id }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove)
            saveTasks(tasks)
        }
    }

    override fun update(task: Task) {
        val tasks = findAll().toMutableList()
        val index = tasks.indexOfFirst { it.id == task.id }
        if (index != -1) {
            tasks[index] = task
            saveTasks(tasks)
        }
    }

    private fun saveTasks(tasks: List<Task>) {
        val jsonContent = json.encodeToString(tasks)
        file.writeText(jsonContent)
    }
}