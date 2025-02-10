package com.kcubero27.backend.taskTracker.infrastructure.entrypoint.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument

class AddTaskCliCommand : CliktCommand(name = "add") {
    private val description by argument(help = "Create a new task with given description")

    override fun run() {
        println("Adding task: $description")
    }
}