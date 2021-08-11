import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

group = "com.siyun"
version = "1"

plugins {
    id("idea")
    kotlin("jvm") version "1.5.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}
repositories {
    mavenCentral()
    mavenLocal()

    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    maven {
        url = uri("https://repo.dmulloy2.net/repository/public/")
    }
    maven {
        name = "papermc-repo"
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.citizensnpcs.co/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://repo.codemc.org/repository/maven-public/")
    }
    maven { url = uri("https://jitpack.io") }

}
dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly ("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly (group = "com.comphenix.protocol", name = "ProtocolLib", version = "4.7.0-SNAPSHOT")
    compileOnly (group = "net.citizensnpcs", name = "citizens-main", version = "2.0.28-SNAPSHOT")

}
fun TaskContainer.createJar(name: String, configuration: ShadowJar.() -> Unit) {
    create<ShadowJar>(name) {
        archiveBaseName.set(project.name)
        archiveVersion.set("") // For bukkit plugin update
        from(sourceSets["main"].output)
        configurations = listOf(project.configurations.shadow.get().apply { isCanBeResolved = true })
        configuration()
    }
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("project_version" to project.version)
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "16"
    }
    createJar("outJar") {
        var dest = File("C:/Users/PC/OneDrive/Desktop/서버/plugins")
        doLast {
            copy {
                from(archiveFile)
                into(dest)
            }
        }
    }
}