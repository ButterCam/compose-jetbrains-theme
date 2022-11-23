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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
