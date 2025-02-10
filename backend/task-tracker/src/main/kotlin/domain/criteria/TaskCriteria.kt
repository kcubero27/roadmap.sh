package com.kcubero27.backend.taskTracker.domain.criteria

import com.kcubero27.backend.taskTracker.domain.entity.Task

interface TaskCriteria {
    fun matches(task: Task): Boolean
}

class TaskStatusCriteria(private val status: Task.Status) : TaskCriteria {
    override fun matches(task: Task): Boolean = task.status == status
}

class NotTaskStatusCriteria(private val status: Task.Status) : TaskCriteria {
    override fun matches(task: Task): Boolean = task.status != status
}

class CompositeCriteria(private val criterias: List<TaskCriteria>) : TaskCriteria {
    override fun matches(task: Task): Boolean = criterias.all { it.matches(task) }
}

class AnyCriteria(private val criterias: List<TaskCriteria>) : TaskCriteria {
    override fun matches(task: Task): Boolean = criterias.any { it.matches(task) }
}