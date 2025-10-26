plugins {
    id("com.android.application") version "8.13.0" apply false
    id("com.android.library") version "8.13.0" apply false
    kotlin("android") version "1.9.22" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

task("clean") {
    doLast {
        delete(rootProject.buildDir)
    }
}