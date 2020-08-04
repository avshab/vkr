import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import configs.SdkConfig
import configs.AppConfig

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
   // id("com.google.gms.google-services")
}

android {
    compileSdkVersion(29)
    buildToolsVersion =  "29.0.2"
    defaultConfig {
        applicationId = AppConfig.APP_PACKAGE_NAME
        minSdkVersion(SdkConfig.MIN_SDK_VERSION)
        targetSdkVersion(SdkConfig.TARGET_SDK_VERSION)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.pro")
        }
    }
}


kapt {
    correctErrorTypes = true
}

androidExtensions {
    isExperimental = true
}


dependencies {

    // Modules.
    implementation(project(":data"))
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
    implementation(AndroidX.CORE_UI)
    implementation(AndroidX.CORE_UTILS)
    implementation(AndroidX.FRAGMENT)
    implementation(AndroidX.APPCOMPAT)
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


    // RxBinding
    implementation(RxBinding.CORE)

    // Rx.
    implementation(Rx.RX_KOTLIN)
    implementation(Rx.RX_ANDROID)
    implementation(Rx.RX_RELAY)

    // Dagger2.
    implementation(Dagger2.LIBRARY)
    implementation(Dagger2.ANDROID_EXTENSIONS)
    implementation(Dagger2.SUPPORT_EXTENSTIONS)
    kapt(Dagger2.COMPILER)
    kapt(Dagger2.ANDROID_EXTENSIONS_COMPILER)
    implementation(Dagger2.ANNOTATIONS)

    // Retrofit.
    implementation(Retrofit.LIBRARY)
    implementation(Retrofit.RX_ADAPTER)
    implementation(Retrofit.GSON_CONVERTER)
    implementation(Retrofit.SCALARS_CONVERTER)

    // Google Play Services.
    implementation(PlayServices.GCM)
    implementation(PlayServices.AUTH)
    implementation(PlayServices.MAPS)
    implementation(PlayServices.LOCATION)

    // Firebase.
    implementation(Firebase.CORE)
    implementation(Firebase.CLOUD_MESSAGING)

    implementation(Tools.GSON)
    implementation(Tools.TIMBER)
    implementation(Tools.LOTTIE)
    implementation(Tools.AMPLITUDE)
    implementation(Tools.WORK_MANAGER)
    implementation(Tools.PAGE_INDICATOR)
    implementation(Tools.TEXT_INPUT_MASK)
    implementation(Tools.MATERIAL_DIALOGS)
    implementation(Tools.CONSTRAINT_LAYOUT)
    implementation(Tools.ADAPTER_DELEGATES)
    implementation(Tools.CHROME_CUSTOM_TABS)
    implementation(Tools.BINARY_PREFERENCES)
    implementation(Tools.OKHTTP_LOGGER) {
        exclude(group = "org.json", module = "json")
    }

    implementation(Glide.LIBRARY)
    implementation(Glide.COMPILER)
}