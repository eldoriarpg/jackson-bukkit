description = "Module for serialization on Paper based servers"

dependencies {
    api(project(":core"))
    compileOnly(libs.paper.v120)
    testImplementation(libs.paper.v1194)
    testImplementation(testlibs.mockbukkit.v119)
    testImplementation(project(":testing"))
}
