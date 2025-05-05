pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
plugins {
    id("com.highcapable.sweetdependency") version "{SWEETDEPENDENCY_VERSION}"
    id("com.highcapable.sweetproperty") version "{SWEETPROPERTY_VERSION}"
}
sweetProperty {
    rootProject { all { isEnable = false } }
}
rootProject.name = "YukiHookFingerprint"
include(":app")