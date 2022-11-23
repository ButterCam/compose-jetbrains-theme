pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include("classic")
include("expui")
include("expui-gallery")

project(":classic").name = "compose-jetbrains-theme"
project(":expui").name = "compose-jetbrains-expui-theme"
project(":expui-gallery").name = "compose-jetbrains-expui-gallery"

