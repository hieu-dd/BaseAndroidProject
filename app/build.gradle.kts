import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

android {
    namespace = "com.d2brothers.note"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.d2brothers.note"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.d2brothers.note.InstrumentationTestRunner"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(libs.bundles.app.ui)
    implementation(libs.multiplatformSettings.common)
    implementation(libs.material3)
    implementation(libs.material3.window)
    implementation(libs.kotlinx.dateTime)
    coreLibraryDesugaring(libs.android.desugaring)
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    implementation(libs.compose.destination.core)
    ksp(libs.compose.destination.ksp)

    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
    // Local unit tests
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    testImplementation("io.mockk:mockk:1.10.5")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.0-alpha03")

    // Instrumentation tests
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    androidTestImplementation("io.mockk:mockk-android:1.10.5")
    androidTestImplementation("androidx.test:runner:1.5.1")

    // Koin Test features
    testImplementation("io.insert-koin:koin-test:3.3.2")
    testImplementation("io.insert-koin:koin-test-junit4:3.3.2")
    testImplementation("io.insert-koin:koin-test-junit5:3.3.2")
}