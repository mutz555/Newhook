plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "scope" // Ganti sesuai package kamu
    compileSdk = 34 // Ganti sesuai kebutuhan

    defaultConfig {
        applicationId = "scope.hook" // Ganti sesuai package kamu
        minSdk = 25
        targetSdk = 34
        versionName = "1.0.0"
        versionCode = 1
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    // Tambahan biar sourceSet-nya bisa ngeload kode hasil generate KSP
    sourceSets {
    named("main") {
        java.srcDir("build/generated/ksp/main/kotlin")
    }
}
}
dependencies {
    implementation("com.highcapable.yukihookapi:api:1.2.1")
    implementation("com.highcapable.yukihookapi:core:1.2.1")
    ksp("com.highcapable.yukihookapi:ksp-xposed:1.2.1")
    
    compileOnly(files("libs/api-82.jar"))

    // lainnya tetap

implementation("com.github.duanhong169:drawabletoolbox:1.0.2")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}