import Build_gradle.Plugin.GRADLE_ANDROID_PLUGIN
import Build_gradle.Plugin.HILT_PLUGIN
import Build_gradle.PluginVersion.JACOCO
import Build_gradle.Plugin.JACOCO_PLUGIN
import Build_gradle.Plugin.KOTLIN_GRADLE_PLUGIN
import Build_gradle.PluginVersion.GRADLE_ANDROID
import Build_gradle.PluginVersion.HILT
import Build_gradle.PluginVersion.KOTLIN

repositories {
    google()
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

object Plugin{
    const val JACOCO_PLUGIN = "org.jacoco:org.jacoco.core:$JACOCO"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:$HILT"
    const val GRADLE_ANDROID_PLUGIN = "com.android.tools.build:gradle:$GRADLE_ANDROID"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN"
}

object PluginVersion {
    const val JACOCO = "0.8.8"
    const val HILT = "2.44"
    const val GRADLE_ANDROID = "7.3.0"
    const val KOTLIN = "1.4.0"
}

dependencies {
    implementation(JACOCO_PLUGIN)
    implementation(GRADLE_ANDROID_PLUGIN)
    implementation(KOTLIN_GRADLE_PLUGIN)
//    implementation(HILT_PLUGIN)
}