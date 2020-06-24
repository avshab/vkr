plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.0")
}