plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fun.fuionix.launcher"

    compileSdk {
        version = release(37)
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    defaultConfig {
        applicationId = "fun.fuionix.launcher"
        minSdk = 23
        targetSdk = 37
        versionCode = 1
        versionName = "10.0.10000"
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
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}