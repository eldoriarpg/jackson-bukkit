

dependencies {
    testImplementation(project(":core"))
    implementation("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    testImplementation(libs.bundles.jackson)
    testImplementation(testlibs.bundles.unittests)
    implementation(project(":testing"))
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "3.1.0")
}
