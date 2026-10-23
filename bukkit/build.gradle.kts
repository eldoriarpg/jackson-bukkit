plugins {
    id("jacksonbukkit.publishing-conventions")
}

description = "Module for serialization on Spigot based servers"

dependencies {
    api(project(":core"))
    compileOnly(libs.spigot.v1132)

    testImplementation(libs.spigot.v1132)
}
