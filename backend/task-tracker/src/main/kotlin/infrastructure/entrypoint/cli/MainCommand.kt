package com.kcubero27.backend.taskTracker.infrastructure.entrypoint.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class MainCommand: CliktCommand() {
    init {
        subcommands(AddTaskCliCommand())
        subcommands(ListTasksCliCommand())
    }

    override fun run() {
        println("Task cli command")
    }
}