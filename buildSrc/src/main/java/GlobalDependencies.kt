import Versions.APP_BADGE_PLUGIN
import Versions.FABRIC_PLUGIN
import Versions.FIREBASE_PLUGIN
import Versions.GOOGLE_SERVICES_PLUGIN
import Versions.GRADLE_PLUGIN
import Versions.KOTLIN_PLUGIN

internal object Versions {
    const val GRADLE_PLUGIN = "3.5.0"
    const val KOTLIN_PLUGIN = "1.3.72"
    const val FABRIC_PLUGIN = "1.27.1"
    const val FIREBASE_PLUGIN = "1.1.5"
    const val APP_BADGE_PLUGIN = "1.0.2"
    const val GOOGLE_SERVICES_PLUGIN = "4.2.0"
}
object Plugins {
    //const val FABRIC = "io.fabric.tools:gradle:$FABRIC_PLUGIN"
    const val GRADLE = "com.android.tools.build:gradle:$GRADLE_PLUGIN"
    const val APP_BADGE = "gradle.plugin.app-badge:plugin:$APP_BADGE_PLUGIN"
    const val FIREBASE = "com.google.firebase:firebase-plugins:$FIREBASE_PLUGIN"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_PLUGIN"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:$GOOGLE_SERVICES_PLUGIN"
    const val KOTLIN_EXTENSIONS = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_PLUGIN"
}
