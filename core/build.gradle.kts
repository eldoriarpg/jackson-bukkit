description = "Core module containing shared logic"
dependencies {
    compileOnly(libs.spigot.v120)

    testImplementation(libs.paper.v1194)
    testImplementation(project(":bukkit"))
    testImplementation(project(":testing"))
    testImplementation(testlibs.mockbukkit.v119)
}
