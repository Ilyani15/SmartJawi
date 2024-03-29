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
        jcenter()
        maven (url = "https://jcenter.bintray.com")
        maven (url = "https://jitpack.io")
    }
}

rootProject.name = "Smart Jawi"
include(":app")
 