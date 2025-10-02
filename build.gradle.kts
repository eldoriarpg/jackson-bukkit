import com.diffplug.gradle.spotless.SpotlessPlugin
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SonatypeHost
import de.chojo.PublishData

plugins {
    id("io.freefair.aggregate-javadoc") version ("9.0.0")
    java
    `maven-publish`
    `java-library`
    alias(libs.plugins.spotless)
    alias(libs.plugins.publishdata)
    jacoco
    id("com.vanniktech.maven.publish") version "0.30.0"
}
publishData {
    useEldoNexusRepos(false)
    publishingVersion = "1.3.0"
}
version = publishData.getVersion()

description = "Module for serialization on Spigot and Paper based servers"
group = "de.eldoria.jacksonbukkit"

val publicProjects = setOf("core", "bukkit", "paper", "jackson-bukkit")

dependencies {
    api(project(":paper"))
    api(project(":bukkit"))
}

allprojects {
    apply {
        plugin<JavaLibraryPlugin>()
        plugin<SpotlessPlugin>()
        plugin<JavaPlugin>()
        plugin<PublishData>()
        plugin<JacocoPlugin>()
    }

    repositories {
        mavenCentral()
        maven("https://eldonexus.de/repository/maven-public/")
        maven("https://eldonexus.de/repository/maven-proxies/")
    }

    dependencies {
        api("org.jetbrains", "annotations", "26.0.2-1")

        api(platform("com.fasterxml.jackson:jackson-bom:2.20.0"))
        api("com.fasterxml.jackson.core", "jackson-core")
        api("com.fasterxml.jackson.core:jackson-databind")

        // jackson testing
        testImplementation("com.fasterxml.jackson.core:jackson-databind")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")

        // junit and stuff
        testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.0")
        testImplementation("org.mockito:mockito-core:5.20.0")
        testImplementation("org.assertj:assertj-core:3.27.6")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    spotless {
        java {
            licenseHeaderFile(rootProject.file("HEADER.txt"))
            target("**/*.java")
        }
    }

    jacoco {
        toolVersion = "0.8.13"
    }

    tasks {
        compileJava {
            options.encoding = "UTF-8"
        }

        compileTestJava {
            options.encoding = "UTF-8"
        }

        test {
            finalizedBy(jacocoTestReport)
            useJUnitPlatform()
            testLogging {
                events("passed", "skipped", "failed")
            }
        }

        jacocoTestReport {
            dependsOn(test)
        }

        jacocoTestReport {
            reports {
                xml.required.set(false)
                csv.required.set(true)
                html.required.set(false)
            }
        }

        jacocoTestCoverageVerification {
            violationRules {
                rule {
                    limit {
                        minimum = "0.8".toBigDecimal()
                    }
                }

                rule {
                    isEnabled = false
                    element = "CLASS"
                    includes = listOf("org.gradle.*")

                    limit {
                        counter = "LINE"
                        value = "TOTALCOUNT"
                        maximum = "0.8".toBigDecimal()
                    }
                }
            }
        }
    }
}


subprojects {
    apply {
        // We want to apply several plugins to subprojects
        plugin<JavaPlugin>()
        plugin<SpotlessPlugin>()
        plugin<PublishData>()
        plugin<JavaLibraryPlugin>()
    }
    if (project.name in publicProjects) {
        apply {
            plugin<MavenPublishPlugin>()
            plugin<SigningPlugin>()
        }

    }
    afterEvaluate {
        apply {
            plugin<com.vanniktech.maven.publish.MavenPublishPlugin>()
        }

        mavenPublishing {
            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()

            coordinates(
                groupId = "de.eldoria.jacksonbukkit",
                artifactId = project.name,
                version = publishData.getVersion()
            )

            pom {
                name.set("jackson-bukkit")
                description.set(project.description)
                inceptionYear.set("2025")
                url.set("https://github.com/eldoriarpg/jackson-bukkit")
                licenses {
                    license {
                        name.set("LGPL-3.0")
                        url.set("https://opensource.org/license/lgpl-3-0")
                    }
                }

                developers {
                    developer {
                        id.set("rainbowdashlabs")
                        name.set("Nora Fülling")
                        email.set("mail@chojo.dev")
                        url.set("https://github.com/rainbowdashlabs")
                    }
                    developer {
                        id.set("yannicklamprecht")
                        name.set("Yannick Lamprecht")
                        url.set("https://github.com/yannicklamprecht")
                    }
                }

                scm {
                    url.set("https://github.com/eldoriarpg/jackson-bukkit")
                    connection.set("scm:git:git://github.com/eldoriarpg/jackson-bukkit.git")
                    developerConnection.set("scm:git:ssh://github.com/eldoriarpg/jackson-bukkit.git")
                }
            }

            configure(
                JavaLibrary(
                    javadocJar = JavadocJar.Javadoc(),
                    sourcesJar = true
                )
            )
        }

    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()


    coordinates(groupId = "de.eldoria.jacksonbukkit", artifactId = project.name, version = publishData.getVersion())

    pom {
        name.set("jackson-bukkit")
        description.set(project.description)
        inceptionYear.set("2025")
        url.set("https://github.com/eldoriarpg/jackson-bukkit")
        licenses {
            license {
                name.set("LGPL-3.0")
                url.set("https://opensource.org/license/lgpl-3-0")
            }
        }

        developers {
            developer {
                id.set("rainbowdashlabs")
                name.set("Nora Fülling")
                email.set("mail@chojo.dev")
                url.set("https://github.com/rainbowdashlabs")
            }
            developer {
                id.set("yannicklamprecht")
                name.set("Yannick Lamprecht")
                url.set("https://github.com/yannicklamprecht")
            }
        }

        scm {
            url.set("https://github.com/eldoriarpg/jackson-bukkit")
            connection.set("scm:git:git://github.com/eldoriarpg/jackson-bukkit.git")
            developerConnection.set("scm:git:ssh://github.com/eldoriarpg/jackson-bukkit.git")
        }
    }

    configure(
        JavaLibrary(
            javadocJar = JavadocJar.Javadoc(),
            sourcesJar = true
        )
    )
}

fun applyJavaDocOptions(options: MinimalJavadocOptions) {
    val javaDocOptions = options as StandardJavadocDocletOptions
    javaDocOptions.links(
        "https://javadoc.io/doc/org.jetbrains/annotations/latest/",
        "https://docs.oracle.com/en/java/javase/${java.toolchain.languageVersion.get().asInt()}/docs/api/"
    )
}

tasks.javadoc.configure {
    applyJavaDocOptions(options)
}
