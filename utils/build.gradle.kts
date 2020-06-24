import configs.SdkConfig
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


    // Kotlin.
    implementation(KotlinLibs.STDLIB)

    // AndroidX.
    implementation(AndroidX.CORE)
    implementation(AndroidX.CORE_UI)
    implementation(AndroidX.ANNOTATIONS)

    // Material Components.
    implementation(MaterialComponents.LIBRARY)

    // LifeCycle.
    implementation(LifeCycle.VIEW_MODEL_LIBRARY)
    kapt(LifeCycle.VIEW_MODEL_COMPILER)
    implementation(LifeCycle.LIFECYCLE_EXTENSIONS)

    // Navigation.
    implementation(Navigation.UI)
    implementation(Navigation.FRAGMENT)

    // Rx.
    implementation(Rx.RX_KOTLIN)
    implementation(Rx.RX_ANDROID)
    implementation(Rx.RX_RELAY)

    // Retrofit.
    implementation(Retrofit.LIBRARY)
    implementation(Retrofit.RX_ADAPTER)
    implementation(Retrofit.GSON_CONVERTER)

    // Utilities and tools.
    implementation(Tools.OKIO)
    implementation(Tools.GSON)
}