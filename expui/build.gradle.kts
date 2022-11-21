plugins {
    kotlin("jvm")
    id("nebula.maven-publish")
    id("nebula.source-jar")
    id("com.bybutter.sisyphus.project")
    `java-library`
}

description = "JetBrains ExpUI Kit for Compose Desktop"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(compose.desktop.common) {
        exclude("org.jetbrains.compose.material")
    }
}

tasks.jar {
    manifest {
        attributes["Add-Exports"] = "java.desktop/com.apple.eawt java.desktop/com.apple.eawt.event"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += listOf(
        // "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
    )
}
