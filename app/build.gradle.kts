plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("jacoco")
//    id("plugins.jacoco-report")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.freeware.pdfconverter"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isTestCoverageEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    jacoco {
        buildToolsVersion = ("0.8.8")
//        toolVersion = "0.8.5"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

tasks.withType<Test> {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
    }
}

val fileFilter = mutableSetOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "android/**/*.*",
    "**/*\$Lambda$*.*", // Jacoco can not handle several "$" in class name.
    "**/*\$inlined$*.*" // Kotlin specific, Jacoco can not handle several "$" in class name.
)

private val classDirectoriesTree = fileTree(project.buildDir) {
    include(
        "**/classes/**/main/**",
        "**/intermediates/classes/debug/**",
        "**/intermediates/javac/debug/*/classes/**", // Android Gradle Plugin 3.2.x support.
        "**/tmp/kotlin-classes/debug/**"
    )

    exclude(fileFilter)
}

private val sourceDirectoriesTree = fileTree("${project.buildDir}") {
    include(
        "src/main/java/**",
        "src/main/kotlin/**",
        "src/debug/java/**",
        "src/debug/kotlin/**"
    )
}

private val executionDataTree = fileTree(project.buildDir) {
    include(
        "outputs/code_coverage/**/*.ec",
        "jacoco/jacocoTestReportDebug.exec",
        "jacoco/testDebugUnitTest.exec",
        "jacoco/test.exec"
    )
}

fun JacocoReportsContainer.reports() {
    xml.isEnabled = true
    html.isEnabled = true
    xml.destination = file("${buildDir}/reports/jacoco/jacocoTestReport/jacocoTestReport.xml")
    html.destination = file("${buildDir}/reports/jacoco/jacocoTestReport/html")
}

fun JacocoCoverageVerification.setDirectories() {
    sourceDirectories.setFrom(sourceDirectoriesTree)
    classDirectories.setFrom(classDirectoriesTree)
    executionData.setFrom(executionDataTree)
}

fun JacocoReport.setDirectories() {
    sourceDirectories.setFrom(sourceDirectoriesTree)
    classDirectories.setFrom(classDirectoriesTree)
    executionData.setFrom(executionDataTree)
}

if (tasks.findByName("jacocoAndroidTestReport") == null) {

    tasks.register<JacocoReport>("jacocoAndroidTestReport") {
        group = "verification"
        description = "Code coverage report for both Android and Unit tests."
        dependsOn("testDebugUnitTest", "createDebugCoverageReport")
        reports {
            reports()
        }
        setDirectories()
    }
}

if (tasks.findByName("jacocoAndroidCoverageVerification") == null) {
    tasks.register<JacocoCoverageVerification>("jacocoAndroidCoverageVerification") {
        group = "verification"
        description = "Code coverage verification for Android both Android and Unit tests."
        dependsOn("testDebugUnitTest", "createDebugCoverageReport")
        violationRules {
            rule {
                limit {
                    counter = "INSTRUCTIONAL"
                    value = "COVEREDRATIO"
                    minimum = "0.5".toBigDecimal()
                }
            }
        }
        setDirectories()
    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

//    Lottie
    implementation("com.airbnb.android:lottie:5.2.0")

//    Testing
    testImplementation("junit:junit:4.13.2")

//    Espresso
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
}