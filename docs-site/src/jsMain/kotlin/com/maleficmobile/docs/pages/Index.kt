package com.maleficmobile.docs.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Page
@Composable
fun HomePage() {
    var activeSection by remember { mutableStateOf("introduction") }
    
    // Container div for the layout
    Div(attrs = { 
        style { 
            display(DisplayStyle.Flex)
            minHeight(100.vh)
        } 
    }) {
        // Sidebar
        Aside(attrs = {
            style {
                width(300.px)
                background("linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
                color(Color.white)
                padding(2.cssRem)
                position(Position.Fixed)
                height(100.vh)
                property("overflow-y", "auto")
            }
        }) {
            Header {
                H1(attrs = {
                    style {
                        fontSize(2.cssRem)
                        fontWeight("bold")
                        marginBottom(1.cssRem)
                        color(Color.white)
                    }
                }) {
                    Text("MaleficMobile")
                }
                P(attrs = {
                    style {
                        fontSize(1.2.cssRem)
                        opacity(0.9)
                        marginBottom(3.cssRem)
                        color(Color.white)
                    }
                }) {
                    Text("Kotlin Multiplatform Template")
                }
            }
            
            Nav {
                NavLink("🏠 Introduction", "introduction", activeSection) { activeSection = it }
                NavLink("📋 Prerequisites", "prerequisites", activeSection) { activeSection = it }
                NavLink("🚀 Getting Started", "getting-started", activeSection) { activeSection = it }
                NavLink("📁 Project Structure", "project-structure", activeSection) { activeSection = it }
                NavLink("🎨 Customization", "customization", activeSection) { activeSection = it }
                NavLink("💻 Examples", "examples", activeSection) { activeSection = it }
                NavLink("🔧 Advanced Topics", "advanced", activeSection) { activeSection = it }
                NavLink("❓ Help", "help", activeSection) { activeSection = it }
            }
        }
        
        // Main content area
        Main(attrs = {
            style {
                marginLeft(300.px)
                padding(3.cssRem)
                flexGrow(1)
                property("overflow-y", "auto")
            }
        }) {
            when (activeSection) {
                "introduction" -> IntroductionContent()
                "prerequisites" -> PrerequisitesContent()
                "getting-started" -> GettingStartedContent()
                "project-structure" -> ProjectStructureContent()
                "customization" -> CustomizationContent()
                "examples" -> ExamplesContent()
                "advanced" -> AdvancedContent()
                "help" -> HelpContent()
                else -> IntroductionContent()
            }
        }
    }
}

@Composable
fun NavLink(text: String, section: String, activeSection: String, onSectionChange: (String) -> Unit) {
    Div(attrs = {
        style {
            padding(0.8.cssRem)
            marginBottom(0.5.cssRem)
            borderRadius(0.5.cssRem)
            cursor("pointer")
            property("transition", "background-color 0.3s ease")
            if (activeSection == section) {
                backgroundColor(Color("#5A67D8"))
            } else {
                backgroundColor(Color.transparent)
            }
        }
        onClick { onSectionChange(section) }
        onMouseEnter { 
            style {
                backgroundColor(if (activeSection == section) Color("#5A67D8") else Color("#5A67D8").apply { 
                    opacity(0.3f)
                })
            }
        }
    }) {
        Text(text)
    }
}

@Composable
fun IntroductionContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("Welcome to MaleficMobile")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("A comprehensive, beginner-friendly documentation for the MaleficMobile Kotlin Multiplatform template, built with modern Kobweb framework.")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Text("🌟 Features")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
            } 
        }) {
            Li { Text("📱 Cross-Platform: Write once, run on both Android and iOS") }
            Li { Text("⚡ Fast Development: Get started in minutes with pre-configured project structure") }
            Li { Text("🧩 Modern UI: Built with Compose Multiplatform and Material 3") }
            Li { Text("🔧 Production-Ready: Includes theming, navigation, and architecture patterns") }
            Li { Text("📚 Comprehensive Documentation: Step-by-step guides for beginners") }
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Text("🎯 Perfect for Beginners")
        }
        P(attrs = { 
            style { 
                fontSize(1.1.cssRem)
                lineHeight("1.6")
            } 
        }) {
            Text("This documentation makes zero assumptions about prior KMP knowledge and guides you through every step from IDE installation to your first app deployment.")
        }
    }
}

