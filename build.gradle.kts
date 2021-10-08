plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build396"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0" apply false
    id("org.jetbrains.changelog") version "1.2.0"
    id("nebula.maven-publish") version "17.0.0"
    id("nebula.contacts") version "5.1.0"
    id("nebula.info") version "11.0.1"
    id("com.bybutter.sisyphus.project") version "1.3.10"
    java
}

group = "com.bybutter.compose"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(compose.desktop.common) {
        exclude("org.jetbrains.compose.material")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
    kotlinOptions.freeCompilerArgs += listOf(
        "-P",
        "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
    )
}

changelog {
    version.set(project.version.toString())
    groups.set(emptyList())
}

contacts {
    addPerson("higan@live.cn", delegateClosureOf<nebula.plugin.contacts.Contact> {
        moniker = "higan"
        github = "devkanro"
        roles.add("owner")
    })
}
