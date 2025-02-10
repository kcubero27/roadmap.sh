package domain.entity

import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TaskIdTest {
    @Test
    fun `test task id creation`() {
        val taskId = TaskId()

        assertNotNull(taskId.value)
    }
}