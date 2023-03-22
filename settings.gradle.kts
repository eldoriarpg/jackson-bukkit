rootProject.name = "jackson-bukkit"

pluginManagement{
    repositories{
        mavenLocal()
        gradlePluginPortal()
        maven("https://eldonexus.de/repository/maven-public/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}
include("bukkit")
include("core")
include("paper")
include("testing")
include("1.16-testing")
