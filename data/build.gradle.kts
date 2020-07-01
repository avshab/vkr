plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion =  "29.0.2"
    defaultConfig {
        minSdkVersion(configs.SdkConfig.MIN_SDK_VERSION)
        targetSdkVersion(configs.SdkConfig.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", configs.AppConfig.API_ENDPOINT_NAME, configs.AppConfig.API_ENDPOINT)
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

    // Modules.
    implementation(project(":domain"))
    implementation(project(":utils"))

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
    implementation(Rx.RX_PREFERENCES)

    // Room.
    implementation(Room.RUNTIME)
    kapt(Room.COMPILER)
    implementation(Room.RX_EXTENSIONS)

    // Retrofit.
    implementation(Retrofit.LIBRARY)
    implementation(Retrofit.RX_ADAPTER)
    implementation(Retrofit.GSON_CONVERTER)
    implementation(Retrofit.SCALARS_CONVERTER)

    // Play Services.
    implementation(PlayServices.LOCATION)
}