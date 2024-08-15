dependencies {
    implementation("io.papermc.paper", "paper-api", "1.19.4-R0.1-SNAPSHOT")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")
    implementation("org.junit.jupiter:junit-jupiter-api:5.11.0")
    implementation("org.assertj:assertj-core:3.26.3")
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
