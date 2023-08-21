description = "Module for serialization on Spigot based servers"

dependencies {
    api(project(":core"))
    compileOnly("org.spigotmc", "spigot-api", "1.13.2-R0.1-SNAPSHOT")

    testImplementation(project(":core"))
    testImplementation("org.spigotmc", "spigot-api", "1.13.2-R0.1-SNAPSHOT")
}
