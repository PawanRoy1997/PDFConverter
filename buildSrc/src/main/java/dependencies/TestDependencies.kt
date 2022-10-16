package dependencies

object TestDependencies {
//    For Unit testing
    const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"

//    For Instrumentation
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT_VERSION}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"
    const val RUNNER = "androidx.test:runner:${Versions.RUNNER_VERSION}"
    const val RULES = "androidx.test:rules:${Versions.RULES_VERSION}"
}