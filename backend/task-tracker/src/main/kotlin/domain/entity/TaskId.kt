package com.kcubero27.backend.taskTracker.domain.entity

import com.kcubero27.backend.taskTracker.infrastructure.serialization.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class TaskId {
    @Serializable(with = UUIDSerializer::class)
    val value: UUID = UUID.randomUUID()
}