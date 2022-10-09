// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("org.jacoco:org.jacoco.core:0.8.8")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.4.0.2513")
    }
}

plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}