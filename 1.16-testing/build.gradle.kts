plugins {
    id("jacksonbukkit.java-conventions")
}

dependencies {
    implementation(libs.paper.v1165)
    implementation(project(":testing"))

    testImplementation(project(":core"))
    testImplementation(libs.mockbukkit.v119)
}
