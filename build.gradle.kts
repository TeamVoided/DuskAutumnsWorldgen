import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//buildscript {
////    repositories {
////        flatDir {
////            dirs("./libs") // <-- folder with jars
////        }
////    }
////    dependencies {
////        classpath("org.teamvoided.iridium:iridium:3.1.9")
////    }
//    dependencies {
//        classpath(files("libs/iridium-3.1.9.jar"))
//    }
//    apply<org.teamvoided.iridium.IridiumPlugin>()
//}

plugins {
    id("fabric-loom") version "1.5.6"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
    id("org.teamvoided.iridium") version "3.1.9"
//    id("org.teamvoided.iridium")

}

group = project.properties["maven_group"]!!
version = project.properties["mod_version"]!!
base.archivesName.set(project.properties["archives_base_name"] as String)
description = "Worldgen Whatever"
val modid: String by project

repositories {
    mavenCentral()
}

modSettings {
    modId(modid)
    modName("Dusk Autumns Worldgen")

    entrypoint("main", "org.teamvoided.dusk_autumns_worldgen.DuskAutumnsWorldgen::commonInit")
    entrypoint("client", "org.teamvoided.dusk_autumns_worldgen.DuskAutumnsWorldgen::clientInit")
    entrypoint("fabric-datagen", "org.teamvoided.dusk_autumns_worldgen.DuskAutumnsWorldgenData")
    mixinFile("dusk_autumns_worldgen.mixins.json")
//    accessWidener("dusk_autumns_worldgen.accesswidener")
}

//val player_data: String by project
dependencies {
//    modImplementation(include("eu.pb4", "player-data-api", player_data))
}

loom {
    runs {
        create("DataGen") {
            client()
            ideConfigGenerated(true)
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.modid=${modid}")
            runDir("build/datagen")
        }

        create("TestWorld") {
            client()
            ideConfigGenerated(true)
            runDir("run")
            programArg("--quickPlaySingleplayer \"test\"")
        }
    }
}

sourceSets["main"].resources.srcDir("src/main/generated")

tasks {
    val targetJavaVersion = 17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = targetJavaVersion.toString()
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}