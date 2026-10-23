plugins {
    id("jacksonbukkit.java-conventions")
}

dependencies {
    implementation(libs.paper.v1194)
    implementation(libs.bundles.jackson.formats)
    implementation(platform(libs.junit.bom))
    implementation(libs.bundles.unittests)
}
