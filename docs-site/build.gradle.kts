import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kobweb.application)
}

group = "com.maleficmobile.docs"
version = "1.0.0"

kobweb {
    app {
        index {
            description.set("MaleficMobile Documentation - Kotlin Multiplatform Template")
        }
    }
}

kotlin {
    configAsKobwebApplication("maleficmobile-docs")

    sourceSets {
        jsMain.dependencies {
            implementation(libs.bundles.compose)
            implementation(libs.bundles.kobweb)
            implementation(libs.bundles.silk.icons)
        }
    }
}