import com.diffplug.gradle.spotless.SpotlessPlugin
import de.chojo.PublishData

plugins {
    java
    `maven-publish`
    `java-library`
    id("com.diffplug.spotless") version "6.22.0"
    id("de.chojo.publishdata") version "1.2.5"
    jacoco
}

group = "de.eldoria.jacksonbukkit"
version = "1.2.0"

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
        plugin<MavenPublishPlugin>()
        plugin<PublishData>()
        plugin<JacocoPlugin>()
    }

    repositories {
        mavenCentral()
        maven("https://eldonexus.de/repository/maven-public/")
        maven("https://eldonexus.de/repository/maven-proxies/")
    }

    dependencies {
        api("org.jetbrains", "annotations", "24.0.1")

        api(platform("com.fasterxml.jackson:jackson-bom:2.15.2"))
        api("com.fasterxml.jackson.core", "jackson-core")
        api("com.fasterxml.jackson.core:jackson-databind")

        // jackson testing
        testImplementation("com.fasterxml.jackson.core:jackson-databind")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")

        // junit and stuff
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
        testImplementation("org.mockito:mockito-core:5.5.0")
        testImplementation("org.assertj:assertj-core:3.24.2")
    }

    java {
        withJavadocJar()
        withJavadocJar()
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    spotless {
        java {
            licenseHeaderFile(rootProject.file("HEADER.txt"))
            target("**/*.java")
        }
    }

    jacoco {
        toolVersion = "0.8.10"
    }


    publishData {
        useEldoNexusRepos()
        publishComponent("java")
    }

    if (publicProjects.contains(project.name)) {

        publishing {
            publications.create<MavenPublication>("maven") {
                publishData.configurePublication(this)
                pom {
                    url.set("https://github.com/eldoriarpg/jackson-bukkit")
                    developers {
                        developer {
                            name.set("Florian Fülling")
                            url.set("https://github.com/rainbowdashlabs")
                            organization.set("EldoriaRPG")
                            organizationUrl.set("https://github.com/eldoriarpg")
                        }
                        developer {
                            name.set("Yannick Lamprecht")
                            url.set("https://github.com/yannicklamprecht")
                        }
                    }
                    licenses {
                        license {
                            name.set("MIT")
                            url.set("https://github.com/eldoriarpg/bukkit-jackson/blob/main/LICENSE.md")
                        }
                    }
                }
            }

            repositories {
                maven {
                    authentication {
                        credentials(PasswordCredentials::class) {
                            username = System.getenv("NEXUS_USERNAME")
                            password = System.getenv("NEXUS_PASSWORD")
                        }
                    }

                    setUrl(publishData.getRepository())
                    name = "EldoNexus"
                }
            }
        }
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

fun applyJavaDocOptions(options: MinimalJavadocOptions) {
    val javaDocOptions = options as StandardJavadocDocletOptions
    javaDocOptions.links(
        "https://javadoc.io/doc/com.google.code.findbugs/jsr305/latest/",
        "https://javadoc.io/doc/org.jetbrains/annotations/latest/",
        "https://docs.oracle.com/en/java/javase/${java.toolchain.languageVersion.get().asInt()}/docs/api/",
        "https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-core/latest/",
        "https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-annotations/latest",
        "https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest",
        "https://jd.papermc.io/paper/1.19/"
    )
}

tasks {
    register<Javadoc>("allJavadocs") {
        applyJavaDocOptions(options)

        destinationDir = file("${buildDir}/docs/javadoc")
        val projects = project.rootProject.allprojects.filter { p -> publicProjects.contains(p.name) }
        setSource(projects.map { p -> p.sourceSets.main.get().allJava })
        classpath = files(projects.map { p -> p.sourceSets.main.get().compileClasspath })
    }
}
