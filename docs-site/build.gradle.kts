plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.maleficmobile.docs"
version = "1.0.0"

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "docs.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
            }
        }
    }
}