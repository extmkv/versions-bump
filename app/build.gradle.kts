plugins {
    alias(libsLib.plugins.android.application)
    alias(libsLib.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.jorgecosta.versionsbump"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jorgecosta.versionsbump"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libsLib.androidx.core.ktx)
    implementation(libsLib.androidx.lifecycle.runtime.ktx)
    implementation(libsLib.androidx.activity.compose)
    implementation(platform(libsLib.androidx.compose.bom))
    implementation(libsLib.androidx.ui)
    implementation(libsLib.androidx.ui.graphics)
    implementation(libsLib.androidx.ui.tooling.preview)
    implementation(libsLib.androidx.material3)
    testImplementation(libsLib.junit)
    androidTestImplementation(libsLib.androidx.junit)
    androidTestImplementation(libsLib.androidx.espresso.core)
    androidTestImplementation(platform(libsLib.androidx.compose.bom))
    androidTestImplementation(libsLib.androidx.ui.test.junit4)
    debugImplementation(libsLib.androidx.ui.tooling)
    debugImplementation(libsLib.androidx.ui.test.manifest)
}