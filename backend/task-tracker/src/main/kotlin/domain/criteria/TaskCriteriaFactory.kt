package com.kcubero27.backend.taskTracker.domain.criteria

import com.kcubero27.backend.taskTracker.domain.entity.Task

// TODO: verify this implementation
object TaskCriteriaFactory {
    fun done(): TaskCriteria = TaskStatusCriteria(Task.Status.DONE)
    
    fun notDone(): TaskCriteria = NotTaskStatusCriteria(Task.Status.DONE)
    
    fun inProgress(): TaskCriteria = TaskStatusCriteria(Task.Status.IN_PROGRESS)
    
    fun todo(): TaskCriteria = TaskStatusCriteria(Task.Status.TODO)
}