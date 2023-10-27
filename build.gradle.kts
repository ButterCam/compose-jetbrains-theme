plugins {
    id("com.bybutter.sisyphus.project") version "2.1.0" apply false
    id("com.netflix.nebula.contacts") version "7.0.1"
    id("com.netflix.nebula.info") version "12.1.6" apply false
    id("com.netflix.nebula.maven-publish") version "20.3.0" apply false
    id("com.netflix.nebula.source-jar") version "20.3.0" apply false
    id("org.jetbrains.changelog") version "1.3.0"
    id("org.jetbrains.compose") version "1.5.2" apply false
    kotlin("jvm") version "1.9.10" apply false
}

allprojects {
    apply(plugin = "com.netflix.nebula.contacts")
    apply(plugin = "com.netflix.nebula.info")

    group = "com.bybutter.compose"
    version = "2.2.0"

    contacts {
        addPerson(
            "higan@live.cn",
            delegateClosureOf<nebula.plugin.contacts.Contact> {
                moniker = "higan"
                github = "devkanro"
                roles.add("owner")
            },
        )
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
