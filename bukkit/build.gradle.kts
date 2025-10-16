description = "Module for serialization on Spigot based servers"

dependencies {
    api(project(":core"))
    compileOnly(libs.spigot.v1132)

    testImplementation(project(":core"))
    testImplementation(libs.spigot.v1132)
}
