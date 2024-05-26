repositories {
    maven("https://eldonexus.de/repository/codemc-nms/")
}

dependencies {
    testImplementation(project(":core"))
    implementation("com.destroystokyo.paper:paper-api:1.16.5-R0.1-20211218.081530-231")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testImplementation("org.assertj:assertj-core:3.26.0")
    implementation(project(":testing"))
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "2.29.0")
}
