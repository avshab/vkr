import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabric.io/public")
    }

    dependencies {
        classpath(Plugins.GRADLE)
      //  classpath(Plugins.FABRIC)
        classpath(Plugins.KOTLIN)
     //   classpath(Plugins.FIREBASE)
     //   classpath(Plugins.GOOGLE_SERVICES)
        classpath(Plugins.KOTLIN_EXTENSIONS)
    }

}

subprojects {
    enableInlineClasses()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

fun Project.enableInlineClasses() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            val args = kotlinOptions.freeCompilerArgs
            kotlinOptions.freeCompilerArgs = args + listOf("-XXLanguage:+InlineClasses")
        }
    }
}