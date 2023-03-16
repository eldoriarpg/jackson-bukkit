plugins {
    java
    `maven-publish`
    `java-library`
    id("com.diffplug.spotless") version "6.16.0"
    id("de.chojo.publishdata") version "1.2.4"
    id("io.papermc.paperweight.userdev") version "1.5.3"
}

group = "de.eldoria"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://eldonexus.de/repository/maven-public/")
    maven("https://eldonexus.de/repository/maven-proxies/")
}

dependencies {

    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.14.2"))

    api("com.fasterxml.jackson.core", "jackson-core")

    // minecraft testing
    testImplementation("com.github.seeseemelk", "MockBukkit-v1.19", "2.29.0")

    // jackson testing
    implementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")

    // junit and stuff
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.skyscreamer:jsonassert:1.5.1")
}

spotless {
    java {
        licenseHeaderFile(rootProject.file("HEADER.txt"))
        target("**/*.java")
    }
}

java {
    withJavadocJar()
    withJavadocJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    compileTestJava {
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