@Composable
fun PrerequisitesContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("📋 Prerequisites")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Before you begin, make sure you have the following tools installed. We'll guide you through each step:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("1. ☕ Java Development Kit (JDK) 17+")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Download and install JDK 17 or higher from Oracle or use OpenJDK.")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""# Verify JDK installation
java -version
javac -version""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("2. 🛠️ IntelliJ IDEA or Android Studio")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Download IntelliJ IDEA (Community or Ultimate) or Android Studio. Both support Kotlin Multiplatform development.")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("🔗 IntelliJ IDEA: https://www.jetbrains.com/idea/") }
            Li { Text("🔗 Android Studio: https://developer.android.com/studio") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("3. 🤖 Android SDK & Tools")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Install Android SDK through your IDE or standalone. You'll need:")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("📱 Android SDK Platform 34 (API Level 34) or higher") }
            Li { Text("🔧 Android SDK Build-Tools") }
            Li { Text("⚡ Android Emulator") }
            Li { Text("🏃 Android SDK Platform-Tools") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("4. 🍎 Xcode (iOS Development - macOS Only)")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("For iOS development, you need Xcode installed on macOS:")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("💻 macOS computer") }
            Li { Text("🛠️ Xcode 14.0 or later") }
            Li { Text("📱 iOS Simulator") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("5. 🔧 Git")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Git is required to clone the template repository.")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("# Verify Git installation\ngit --version") 
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#E6FFFA"))
                border(1.px, LineStyle.Solid, Color("#4FD1C7"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("💡 Quick Setup Verification")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Once everything is installed, verify your setup by running these commands in your terminal:")
            }
            Pre(attrs = { 
                style { 
                    backgroundColor(Color("#f4f4f4"))
                    padding(1.cssRem)
                    borderRadius(0.5.cssRem)
                    marginTop(1.cssRem)
                } 
            }) {
                Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                    Text("""java -version
git --version
# Open your IDE and check if Kotlin plugin is installed""") 
                }
            }
        }
    }
}

@Composable
fun GettingStartedContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("🚀 Getting Started")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Follow these detailed steps to get your MaleficMobile project up and running. Each step includes troubleshooting tips for common issues.")
        }
    }
    
    Section {
        // Step 1
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                marginBottom(1.cssRem)
            }
        }) {
            Div(attrs = {
                style {
                    backgroundColor(Color("#4299E1"))
                    color(Color.white)
                    width(2.5.cssRem)
                    height(2.5.cssRem)
                    borderRadius(50.percent)
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginRight(1.cssRem)
                }
            }) {
                Text("1")
            }
            H2(attrs = { 
                style { 
                    fontSize(2.cssRem)
                    fontWeight("bold")
                    margin(0.px)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("Clone the Template")
            }
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("First, clone the MaleficMobile template repository to your local machine:")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(2.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""# Clone the repository
git clone https://github.com/OmyDaGreat/MaleficMobile.git

# Navigate to the project directory
cd MaleficMobile""") 
            }
        }
        
        // Step 2
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                marginBottom(1.cssRem)
                marginTop(3.cssRem)
            }
        }) {
            Div(attrs = {
                style {
                    backgroundColor(Color("#4299E1"))
                    color(Color.white)
                    width(2.5.cssRem)
                    height(2.5.cssRem)
                    borderRadius(50.percent)
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginRight(1.cssRem)
                }
            }) {
                Text("2")
            }
            H2(attrs = { 
                style { 
                    fontSize(2.cssRem)
                    fontWeight("bold")
                    margin(0.px)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("Open in IDE")
            }
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Open the project in IntelliJ IDEA or Android Studio:")
        }
        Ol(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("Launch IntelliJ IDEA or Android Studio") }
            Li { Text("Choose 'Open' or 'Open an Existing Project'") }
            Li { Text("Navigate to the MaleficMobile folder and select it") }
            Li { Text("Click 'OK' and wait for Gradle sync to complete") }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#FFF5F5"))
                border(1.px, LineStyle.Solid, Color("#FC8181"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(1.cssRem)
                marginBottom(2.cssRem)
            }
        }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#C53030"))
                } 
            }) {
                Text("⚠️ Troubleshooting Gradle Sync")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("If Gradle sync fails:")
            }
            Ul(attrs = { style { marginLeft(1.cssRem) } }) {
                Li { Text("Check your internet connection") }
                Li { Text("Verify JDK 17+ is installed and configured") }
                Li { Text("Try 'File > Invalidate Caches and Restart'") }
                Li { Text("Delete the .gradle folder and retry sync") }
            }
        }
        
        // Step 3
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                marginBottom(1.cssRem)
                marginTop(3.cssRem)
            }
        }) {
            Div(attrs = {
                style {
                    backgroundColor(Color("#4299E1"))
                    color(Color.white)
                    width(2.5.cssRem)
                    height(2.5.cssRem)
                    borderRadius(50.percent)
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginRight(1.cssRem)
                }
            }) {
                Text("3")
            }
            H2(attrs = { 
                style { 
                    fontSize(2.cssRem)
                    fontWeight("bold")
                    margin(0.px)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("Configure Android Emulator")
            }
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Set up an Android Virtual Device (AVD) to test your app:")
        }
        Ol(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("In your IDE, go to Tools > AVD Manager (or View > Tool Windows > Device Manager)") }
            Li { Text("Click 'Create Virtual Device'") }
            Li { Text("Choose a device definition (e.g., Pixel 4) and click 'Next'") }
            Li { Text("Select a system image (recommended: latest API level) and download if needed") }
            Li { Text("Accept licenses if prompted") }
            Li { Text("Click 'Next', configure settings if desired, then 'Finish'") }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#E6FFFA"))
                border(1.px, LineStyle.Solid, Color("#4FD1C7"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(1.cssRem)
                marginBottom(2.cssRem)
            }
        }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("💡 Performance Tips")
            }
            Ul(attrs = { style { marginLeft(1.cssRem) } }) {
                Li { Text("Enable hardware acceleration (HAXM on Intel, Hyper-V on Windows)") }
                Li { Text("Use x86_64 images for better performance on Intel/AMD CPUs") }
                Li { Text("Allocate at least 4GB RAM to the emulator") }
                Li { Text("Enable 'Use Quick Boot' for faster startup") }
            }
        }
        
        // Step 4
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                marginBottom(1.cssRem)
                marginTop(3.cssRem)
            }
        }) {
            Div(attrs = {
                style {
                    backgroundColor(Color("#4299E1"))
                    color(Color.white)
                    width(2.5.cssRem)
                    height(2.5.cssRem)
                    borderRadius(50.percent)
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginRight(1.cssRem)
                }
            }) {
                Text("4")
            }
            H2(attrs = { 
                style { 
                    fontSize(2.cssRem)
                    fontWeight("bold")
                    margin(0.px)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("Build and Run")
            }
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Now you're ready to build and run your first MaleficMobile app:")
        }
        Ol(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("Start your Android emulator from AVD Manager") }
            Li { Text("In the IDE, navigate to composeApp > src > androidMain > kotlin > com.jetbrains.kmpapp") }
            Li { Text("Open MainActivity.kt") }
            Li { Text("Select your running emulator in the device dropdown") }
            Li { Text("Click the green Run button (▶️) or press Shift+F10") }
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""# Alternative: Build from command line
./gradlew :composeApp:assembleDebug

# Install on connected device/emulator
./gradlew :composeApp:installDebug""") 
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#F0FFF4"))
                border(1.px, LineStyle.Solid, Color("#9AE6B4"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#276749"))
                } 
            }) {
                Text("🎉 Success!")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("If everything works correctly, you should see the MaleficMobile app running in your emulator. The app will display a welcome screen with Material 3 design.")
            }
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.8.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🍎 Running on iOS (macOS only)")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("To run on iOS, you need macOS with Xcode installed:")
        }
        Ol(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
                marginLeft(1.5.cssRem)
            } 
        }) {
            Li { Text("Open the iosApp.xcodeproj file in Xcode") }
            Li { Text("Select a simulator or connected iOS device") }
            Li { Text("Click the Run button in Xcode") }
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("# Build iOS app from command line (macOS only)\n./gradlew :composeApp:iosSimulatorArm64Test") 
            }
        }
    }
}

