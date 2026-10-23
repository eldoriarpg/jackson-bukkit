plugins {
    alias(libs.plugins.aggregate.javadoc)
    id("jacksonbukkit.publishing-conventions")
}

description = "Module for serialization on Spigot and Paper based servers"

dependencies {
    api(project(":paper"))
    api(project(":bukkit"))

    javadoc(project(":core"))
    javadoc(project(":paper"))
    javadoc(project(":bukkit"))

    javadocClasspath(libs.paper.v120)
}
