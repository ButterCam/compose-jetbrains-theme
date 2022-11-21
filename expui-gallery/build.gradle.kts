plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(project(":compose-jetbrains-expui-theme"))
    implementation(compose.desktop.currentOs) {
        // exclude("org.jetbrains.compose.material")
    }
    implementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            packageName = "Mediator"
            packageVersion = project.version.toString()
            copyright = "Beijing Muke Technology Co., Ltd."

            macOS {
                // jvmArgs("--add-exports", "java.desktop/com.apple.eawt=ALL-UNNAMED")
            }
        }
    }
}
