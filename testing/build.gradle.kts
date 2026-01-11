dependencies {
    implementation("io.papermc.paper", "paper-api", "1.19.4-R0.1-SNAPSHOT")
    implementation("tools.jackson.dataformat:jackson-dataformat-yaml")
    implementation("tools.jackson.dataformat:jackson-dataformat-toml")
    implementation(libs.bundles.jackson)
    implementation(testlibs.bundles.unittests)
    testImplementation(testlibs.bundles.unittests)
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
