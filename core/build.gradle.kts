dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.19.2-R0.1-SNAPSHOT")
    testImplementation(project(":bukkit"))
    testImplementation(project(":testing"))
    testImplementation("org.spigotmc", "spigot-api", "1.19.2-R0.1-SNAPSHOT")
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "2.146.1")

}
