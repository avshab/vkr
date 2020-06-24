/**
 * Created by Anna Shabaeva on 01.06.2020
 */


object KotlinLibs {
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_PLUGIN}"
}

object AndroidX {
    private const val VERSION = "1.0.0"
    private const val CORE_VERSION = "1.0.1"
    private const val APPCOMPAT_VERSION = "1.0.2"
    private const val ANNOTATIONS_VERSION = "1.0.1"

    const val CORE = "androidx.core:core-ktx:$CORE_VERSION"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:$VERSION"
    const val CORE_UI = "androidx.legacy:legacy-support-core-ui:$VERSION"
    const val APPCOMPAT = "androidx.appcompat:appcompat:$APPCOMPAT_VERSION"
    const val CORE_UTILS = "androidx.legacy:legacy-support-core-utils:$VERSION"
    const val ANNOTATIONS = "androidx.annotation:annotation:$ANNOTATIONS_VERSION"
}

object MaterialComponents {
    const val LIBRARY = "com.google.android.material:material:1.1.0-rc01"
}

object Dagger2 {
    private const val VERSION = "2.21"

    const val ANNOTATIONS = "javax.annotation:jsr250-api:1.0"

    const val LIBRARY = "com.google.dagger:dagger:$VERSION"
    const val COMPILER = "com.google.dagger:dagger-compiler:$VERSION"
    const val ANDROID_EXTENSIONS = "com.google.dagger:dagger-android:$VERSION"
    const val SUPPORT_EXTENSTIONS = "com.google.dagger:dagger-android-support:$VERSION"
    const val ANDROID_EXTENSIONS_COMPILER = "com.google.dagger:dagger-android-processor:$VERSION"
}

object Retrofit {
    private const val VERSION = "2.5.0"

    const val LIBRARY = "com.squareup.retrofit2:retrofit:$VERSION"
    const val RX_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:$VERSION"
    const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:$VERSION"
    const val SCALARS_CONVERTER = "com.squareup.retrofit2:converter-scalars:$VERSION"
}

object Room {
    private const val VERSION = "2.0.0"

    const val RUNTIME = "androidx.room:room-runtime:$VERSION"
    const val COMPILER = "androidx.room:room-compiler:$VERSION"
    const val RX_EXTENSIONS = "androidx.room:room-rxjava2:$VERSION"
   // const val SAFE_EXTENSIONS = "com.commonsware.cwac:saferoom.x:1.0.2"
}

object LifeCycle {
    private const val VERSION = "2.0.0"

    const val VIEW_MODEL_LIBRARY = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
    const val VIEW_MODEL_COMPILER = "androidx.lifecycle:lifecycle-compiler:$VERSION"
    const val LIFECYCLE_EXTENSIONS = "android.arch.lifecycle:extensions:$VERSION"
}

object Glide {
    private const val VERSION = "4.8.0"

    const val LIBRARY = "com.github.bumptech.glide:glide:$VERSION"
    const val COMPILER = "com.github.bumptech.glide:compiler:$VERSION"
}

/**
 * Jetpack Navigation.
 */
object Navigation {
    private const val NAVIGATION_VERSION = "2.1.0"

    const val UI = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
    const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
}

object PlayServices {
    const val GCM = "com.google.android.gms:play-services-gcm:17.0.0"
    const val AUTH = "com.google.android.gms:play-services-auth:17.0.0"
    const val MAPS = "com.google.android.gms:play-services-maps:16.1.0"
    const val LOCATION = "com.google.android.gms:play-services-location:16.0.0"
}

object Firebase {
    const val CORE = "com.google.firebase:firebase-core:16.0.6"
    const val CRASHLYTICS = "com.crashlytics.sdk.android:crashlytics:2.9.8"
    const val CLOUD_MESSAGING = "com.google.firebase:firebase-messaging:17.3.4"
}

object Rx {
    const val RX_JAVA = "io.reactivex.rxjava2:rxjava:2.2.6"
    const val RX_KOTLIN = "io.reactivex.rxjava2:rxkotlin:2.3.0"
    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:2.1.0"
    const val RX_RELAY = "com.jakewharton.rxrelay2:rxrelay:2.1.0"
    const val RX_PREFERENCES = "com.f2prateek.rx.preferences2:rx-preferences:2.0.0"
}

object RxBinding {
    private const val VERSION = "3.0.0-alpha2"

    const val CORE = "com.jakewharton.rxbinding3:rxbinding-core:$VERSION"
    const val DESIGN = "com.jakewharton.rxbinding3:rxbinding-material:$VERSION"
    const val APP_COMPAT = "com.jakewharton.rxbinding3:rxbinding-appcompat:$VERSION"
    const val RECYCLER = "com.jakewharton.rxbinding3:rxbinding-recyclerview:$VERSION"
    const val METERIAL_COMPONENTS = "com.jakewharton.rxbinding3:rxbinding-material:$VERSION"
}

object Reprint {
    private const val VERSION = "3.3.1@aar"

    const val CORE = "com.github.ajalt.reprint:core:$VERSION"
    const val RX = "com.github.ajalt.reprint:rxjava2:$VERSION"
    const val SPASS = "com.github.ajalt.reprint:reprint_spass:$VERSION"
}

object Telemed {
    const val VOX_IMPLANT = "com.voximplant:voximplant-sdk:2.16.1"
    const val SOCKET_IO = "com.github.nkzawa:socket.io-client:0.6.0"
}

/**
 * Utilities and tools.
 */
object Tools {
    const val JUNIT = "junit:junit:4.12"
    const val OKIO = "com.squareup.okio:okio:2.0.0"
    const val GSON = "com.google.code.gson:gson:2.8.5"
    const val LOTTIE = "com.airbnb.android:lottie:2.8.0"
    const val TIMBER = "com.github.ajalt:timberkt:1.5.1"
    const val AMPLITUDE = "com.amplitude:android-sdk:2.16.0"
    const val TEXT_INPUT_MASK = "com.redmadrobot:inputmask:4.0.0"
    const val WORK_MANAGER = "androidx.work:work-runtime-ktx:2.0.1"
    const val CHROME_CUSTOM_TABS = "androidx.browser:browser:1.0.0"
    const val PAGE_INDICATOR = "com.romandanylyk:pageindicatorview:1.0.3"
    const val OKHTTP_LOGGER = "com.github.ihsanbal:LoggingInterceptor:3.0.0"
    const val MATERIAL_DIALOGS = "com.afollestad.material-dialogs:core:2.8.1"
    const val ADAPTER_DELEGATES = "com.hannesdorfmann:adapterdelegates4:4.0.0"
    const val BINARY_PREFERENCES = "com.github.yandextaxitech:binaryprefs:1.0.0"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"
}