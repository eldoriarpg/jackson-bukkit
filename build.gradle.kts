import com.diffplug.gradle.spotless.SpotlessPlugin
import de.chojo.PublishData
import net.kyori.indra.IndraExtension
import net.kyori.indra.IndraPlugin
import net.kyori.indra.IndraPublishingPlugin

plugins {
    java
    `maven-publish`
    `java-library`
    alias(libs.plugins.spotless)
    alias(libs.plugins.publishdata)
    alias(libs.plugins.indra.core)
    alias(libs.plugins.indra.publishing)
    alias(libs.plugins.indra.sonatype)
    jacoco
}
publishData {
    useEldoNexusRepos(false)
    publishingVersion = "1.2.0"
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
        api("org.jetbrains", "annotations", "24.0.1")

        api(platform("com.fasterxml.jackson:jackson-bom:2.15.2"))
        api("com.fasterxml.jackson.core", "jackson-core")
        api("com.fasterxml.jackson.core:jackson-databind")

        // jackson testing
        testImplementation("com.fasterxml.jackson.core:jackson-databind")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
        testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-toml")

        // junit and stuff
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
        testImplementation("org.mockito:mockito-core:5.3.1")
        testImplementation("org.assertj:assertj-core:3.24.2")
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

fun configureIndra(extension: IndraExtension) {
    extension.javaVersions {
        target(17)
        testWith(17)
    }

    extension.github("eldoriarpg", "jackson-bukkit") {
        ci(true)
    }

    extension.mitLicense()

    extension.signWithKeyFromPrefixedProperties("rainbowdashlabs")

    extension.configurePublications {
        pom {
            developers {
                developer {
                    id.set("rainbowdashlabs")
                    name.set("Florian Fülling")
                    email.set("mail@chojo.dev")
                    url.set("https://github.com/rainbowdashlabs")
                }
                developer {
                    id.set("yannicklamprecht")
                    name.set("Yannick Lamprecht")
                    url.set("https://github.com/yannicklamprecht")
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
            plugin<IndraPlugin>()
            plugin<IndraPublishingPlugin>()
            plugin<SigningPlugin>()
        }

        indra {
            configureIndra(this)
        }
    }
}

indra {
    configureIndra(this)
}

indraSonatype {
    useAlternateSonatypeOSSHost("s01")
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
