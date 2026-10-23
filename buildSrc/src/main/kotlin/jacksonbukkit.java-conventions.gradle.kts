plugins {
    `java-library`
    id("com.diffplug.spotless")
}

val libs = versionCatalogs.named("libs")

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://eldonexus.de/repository/maven-public/")
    maven("https://eldonexus.de/repository/maven-proxies/")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    api(libs.findLibrary("annotations").get())
    api(platform(libs.findLibrary("jackson-bom").get()))
    api(libs.findBundle("jackson").get())

    testImplementation(platform(libs.findLibrary("junit-bom").get()))
    testImplementation(libs.findBundle("unittests").get())
    testImplementation(libs.findBundle("jackson-formats").get())
    testRuntimeOnly(libs.findLibrary("junit-launcher").get())
}

tasks {
    withType<JavaCompile>().configureEach {
        options.release = 21
        options.encoding = "UTF-8"
    }

    withType<Javadoc>().configureEach {
        (options as StandardJavadocDocletOptions).links(
            "https://docs.oracle.com/en/java/javase/21/docs/api/",
            "https://javadoc.io/doc/org.jetbrains/annotations/latest/",
            "https://jd.papermc.io/paper/1.21.1",
        )
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

spotless {
    java {
        target("src/**/*.java")
        licenseHeaderFile(rootProject.file("HEADER.txt"))
        palantirJavaFormat(libs.findVersion("palantir").get().requiredVersion).formatJavadoc(false)
        removeUnusedImports()
        importOrder("", "java", "javax", "\\#")
        trimTrailingWhitespace()
        endWithNewline()
        encoding("UTF-8")
    }
}
