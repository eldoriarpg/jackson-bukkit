import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    id("jacksonbukkit.java-conventions")
    id("com.vanniktech.maven.publish")
    id("de.chojo.publishdata")
}

publishData {
    eldoNexus(dev = false)
    channels {
        clear()
        release("https://eldonexus.de/repository/maven-releases/") { publishToMavenCentral() }
        snapshot("https://eldonexus.de/repository/maven-snapshots/")
    }
}

mavenPublishing {
    configure(JavaLibrary(javadocJar = JavadocJar.Javadoc(), sourcesJar = SourcesJar.Sources()))
    publishToMavenCentral()
    signAllPublications()
    coordinates(rootProject.group.toString(), project.name, project.version.toString())
    pom {
        name = if (project == rootProject) "jackson-bukkit" else "jackson-bukkit ${project.name}"
        description = provider { project.description }
        url = "https://github.com/eldoriarpg/jackson-bukkit"
        inceptionYear = "2023"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/license/mit"
            }
        }
        developers {
            developer {
                id = "rainbowdashlabs"
                name = "Nora Fülling"
                email = "mail@chojo.dev"
                url = "https://github.com/rainbowdashlabs"
            }
            developer {
                id = "yannicklamprecht"
                name = "Yannick Lamprecht"
                url = "https://github.com/yannicklamprecht"
            }
        }
        scm {
            url = "https://github.com/eldoriarpg/jackson-bukkit"
            connection = "scm:git:git://github.com/eldoriarpg/jackson-bukkit.git"
            developerConnection = "scm:git:ssh://github.com/eldoriarpg/jackson-bukkit.git"
        }
    }
}