@Composable
fun ProjectStructureContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("📁 Project Structure")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Understanding the MaleficMobile project layout and how Kotlin Multiplatform organizes code:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📂 Complete Project Overview")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f8f9fa"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                fontFamily("Consolas, 'Courier New', monospace")
                fontSize(0.9.cssRem)
                lineHeight("1.4")
                border(1.px, LineStyle.Solid, Color("#e1e5e9"))
            } 
        }) {
            Code { 
                Text("""MaleficMobile/
├── 📱 composeApp/                                 # Main Kotlin Multiplatform module
│   ├── build.gradle.kts                          # Build configuration for shared module
│   └── src/
│       ├── 🤖 androidMain/                       # Android-specific code
│       │   ├── kotlin/com/jetbrains/kmpapp/
│       │   │   ├── MainActivity.kt               # Android entry point Activity
│       │   │   └── MobileApp.kt                  # Android Application class
│       │   ├── res/                              # Android resources
│       │   │   ├── mipmap-*/                     # App icons for different densities
│       │   │   ├── values/                       # Strings, colors, themes
│       │   │   └── drawable/                     # Images and vector graphics
│       │   └── AndroidManifest.xml               # Android app configuration
│       ├── 🍎 iosMain/                           # iOS-specific code
│       │   └── kotlin/com/jetbrains/kmpapp/
│       │       └── MainViewController.kt         # iOS entry point (UIViewController)
│       └── 🔄 commonMain/                        # Shared code (Android + iOS)
│           └── kotlin/com/jetbrains/kmpapp/
│               ├── App.kt                        # Root Composable UI
│               ├── Platform.kt                   # Platform-specific interfaces
│               └── screens/                      # Shared UI screens
│                   ├── EmptyScreen.kt            # Example screen
│                   └── DemoScreen.kt             # Example screen
├── 🍎 iosApp/                                    # Native iOS application wrapper
│   ├── iosApp.xcodeproj                          # Xcode project file
│   └── iosApp/
│       ├── ContentView.swift                     # SwiftUI bridge to Compose
│       ├── iOSApp.swift                          # iOS app entry point
│       └── Info.plist                            # iOS app configuration
├── 📚 docs-site/                                 # Documentation website (Kobweb)
│   ├── .kobweb/                                  # Kobweb configuration
│   ├── src/jsMain/kotlin/                        # Documentation source code
│   └── build.gradle.kts                          # Kobweb build configuration
├── 🔧 Build Configuration
│   ├── build.gradle.kts                          # Root project build script
│   ├── settings.gradle.kts                       # Gradle settings & module declaration
│   ├── gradle.properties                         # Gradle configuration properties
│   └── gradle/                                   # Gradle wrapper files
└── 📄 Project Files
    ├── README.adoc                               # Project documentation
    ├── .gitignore                                # Git ignore rules
    └── .editorconfig                             # Code style configuration""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🎯 Key Concepts")
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#EBF8FF"))
                border(1.px, LineStyle.Solid, Color("#90CDF4"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginBottom(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.4.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2B6CB0"))
                } 
            }) {
                Text("🔄 commonMain - Shared Code")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("This is where the magic happens! Code written here runs on both Android and iOS without modification. This includes:")
            }
            Ul(attrs = { 
                style { 
                    marginLeft(1.cssRem)
                    marginTop(0.5.cssRem)
                } 
            }) {
                Li { Text("🎨 Complete UI built with Compose Multiplatform") }
                Li { Text("🧠 Business logic and data models") }
                Li { Text("🌐 Network calls and data repositories") }
                Li { Text("⚡ State management and ViewModels") }
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#F0FFF4"))
                border(1.px, LineStyle.Solid, Color("#9AE6B4"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginBottom(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.4.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#276749"))
                } 
            }) {
                Text("🤖 androidMain - Android Specific")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Platform-specific Android code that bridges the shared UI to the Android platform:")
            }
            Ul(attrs = { 
                style { 
                    marginLeft(1.cssRem)
                    marginTop(0.5.cssRem)
                } 
            }) {
                Li { Text("📱 MainActivity.kt - Entry point that hosts Compose UI") }
                Li { Text("🎨 Android resources (strings, themes, icons)") }
                Li { Text("⚙️ AndroidManifest.xml for permissions and configuration") }
                Li { Text("🔧 Platform-specific implementations") }
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#FFFAF0"))
                border(1.px, LineStyle.Solid, Color("#FBD38D"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginBottom(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.4.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#B7791F"))
                } 
            }) {
                Text("🍎 iosMain + iosApp - iOS Integration")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("iOS platform integration split between Kotlin and Swift:")
            }
            Ul(attrs = { 
                style { 
                    marginLeft(1.cssRem)
                    marginTop(0.5.cssRem)
                } 
            }) {
                Li { Text("🔗 MainViewController.kt - Kotlin bridge to iOS") }
                Li { Text("🍎 iosApp/ - Native Swift app wrapper") }
                Li { Text("🌉 ContentView.swift - SwiftUI bridge to Compose") }
                Li { Text("📋 Info.plist - iOS app configuration") }
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🔧 Important Files Explained")
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("📄 build.gradle.kts Files")
            }
            Ul(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("🏗️ Root build.gradle.kts - Configures plugins and repositories for entire project") }
                Li { Text("📱 composeApp/build.gradle.kts - Defines multiplatform targets, dependencies, and build configuration") }
                Li { Text("⚙️ settings.gradle.kts - Declares project modules and plugin management") }
            }
            
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginTop(2.cssRem)
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🎨 Key Source Files")
            }
            Ul(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("🚀 App.kt - Root Composable that defines your app's main UI") }
                Li { Text("📱 MainActivity.kt - Android entry point that launches Compose UI") }
                Li { Text("🍎 MainViewController.kt - iOS entry point that creates UIViewController") }
                Li { Text("🖥️ screens/ - Directory for organizing different app screens") }
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#F7FAFC"))
                border(1.px, LineStyle.Solid, Color("#CBD5E0"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("💡 Development Workflow")
            }
            Ol(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("✍️ Write shared UI and logic in commonMain/") }
                Li { Text("🔧 Add platform-specific code in androidMain/ or iosMain/ when needed") }
                Li { Text("🧪 Test on Android emulator using the run button") }
                Li { Text("🍎 Test on iOS simulator using Xcode (macOS only)") }
                Li { Text("📦 Build for production using Gradle tasks") }
            }
        }
    }
}

@Composable
fun CustomizationContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("🎨 Customization")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Learn how to customize your MaleficMobile app with your own branding, colors, and features:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📱 1. Change App Name & Icon")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🏷️ Update App Name")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Change the app name displayed on device home screens:")
        }
        
        Div(attrs = { style { marginTop(1.cssRem) } }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#4A5568"))
                } 
            }) {
                Text("📄 Android (AndroidManifest.xml)")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Edit composeApp/src/androidMain/AndroidManifest.xml:")
            }
            Pre(attrs = { 
                style { 
                    backgroundColor(Color("#f4f4f4"))
                    padding(1.cssRem)
                    borderRadius(0.5.cssRem)
                    property("overflow", "auto")
                    marginTop(0.5.cssRem)
                } 
            }) {
                Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                    Text("""<application
    android:label="Your App Name"    <!-- Change this -->
    android:icon="@mipmap/ic_launcher"
    android:theme="@android:style/Theme.Material3.DayNight">""") 
                }
            }
        }
        
        Div(attrs = { style { marginTop(1.5.cssRem) } }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#4A5568"))
                } 
            }) {
                Text("📄 iOS (Info.plist)")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Edit iosApp/iosApp/Info.plist:")
            }
            Pre(attrs = { 
                style { 
                    backgroundColor(Color("#f4f4f4"))
                    padding(1.cssRem)
                    borderRadius(0.5.cssRem)
                    property("overflow", "auto")
                    marginTop(0.5.cssRem)
                } 
            }) {
                Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                    Text("""<key>CFBundleDisplayName</key>
<string>Your App Name</string>    <!-- Change this -->
<key>CFBundleName</key>
<string>Your App Name</string>    <!-- And this -->""") 
                }
            }
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🎯 Update App Icon")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Replace the default app icons with your custom design:")
        }
        
        Div(attrs = { style { marginTop(1.cssRem) } }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#4A5568"))
                } 
            }) {
                Text("🤖 Android Icons")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Replace icons in these directories with your design:")
            }
            Pre(attrs = { 
                style { 
                    backgroundColor(Color("#f4f4f4"))
                    padding(1.cssRem)
                    borderRadius(0.5.cssRem)
                    property("overflow", "auto")
                    marginTop(0.5.cssRem)
                } 
            }) {
                Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                    Text("""composeApp/src/androidMain/res/
├── mipmap-mdpi/ic_launcher.png       (48x48px)
├── mipmap-hdpi/ic_launcher.png       (72x72px)
├── mipmap-xhdpi/ic_launcher.png      (96x96px)
├── mipmap-xxhdpi/ic_launcher.png     (144x144px)
└── mipmap-xxxhdpi/ic_launcher.png    (192x192px)""") 
                }
            }
        }
        
        Div(attrs = { style { marginTop(1.5.cssRem) } }) {
            H4(attrs = { 
                style { 
                    fontSize(1.2.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#4A5568"))
                } 
            }) {
                Text("🍎 iOS Icons")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("In Xcode, open iosApp.xcodeproj and replace icons in Assets.xcassets/AppIcon.appiconset/")
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🎨 2. Customize Colors & Theme")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Update your app's Material 3 color scheme and theming:")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🌈 Material 3 Color Scheme")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Edit composeApp/src/commonMain/kotlin/com/jetbrains/kmpapp/App.kt:")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(0.5.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color

// Define your custom color scheme
private val customLightColors = lightColorScheme(
    primary = Color(0xFF6366F1),        // Indigo
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE0E7FF),
    secondary = Color(0xFF10B981),      // Emerald
    onSecondary = Color.White,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

private val customDarkColors = darkColorScheme(
    primary = Color(0xFF818CF8),
    onPrimary = Color(0xFF1E1B3C),
    primaryContainer = Color(0xFF4338CA),
    secondary = Color(0xFF34D399),
    onSecondary = Color(0xFF003920),
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5),
)

@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) customDarkColors else customLightColors
    ) {
        // Your app content
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📱 3. Create Your First Screen")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Add a new screen to your app with navigation:")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🆕 Create a New Screen")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Create a new file: composeApp/src/commonMain/kotlin/com/jetbrains/kmpapp/screens/ProfileScreen.kt")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(0.5.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""package com.jetbrains.kmpapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var name by remember { mutableStateOf("Your Name") }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier.size(80.dp)
            )
            
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Button(
                onClick = { /* Save profile */ }
            ) {
                Text("Save Profile")
            }
        }
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🔧 4. Add Features & Navigation")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Set up navigation between screens using Compose Navigation:")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🧭 Navigation Setup")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("First, add navigation dependency to composeApp/build.gradle.kts:")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(0.5.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""commonMain.dependencies {
    implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
}""") 
            }
        }
        
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Then update your App.kt with navigation:")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(0.5.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    onNavigateToProfile = { 
                        navController.navigate("profile") 
                    }
                )
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}""") 
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#E6FFFA"))
                border(1.px, LineStyle.Solid, Color("#4FD1C7"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🎯 Next Steps")
            }
            Ul(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("🗂️ Organize screens into separate packages") }
                Li { Text("🎨 Create reusable UI components") }
                Li { Text("💾 Add data persistence with Room or DataStore") }
                Li { Text("🌐 Integrate network calls with Ktor") }
                Li { Text("📱 Add platform-specific features when needed") }
            }
        }
    }
}

@Composable
fun ExamplesContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("💻 Examples")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Practical, copy-paste ready code examples to help you build common app features:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📊 1. Counter App (State Management)")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Learn basic state management with a simple counter:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Counter Example") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Count: ${"$"}count",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { count-- },
                    enabled = count > 0
                ) {
                    Text("- Decrease")
                }
                
                Button(
                    onClick = { count++ }
                ) {
                    Text("+ Increase")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { count = 0 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Reset")
            }
        }
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📝 2. Form Input Handling")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Handle form input with validation:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""@Composable
fun ContactFormScreen() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }
    
    // Simple validation
    val isEmailValid = email.contains("@") && email.contains(".")
    val isFormValid = name.isNotBlank() && isEmailValid && message.isNotBlank()
    
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Contact Form") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                isError = name.isBlank() && name.isNotEmpty()
            )
            
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                isError = !isEmailValid && email.isNotEmpty(),
                supportingText = {
                    if (!isEmailValid && email.isNotEmpty()) {
                        Text("Please enter a valid email")
                    }
                }
            )
            
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3,
                maxLines = 5
            )
            
            Button(
                onClick = {
                    isSubmitting = true
                    // Simulate API call
                    // submitForm(name, email, message)
                },
                enabled = isFormValid && !isSubmitting,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isSubmitting) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(if (isSubmitting) "Submitting..." else "Submit")
            }
        }
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📋 3. Dynamic Lists (CRUD Operations)")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Create, read, update, and delete items in a list:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val isCompleted: Boolean = false
)

@Composable
fun TaskListScreen() {
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var newTaskTitle by remember { mutableStateOf("") }
    
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Tasks (${"$"}{tasks.size})") })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    if (newTaskTitle.isNotBlank()) {
                        tasks = tasks + Task(title = newTaskTitle)
                        newTaskTitle = ""
                    }
                },
                icon = { Icon(Icons.Default.Add, contentDescription = "Add") },
                text = { Text("Add Task") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Add new task input
            OutlinedTextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text("New task") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                trailingIcon = {
                    if (newTaskTitle.isNotBlank()) {
                        IconButton(
                            onClick = {
                                tasks = tasks + Task(title = newTaskTitle)
                                newTaskTitle = ""
                            }
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                }
            )
            
            // Task list
            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onToggleComplete = { taskId ->
                            tasks = tasks.map {
                                if (it.id == taskId) it.copy(isCompleted = !it.isCompleted)
                                else it
                            }
                        },
                        onDelete = { taskId ->
                            tasks = tasks.filter { it.id != taskId }
                        }
                    )
                }
            }
            
            if (tasks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No tasks yet. Add one above!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🌐 4. Network Requests & Loading States")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Handle API calls with proper loading and error states:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// Data classes
data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int
)

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}

@Composable
fun PostsScreen() {
    var apiState by remember { mutableStateOf<ApiState<List<Post>>>(ApiState.Loading) }
    
    // Simulate API call
    LaunchedEffect(Unit) {
        try {
            delay(2000) // Simulate network delay
            // In real app: val posts = apiService.getPosts()
            val mockPosts = listOf(
                Post(1, "Hello World", "This is my first post", 1),
                Post(2, "Kotlin Multiplatform", "Building cross-platform apps", 1),
                Post(3, "Compose UI", "Declarative UI framework", 2)
            )
            apiState = ApiState.Success(mockPosts)
        } catch (e: Exception) {
            apiState = ApiState.Error("Failed to load posts: ${"$"}{e.message}")
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Posts") },
                actions = {
                    IconButton(
                        onClick = {
                            apiState = ApiState.Loading
                            // Refresh data
                        }
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (val state = apiState) {
            is ApiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Loading posts...")
                    }
                }
            }
            
            is ApiState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(paddingValues),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.data) { post ->
                        PostCard(post = post)
                    }
                }
            }
            
            is ApiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Error",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = state.message,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { apiState = ApiState.Loading }
                        ) {
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }
}""") 
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#E6FFFA"))
                border(1.px, LineStyle.Solid, Color("#4FD1C7"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("💡 Tips for Real Apps")
            }
            Ul(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("🔗 Use Ktor for HTTP client in KMP projects") }
                Li { Text("💾 Add persistence with SQLDelight or Room") }
                Li { Text("🏗️ Implement MVVM architecture with ViewModels") }
                Li { Text("🧪 Write unit tests for your business logic") }
                Li { Text("📱 Test on both Android and iOS devices") }
            }
        }
    }
}

