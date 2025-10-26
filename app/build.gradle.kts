import java.util.Properties
android.buildFeatures.buildConfig = true

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    // используем новый id плагина Hilt (версия объявлена в settings.gradle.kts/pluginManagement)
    id("com.google.dagger.hilt.android")
}

        android {
            namespace = "com.example.openrouter" // <-- обязательно указать, замените на ваш package
            // читаем свойства как строки и парсим в Int — так избегаем ClassCastException
            val props: Properties = rootProject.file("gradle.properties").inputStream().use { stream ->
                Properties().apply { load(stream) }
            }

            val compileSdkProp = (props.getProperty("ANDROID_COMPILE_SDK") ?: "34").toInt()
            val minSdkProp = (props.getProperty("ANDROID_MIN_SDK") ?: "23").toInt()
            val targetSdkProp = (props.getProperty("ANDROID_TARGET_SDK") ?: "34").toInt()

            compileSdk = compileSdkProp

            defaultConfig {
                applicationId = "com.example.openrouter"
                minSdk = minSdkProp
                targetSdk = targetSdkProp
                versionCode = (props.getProperty("VERSION_CODE") ?: "1").toInt()
                versionName = props.getProperty("VERSION_NAME") ?: "0.1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                // аккуратно формируем BuildConfig поле (строка в кавычках)
                val openRouterKey = (project.findProperty("OPENROUTER_API_KEY") as? String) ?: ""
                buildConfigField("String", "OPENROUTER_API_KEY", "\"$openRouterKey\"")
                buildConfigField("String", "OPENROUTER_BASE_URL", "\"https://api.openrouter.ai/\"")
            }

            buildTypes {
                debug {
                    isMinifyEnabled = false
                }
                release {
                    isMinifyEnabled = true
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }

            compileOptions {
                // если у вас JDK 17 — оставьте; иначе используйте 11
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            kotlinOptions {
                jvmTarget = "17"
            }

            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = "1.4.3"
            }

            // ЗАМЕНА устаревшего packagingOptions -> packaging
            packaging {
                resources {
                    // можно перечислить явно или использовать шаблон
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }
        }

dependencies {
    // (оставьте ваши зависимости; пример ниже — минимально необходимое)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    implementation("androidx.security:security-crypto:1.1.0-alpha04")

    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.14.0")
}
