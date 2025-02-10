package domain.entity

import com.kcubero27.backend.taskTracker.domain.entity.Task
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TaskTest {

    @Test
    fun `test task creation`() {
        val task = Task(description = "Task description")

        assertEquals("Task description", task.description)
        assertEquals(Task.Status.TODO, task.status)
        assertNotNull(task.id)
        assertNotNull(task.createdAt)
        assertNotNull(task.updatedAt)

        val now = LocalDateTime.now()
        assertTrue(task.createdAt.isBefore(now) || task.createdAt.isEqual(now))
        assertTrue(task.updatedAt.isBefore(now) || task.updatedAt.isEqual(now))
    }

    @Test
    fun `test task status update`() {
        val task = Task(description = "Task description")
        task.status = Task.Status.IN_PROGRESS

        assertEquals(Task.Status.IN_PROGRESS, task.status)
    }

    @Test
    fun `test task description update`() {
        val task = Task(description = "Task description")
        task.description = "Updated description"

        assertEquals("Updated description", task.description)
    }

    @Test
    fun `test task updatedAt update`() {
        val task = Task(description = "Task description")
        val newUpdatedAt = LocalDateTime.now().plusDays(1)
        task.updatedAt = newUpdatedAt

        assertEquals(newUpdatedAt, task.updatedAt)
    }
}