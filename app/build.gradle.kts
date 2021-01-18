plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    kapt {
        correctErrorTypes = true
    }

    defaultConfig {
        applicationId = "com.gagl.moviedbapitest"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("libs"){ include(listOf("*.jar")) })
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kCoroutines}")

    implementation("androidx.room:room-runtime:${Versions.xRoom}")
    kapt("androidx.room:room-compiler:${Versions.xRoom}")
    implementation("androidx.room:room-ktx:${Versions.xRoom}")
    testImplementation("androidx.room:room-testing:${Versions.xRoom}")

    implementation("androidx.appcompat:appcompat:${Versions.xCompat}")
    implementation("androidx.annotation:annotation:${Versions.xAnnotation}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.xConstraintLayout}")
    implementation("androidx.lifecycle:lifecycle-extensions:${Versions.xLifecycle}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.xNavigation}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.xNavigation}")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:${Versions.xHilt}")
    kapt("androidx.hilt:hilt-compiler:${Versions.xHilt}")

    implementation("com.google.android.material:material:${Versions.gMaterial}")
    implementation("com.google.dagger:hilt-android:${Versions.gHilt}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.gHilt}")

    api("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLogginInterceptor}")

    implementation("com.github.bumptech.glide:glide:${Versions.glide}")
    kapt("com.github.bumptech.glide:compiler:${Versions.glide}")

    testImplementation("junit:junit:${Versions.junit}")

    androidTestImplementation("androidx.test.ext:junit:${Versions.xtJunit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.xtEspresso}")
}