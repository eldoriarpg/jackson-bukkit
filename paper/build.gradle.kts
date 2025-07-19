description = "Module for serialization on Paper based servers"

dependencies {
    api(project(":core"))
    compileOnly("io.papermc.paper", "paper-api", "1.20-R0.1-SNAPSHOT")
    testImplementation("io.papermc.paper", "paper-api", "1.19.4-R0.1-SNAPSHOT")
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "3.1.0")
    testImplementation(project(":testing"))
}
