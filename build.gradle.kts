plugins {
    kotlin("jvm") version "1.7.20" apply false
    id("org.jetbrains.compose") version "1.2.1" apply false
    id("nebula.maven-publish") version "18.0.0" apply false
    id("nebula.source-jar") version "18.0.0" apply false
    id("nebula.info") version "11.0.1" apply false
    id("com.bybutter.sisyphus.project") version "1.5.31" apply false
    id("nebula.contacts") version "5.1.0"
    id("org.jetbrains.changelog") version "1.3.0"
}

allprojects {
    apply(plugin = "nebula.contacts")
    apply(plugin = "nebula.info")

    group = "com.bybutter.compose"
    version = "2.1.0"

    contacts {
        addPerson("higan@live.cn", delegateClosureOf<nebula.plugin.contacts.Contact> {
            moniker = "higan"
            github = "devkanro"
            roles.add("owner")
        })
    }
}

subprojects {
    apply(plugin = "org.jetbrains.compose")

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
        kotlinOptions.jvmTarget = "17"
    }

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

changelog {
    version.set(project.version.toString())
    groups.set(emptyList())
}