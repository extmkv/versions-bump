import nl.littlerobots.vcu.plugin.ExperimentalVersionCatalogUpdateTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(androidLib.plugins.gradle.versionsUpdate)
}

versionCatalogUpdate {
    sortByKey.set(false)
    versionCatalogs {
        getTOMLFiles().forEach {
            create("${it.nameWithoutExtension}Lib") {
                catalogFile.set(file("configs/libs/${it.name}"))
                sortByKey.set(false)

                keep {
                    keepUnusedPlugins.set(true)
                }
            }
        }
    }
}

tasks.register("versionCatalogUpdateAll") {
    dependsOn(tasks.withType(ExperimentalVersionCatalogUpdateTask::class.java)
        .filterNot { it.name == "versionCatalogUpdate" }.map {
            println(it.name)
            it
        })
}

fun getTOMLFiles() =
    File("${rootProject.projectDir}/configs/libs/").listFiles()?.filter { it.extension == "toml" }
        .orEmpty()

