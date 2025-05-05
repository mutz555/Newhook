pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Tambahkan baris ini!
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Newhook"
include(":app")