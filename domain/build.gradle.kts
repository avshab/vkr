import configs.SdkConfig

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion =  "29.0.2"
    defaultConfig {

        minSdkVersion(SdkConfig.MIN_SDK_VERSION)
        targetSdkVersion(SdkConfig.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0"
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {

    // "libs" directory.
    implementation(
        fileTree(
            mapOf("dir" to "libs", "include" to listOf("*.jar"))
        )
    )

    // AndroidX.
    implementation(AndroidX.CORE)

    // Kotlin.
    implementation(KotlinLibs.STDLIB)

    // Rx.
    implementation(Rx.RX_KOTLIN)
    implementation(Rx.RX_ANDROID)
    implementation(Rx.RX_RELAY)

    // Utilities and tools.
    implementation(Tools.TIMBER)

}