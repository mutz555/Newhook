plugins {
    autowire(libs.plugins.android.application) apply false
    autowire(libs.plugins.kotlin.android) apply false
    autowire(libs.plugins.kotlin.ksp) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.highcapable.sweetdependency:sweetdependency:1.5.2")
        classpath("com.highcapable.sweetproperty:sweetproperty:1.5.0")
    }
}