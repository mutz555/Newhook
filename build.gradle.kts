// Tidak perlu blok plugins di root, langsung buildscript saja jika hanya butuh classpath

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.highcapable.sweetdependency:sweetdependency:1.5.2")
        classpath("com.highcapable.sweetproperty:sweetproperty:1.5.0")
        // Tambahkan classpath lain jika perlu, misal Android Gradle Plugin, Kotlin Gradle Plugin, dsb.
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    }
}