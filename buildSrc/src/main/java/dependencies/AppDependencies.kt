package dependencies

object AppDependencies {
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT_VERSION}"
    const val ANDROID_CORE = "androidx.core:core-ktx:${Versions.ANDROID_CORE_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
}