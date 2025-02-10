package com.kcubero27.backend.taskTracker.domain.entity

import com.kcubero27.backend.taskTracker.infrastructure.serialization.LocalDateTimeSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.*

@Serializable
class Task(
    val id: TaskId = TaskId(),
    var description: String = "",
    var status: Status = Status.TODO,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Serializable(with = LocalDateTimeSerializer::class)
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    @Serializable
    enum class Status {
        TODO, IN_PROGRESS, DONE
    }
}