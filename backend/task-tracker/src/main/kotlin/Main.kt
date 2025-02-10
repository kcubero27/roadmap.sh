package com.kcubero27.backend.taskTracker

import com.github.ajalt.clikt.core.main
import com.kcubero27.backend.taskTracker.infrastructure.entrypoint.cli.MainCommand

fun main(args: Array<String>) = MainCommand().main(args)