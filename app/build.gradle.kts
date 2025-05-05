plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}
repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
}
android {
    namespace = "fpbymutz" // Ganti sesuai package kamu
    compileSdk = 34 // Ganti sesuai kebutuhan

    defaultConfig {
        applicationId = "fpbymutz" // Ganti sesuai package kamu
        minSdk = 25 // Ganti sesuai kebutuhan
        targetSdk = 34 // Ganti sesuai kebutuhan
        versionName = "1.0.0" // Ganti sesuai kebutuhan
        versionCode = 1 // Ganti sesuai kebutuhan
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf(
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    lint { checkReleaseBuilds = false }
    // androidResources.additionalParameters += listOf("--allow-reserved-package-id", "--package-id", "0x64")
}

dependencies {
    // Untuk Xposed API (manual JAR di libs/)
    compileOnly(files("libs/api-82.jar")) 

    // Untuk YukiHookAPI dari JitPack
    implementation("com.github.highcapable.YukiHookAPI:YukiHookAPI:1.1.7")
ksp("com.github.highcapable.YukiHookAPI:ksp-xposed:1.1.8")
    implementation("com.github.duanhong169:drawabletoolbox:1.0.2") // Ganti versi sesuai kebutuhan
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}