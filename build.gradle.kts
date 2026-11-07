// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // 2. Applying plugins to all subprojects{} or allprojects{}
    // apply false
    // https://docs.gradle.org/current/userguide/plugins_intermediate.html
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}