@Composable
fun AdvancedContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("🔧 Advanced Topics")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Advanced patterns and techniques for building production-ready Kotlin Multiplatform apps:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🏗️ Architecture & State Management")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🎯 MVVM with ViewModels")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Implement proper architecture with ViewModel for state management:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// Add to commonMain dependencies
implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")

// ViewModel class
class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    fun addTask(title: String) {
        if (title.isNotBlank()) {
            _tasks.value = _tasks.value + Task(title = title)
        }
    }
    
    fun toggleTask(taskId: String) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == taskId) {
                task.copy(isCompleted = !task.isCompleted)
            } else {
                task
            }
        }
    }
    
    fun deleteTask(taskId: String) {
        _tasks.value = _tasks.value.filter { it.id != taskId }
    }
}

// Usage in Composable
@Composable
fun TaskScreen(viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    // UI implementation using tasks and isLoading
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("💉 Dependency Injection")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Set up dependency injection for better testability and separation of concerns:")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🎭 Koin Setup")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// Add to commonMain dependencies
implementation("io.insert-koin:koin-core:3.5.3")
implementation("io.insert-koin:koin-compose:1.1.2")

// Define modules
val appModule = module {
    single<TaskRepository> { TaskRepositoryImpl() }
    factory { TaskViewModel(get()) }
}

