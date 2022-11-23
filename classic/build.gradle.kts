plugins {
    kotlin("jvm")
    `java-library`
    id("nebula.maven-publish")
    id("nebula.source-jar")
    id("com.bybutter.sisyphus.project")
}

description = "JetBrains UI Kit for Compose Desktop"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(compose.desktop.common) {
        exclude("org.jetbrains.compose.material")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs += listOf(
        // "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
    )
}
