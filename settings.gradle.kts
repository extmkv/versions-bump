pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        getTOMLFiles().forEach {
            create("${it.nameWithoutExtension}Lib") {
                from(files("configs/libs/${it.name}"))
            }
        }
    }
}

rootProject.name = "VersionsBump"
include(":app")


fun getTOMLFiles() =
    File("${rootProject.projectDir}/configs/libs/").listFiles()?.filter { it.extension == "toml" }
        .orEmpty()
