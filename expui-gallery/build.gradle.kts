plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(project(":compose-jetbrains-expui-theme"))
    implementation(compose.desktop.linux_x64) {
        exclude("org.jetbrains.compose.material")
    }
    implementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            packageName = "JetBrains ExpUI Gallery"
            packageVersion = project.version.toString()
            copyright = "Beijing Muke Technology Co., Ltd."
            modules("jdk.unsupported", "jdk.accessibility")

            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.AppImage,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi
            )
        }
    }
}
