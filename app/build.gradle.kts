plugins {
    // see Using a Version Catalog
    /**
     * A version catalog provides a centralized and consistent way to manage dependency coordinates and versions across your entire build.
     * Instead of declaring versions directly in each build.gradle(.kts) file, you define them once in a libs.versions.toml file.
     */
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.demo2"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.demo2"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        viewBinding = true // 开启视图绑定,为每个 XML 布局文件自动生成一个绑定类
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation("com.google.android.flexbox:flexbox:3.0.0") // Android 原生 XML 布局里没有 Flexbox 容器——FlexboxLayout 不是系统组件，而是 Google 官方支持库提供的。你需要在 build.gradle 里加依赖才能用。

    // 如需向您的项目添加 AndroidX Fragment 库，请在应用的 build.gradle 文件中添加以下依赖项：
    val fragment_version = "1.9.1"
    // Java language implementation

    //commit {} is a Kotlin extension function provided by Fragment KTX, used to replace the lengthy beginTransaction().commit() call.
    // 使用fragmentManager.commit 扩展方法 需要引入androidx.fragment.app.commit和fragment-ktx依赖.
    // fragment-ktx，已经被合并入androidx.fragment:fragment
    implementation("androidx.fragment:fragment:$fragment_version")
    // Kotlin
    // fragment-ktx，已经被合并入androidx.fragment:fragment
    implementation("androidx.fragment:fragment-ktx:$fragment_version")
    // Compose
    implementation("androidx.fragment:fragment-compose:$fragment_version")
    // Testing Fragments in Isolation
    debugImplementation("androidx.fragment:fragment-testing:$fragment_version")
    // BottomNavigationView 需要引入material
    implementation(libs.material)


}