// In your App.kt
@Composable
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {
            // Your app content
        }
    }
}

// Usage in ViewModels
class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {
    // ViewModel implementation
}

// Usage in Composables
@Composable
fun TaskScreen() {
    val viewModel: TaskViewModel = koinViewModel()
    // Use viewModel
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("💾 Data Persistence")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🗃️ SQLDelight for Databases")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Use SQLDelight for type-safe database operations:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// Add to build.gradle.kts
plugins {
    id("app.cash.sqldelight") version "2.0.1"
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.yourapp.database")
        }
    }
}

// Create src/commonMain/sqldelight/com/yourapp/database/Task.sq
CREATE TABLE task (
    id TEXT NOT NULL PRIMARY KEY,
    title TEXT NOT NULL,
    isCompleted INTEGER AS Boolean NOT NULL DEFAULT 0,
    createdAt INTEGER NOT NULL
);

-- Queries
selectAll:
SELECT * FROM task ORDER BY createdAt DESC;

insertTask:
INSERT INTO task(id, title, isCompleted, createdAt) 
VALUES (?, ?, ?, ?);

updateTaskCompletion:
UPDATE task SET isCompleted = ? WHERE id = ?;

deleteTask:
DELETE FROM task WHERE id = ?;

// Repository implementation
class TaskRepository(private val database: AppDatabase) {
    fun getAllTasks(): Flow<List<Task>> {
        return database.taskQueries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { it.map { row -> row.toTask() } }
    }
    
