pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
plugins {
    id("com.highcapable.sweetdependency") version "1.5.2" // contoh versi sweetdependency terbaru
    id("com.highcapable.sweetproperty") version "1.5.0"
}
sweetProperty {
    rootProject { all { isEnable = false } }
}
rootProject.name = "YukiHookFingerprint"
include(":app")