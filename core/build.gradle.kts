plugins {
    id("jacksonbukkit.publishing-conventions")
}

description = "Core module containing shared logic"

dependencies {
    compileOnly(libs.spigot.v1194)

    testImplementation(libs.paper.v1194)
    testImplementation(project(":bukkit"))
    testImplementation(project(":testing"))
    testImplementation(libs.mockbukkit.v119)
}
