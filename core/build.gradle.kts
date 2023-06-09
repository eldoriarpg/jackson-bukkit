dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.20-R0.1-SNAPSHOT")
    testImplementation("org.spigotmc", "spigot-api", "1.20-R0.1-SNAPSHOT")
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "2.29.0")
    testImplementation(project(":bukkit"))
    testImplementation(project(":testing"))

}
