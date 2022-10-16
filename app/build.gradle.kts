import config.BuildConfig
import dependencies.AppDependencies
import dependencies.CommonDependencies
import dependencies.TestDependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("jacoco")
    id("plugins.jacoco-report")
}

android {
    compileSdk = BuildConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = BuildConfig.APPLICATION_ID
        minSdk = BuildConfig.MIN_SDK_VERSION
        targetSdk = BuildConfig.TARGET_SDK_VERSION
        versionCode = BuildConfig.VERSION_CODE
        versionName = BuildConfig.VERSION_NAME

        testInstrumentationRunner = BuildConfig.INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            enableUnitTestCoverage = BuildTypeRelease.isTestCoverageEnabled
            enableAndroidTestCoverage = BuildTypeRelease.isTestCoverageEnabled
            applicationIdSuffix = BuildTypeRelease.applicationIdSuffix
            versionNameSuffix = BuildTypeRelease.versionNameSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName(DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            enableUnitTestCoverage = BuildTypeDebug.isTestCoverageEnabled
            enableAndroidTestCoverage = BuildTypeDebug.isTestCoverageEnabled
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    testCoverage {
        buildToolsVersion = ("30.0.3")
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
    namespace = "com.freeware.pdfconverter"
}
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(AppDependencies.ANDROID_CORE)
    implementation(AppDependencies.APP_COMPAT)
    implementation(AppDependencies.MATERIAL)
    implementation(AppDependencies.CONSTRAINT_LAYOUT)

//    Timber for logging
    implementation(CommonDependencies.TIMBER)

//    Dependency Inject Hilt
    implementation(AppDependencies.HILT)
    kapt(AppDependencies.HILT_COMPILER)

//    Lottie
    implementation(CommonDependencies.LOTTIE)

//    Testing
    testImplementation(TestDependencies.JUNIT)

//    Espresso
    androidTestImplementation(TestDependencies.JUNIT_EXT)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    androidTestImplementation(TestDependencies.RUNNER)
    androidTestImplementation(TestDependencies.RULES)
}