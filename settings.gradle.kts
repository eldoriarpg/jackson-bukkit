rootProject.name = "jackson-bukkit"

include("bukkit")
include("core")
include("paper")
include("testing")
include("1.16-testing")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://eldonexus.de/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
