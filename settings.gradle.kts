rootProject.name = "jackson-bukkit"

include("bukkit")
include("core")
include("paper")
include("testing")
include("1.16-testing")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://eldonexus.de/repository/maven-public/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.6.0")
}


dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // plugins
            plugin("spotless", "com.diffplug.spotless").version("6.20.0")
            plugin("publishdata", "de.chojo.publishdata").version("1.2.5")

            version("indra", "3.1.3")
            plugin("indra-core", "net.kyori.indra").versionRef("indra")
            plugin("indra-publishing", "net.kyori.indra.publishing").versionRef("indra")
            plugin("indra-sonatype", "net.kyori.indra.publishing.sonatype").versionRef("indra")

            version("jackson", "2.17.2")
            library("jackson-core", "com.fasterxml.jackson.core", "jackson-core").versionRef("jackson")
            library("jackson-databind", "com.fasterxml.jackson.core", "jackson-databind").versionRef("jackson")
            bundle("jackson", listOf("jackson-core", "jackson-databind"))

        }

        create("testlibs") {
            version("jackson", "2.17.2")
            // jackson testing
            library("jackson-databind", "com.fasterxml.jackson.core", "jackson-databind").versionRef("jackson")
            library("jackson-dataformat-yaml", "com.fasterxml.jackson.dataformat", "jackson-dataformat-yaml").versionRef("jackson")
            library("jackson-dataformat-toml", "com.fasterxml.jackson.dataformat", "jackson-dataformat-toml").versionRef("jackson")
            bundle("jackson", listOf("jackson-databind", "jackson-dataformat-yaml", "jackson-dataformat-toml"))
            version("junit", "5.11.0")

            library("junit-jupiter-core", "org.junit.jupiter", "junit-jupiter").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
            library("junit-jupiter-api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit-params", "org.junit.jupiter", "junit-jupiter-params").versionRef("junit")

            library("mockito", "org.junit.jupiter", "junit-jupiter-params").version("5.2.0")
            library("assertj-core", "org.junit.jupiter", "junit-jupiter-params").version("3.24.2")

            bundle("unittests", listOf("junit-jupiter-core", "junit-jupiter-engine", "junit-jupiter-api", "junit-params", "mockito", "assertj-core"))
        }
    }
}