    suspend fun insertTask(task: Task) {
        database.taskQueries.insertTask(
            task.id,
            task.title,
            task.isCompleted,
            task.createdAt
        )
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🌐 Networking with Ktor")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Implement HTTP networking with Ktor client:")
        }
        
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// Add to commonMain dependencies
implementation("io.ktor:ktor-client-core:2.3.7")
implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

// Add platform-specific engines
// Android: implementation("io.ktor:ktor-client-okhttp:2.3.7")
// iOS: implementation("io.ktor:ktor-client-darwin:2.3.7")

// API service
class ApiService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
    
    suspend fun getPosts(): List<Post> {
        return client.get("https://jsonplaceholder.typicode.com/posts")
            .body()
    }
    
    suspend fun createPost(post: CreatePostRequest): Post {
        return client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(post)
        }.body()
    }
}

// Repository pattern
class PostRepository(private val apiService: ApiService) {
    suspend fun getPosts(): Result<List<Post>> {
        return try {
            val posts = apiService.getPosts()
            Result.success(posts)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}""") 
            }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("📱 Platform-Specific Features")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Access platform-specific APIs when needed:")
        }
        
        H3(attrs = { 
            style { 
                fontSize(1.5.cssRem)
                fontWeight("bold")
                marginTop(1.5.cssRem)
                marginBottom(0.8.cssRem)
                color(Color("#2D3748"))
            } 
        }) {
            Text("🔗 Expect/Actual Pattern")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
                marginTop(1.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Code(attrs = { style { fontSize(0.9.cssRem) } }) { 
                Text("""// commonMain/Platform.kt - Expected declaration
expect class PlatformInfo() {
    val name: String
    val version: String
}

expect fun openUrl(url: String)

// androidMain/Platform.android.kt - Android implementation
actual class PlatformInfo {
    actual val name: String = "Android"
    actual val version: String = android.os.Build.VERSION.RELEASE
}

actual fun openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    // Context required - inject through DI or Activity
}

// iosMain/Platform.ios.kt - iOS implementation
actual class PlatformInfo {
    actual val name: String = "iOS"
    actual val version: String = UIDevice.currentDevice.systemVersion
}

actual fun openUrl(url: String) {
    val nsUrl = NSURL.URLWithString(url)
    UIApplication.sharedApplication.openURL(nsUrl!!)
}

// Usage in commonMain
@Composable
fun AboutScreen() {
    val platform = remember { PlatformInfo() }
    
    Text("Running on ${"$"}{platform.name} ${"$"}{platform.version}")
    
    Button(onClick = { openUrl("https://example.com") }) {
        Text("Open Website")
    }
}""") 
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#FFF5F5"))
                border(1.px, LineStyle.Solid, Color("#FC8181"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(2.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#C53030"))
                } 
            }) {
                Text("⚠️ Production Considerations")
            }
            Ul(attrs = { style { lineHeight("1.8") } }) {
                Li { Text("🔒 Implement proper error handling and logging") }
                Li { Text("🧪 Write comprehensive unit and integration tests") }
                Li { Text("📊 Add analytics and crash reporting") }
                Li { Text("🚀 Set up CI/CD pipelines for both platforms") }
                Li { Text("🔐 Handle API keys and secrets securely") }
                Li { Text("📱 Test on real devices before release") }
            }
        }
    }
}

@Composable
fun HelpContent() {
    Header {
        H1(attrs = { 
            style { 
                fontSize(3.cssRem)
                fontWeight("bold")
                marginBottom(1.cssRem)
            } 
        }) {
            Text("❓ Help & Support")
        }
        P(attrs = { 
            style { 
                fontSize(1.2.cssRem)
                color(Color("#666"))
                lineHeight("1.6")
                marginBottom(2.cssRem)
            } 
        }) {
            Text("Need help? Here are the best resources and frequently asked questions:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("🔗 Official Resources")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
            } 
        }) {
            Li { Text("📖 Kotlin Multiplatform Documentation") }
            Li { Text("🎨 Compose Multiplatform Guide") }
            Li { Text("🏗️ Android Developers Documentation") }
            Li { Text("🍎 Apple Developer Documentation") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("💬 Community & Support")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
            } 
        }) {
            Li { Text("🐛 Report issues on GitHub: https://github.com/OmyDaGreat/MaleficMobile/issues") }
            Li { Text("💬 Join Kotlin Slack community") }
            Li { Text("🗣️ Stack Overflow - kotlin-multiplatform tag") }
            Li { Text("📧 Kotlin Multiplatform mailing list") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(3.cssRem)
                marginBottom(1.cssRem)
                color(Color("#4A5568"))
            } 
        }) {
            Text("❓ Frequently Asked Questions")
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🤔 \"Why isn't my app running on iOS?\"")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("iOS development requires macOS and Xcode. If you're on Windows/Linux, you can only build for Android. Consider using cloud services or a Mac for iOS development.")
            }
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🐛 \"Gradle sync keeps failing\"")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Try these steps: 1) Check internet connection, 2) Verify JDK 17+ is installed, 3) Clear Gradle cache (.gradle folder), 4) 'File > Invalidate Caches and Restart' in IDE.")
            }
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("📱 \"How do I add platform-specific features?\"")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Use the expect/actual pattern: define expected functions in commonMain, then provide actual implementations in androidMain and iosMain. See the Advanced Topics section for examples.")
            }
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🔧 \"What's the best way to handle state?\"")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("For simple state, use remember. For complex state, use ViewModels with StateFlow/LiveData. For app-wide state, consider state management libraries like MVI or Redux patterns.")
            }
        }
        
        Div(attrs = { style { marginTop(2.cssRem) } }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🌐 \"How do I make network requests?\"")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("Use Ktor client for HTTP requests in KMP. Add the core library and platform-specific engines (OkHttp for Android, Darwin for iOS). See the Examples section for implementation details.")
            }
        }
        
        Div(attrs = {
            style {
                backgroundColor(Color("#E6FFFA"))
                border(1.px, LineStyle.Solid, Color("#4FD1C7"))
                borderRadius(0.5.cssRem)
                padding(1.cssRem)
                marginTop(3.cssRem)
            }
        }) {
            H3(attrs = { 
                style { 
                    fontSize(1.3.cssRem)
                    fontWeight("bold")
                    marginBottom(0.5.cssRem)
                    color(Color("#2D3748"))
                } 
            }) {
                Text("🚀 Ready to Build Something Amazing?")
            }
            P(attrs = { style { lineHeight("1.6") } }) {
                Text("You now have all the tools and knowledge to create incredible cross-platform mobile apps with Kotlin Multiplatform. Start small, iterate fast, and don't hesitate to ask for help when you need it!")
            }
        }
    }
}