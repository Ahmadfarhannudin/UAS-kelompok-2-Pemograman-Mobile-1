pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // 👇 GUNAKAN BARIS INI UNTUK KOTLIN DSL (.kts)
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "IspManagementApp"
include(":app")
