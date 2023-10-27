plugins {
    kotlin("jvm")
    `java-library`
    id("com.netflix.nebula.maven-publish")
    id("com.netflix.nebula.source-jar")
    id("com.bybutter.sisyphus.project")
    id("org.jetbrains.compose")
}

description = "JetBrains UI Kit for Compose Desktop"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(compose.desktop.common) {
        exclude("org.jetbrains.compose.material")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "17"
    kotlinOptions.freeCompilerArgs += listOf(
        // "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
    )
}
