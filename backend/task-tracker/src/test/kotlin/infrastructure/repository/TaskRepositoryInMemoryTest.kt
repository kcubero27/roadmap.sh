package infrastructure.repository

import com.kcubero27.backend.taskTracker.domain.entity.Task
import com.kcubero27.backend.taskTracker.domain.entity.TaskId
import com.kcubero27.backend.taskTracker.domain.repository.TaskRepository
import com.kcubero27.backend.taskTracker.infrastructure.repository.TaskRepositoryInMemory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TaskRepositoryInMemoryTest {

    private lateinit var taskRepository: TaskRepository

    @BeforeEach
    fun setUp() {
        taskRepository = TaskRepositoryInMemory()
    }

    @Nested
    inner class SaveTests {
        @Test
        fun `test save and find all`() {
            val task1 = Task(description = "Task 1")
            val task2 = Task(description = "Task 2")

            taskRepository.save(task1)
            taskRepository.save(task2)

            val tasks = taskRepository.findAll()
            assertEquals(2, tasks.size)
            assertTrue(tasks.contains(task1))
            assertTrue(tasks.contains(task2))
        }

        @Test
        fun `test save duplicate task`() {
            val task = Task(description = "Task description")
            taskRepository.save(task)
            taskRepository.save(task)

            val tasks = taskRepository.findAll()
            assertEquals(1, tasks.size)
        }
    }

    @Nested
    inner class FindByTests {
        @Test
        fun `test find by id`() {
            val task = Task(description = "Task description")
            taskRepository.save(task)

            val foundTask = taskRepository.findById(task.id)
            assertNotNull(foundTask)
            assertEquals(task.id, foundTask?.id)
        }

        @Test
        fun `test find by non-existent id`() {
            val nonExistentId = TaskId()
            val foundTask = taskRepository.findById(nonExistentId)
            assertNull(foundTask)
        }
    }

    @Nested
    inner class UpdateTests {
        @Test
        fun `test update`() {
            val task = Task(description = "Task description")
            taskRepository.save(task)

            val updatedTask = task.apply {
                description = "Updated description"
                status = Task.Status.IN_PROGRESS
            }
            taskRepository.update(updatedTask)

            val foundTask = taskRepository.findById(task.id)
            assertNotNull(foundTask)
            assertEquals("Updated description", foundTask?.description)
            assertEquals(Task.Status.IN_PROGRESS, foundTask?.status)
        }

        @Test
        fun `test update non-existent task`() {
            val task = Task(description = "Task description")
            taskRepository.update(task)

            val foundTask = taskRepository.findById(task.id)
            assertNull(foundTask)
        }
    }

    @Nested
    inner class DeleteByIdTests {
        @Test
        fun `test delete by id`() {
            val task = Task(description = "Task description")
            taskRepository.save(task)

            taskRepository.deleteById(task.id)
            val foundTask = taskRepository.findById(task.id)
            assertNull(foundTask)
        }

        @Test
        fun `test delete by non-existent id`() {
            val nonExistentId = TaskId()
            taskRepository.deleteById(nonExistentId)

            val tasks = taskRepository.findAll()
            assertTrue(tasks.isEmpty())
        }
    }
}