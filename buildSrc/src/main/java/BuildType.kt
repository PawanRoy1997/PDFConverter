const val DEBUG = "debug"
const val RELEASE = "release"

interface BuildType {
    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val applicationIdSuffix: String
    val versionNameSuffix: String
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled: Boolean = false
    override val isTestCoverageEnabled: Boolean = true
    override val applicationIdSuffix = ".debug"
    override val versionNameSuffix = "-DEBUG"
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = true
    override val applicationIdSuffix: String = ""
    override val versionNameSuffix: String = ""
}