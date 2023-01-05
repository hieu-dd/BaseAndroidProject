pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("./libs.versions.toml"))
        }
    }
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = "Note"
include(":app")
include(":core")

enableFeaturePreview("VERSION_CATALOGS")