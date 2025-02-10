plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.0"
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "23"
    }
}

group = "com.kcubero27.backend.taskTracker"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.github.ajalt.clikt:clikt:5.0.3")

    // optional support for rendering markdown in help messages
    implementation("com.github.ajalt.clikt:clikt-markdown:5.0.3")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
}

application {
    mainClass.set("com.kcubero27.backend.taskTracker.MainKt")
}

tasks.test {
    useJUnitPlatform()
}