package com.maleficmobile.docs

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        SimpleDocumentationApp()
    }
}

@Composable
fun SimpleDocumentationApp() {
    var activeSection by remember { mutableStateOf("introduction") }
    
    Style {
        universal style {
            margin(0.px)
            padding(0.px)
            boxSizing("border-box")
        }
        
        "body" style {
            fontFamily("-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "sans-serif")
            lineHeight("1.6")
            backgroundColor(Color.white)
        }
        
        ".container" style {
            display(DisplayStyle.Flex)
            minHeight(100.vh)
        }
        
        ".sidebar" style {
            width(300.px)
            background("linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
            color(Color.white)
            padding(2.cssRem)
            position(Position.Fixed)
            height(100.vh)
            property("overflow-y", "auto")
        }
        
        ".content" style {
            marginLeft(300.px)
            padding(3.cssRem)
            flexGrow(1)
        }
        
        ".nav-link" style {
            display(DisplayStyle.Block)
            color(Color.white)
            padding(0.75.cssRem)
            property("text-decoration", "none")
            borderRadius(8.px)
            marginBottom(0.5.cssRem)
            cursor("pointer")
        }
        
        ".nav-link:hover" style {
            backgroundColor(rgba(255, 255, 255, 0.1))
        }
        
        ".nav-link.active" style {
            backgroundColor(rgba(255, 255, 255, 0.2))
        }
        
        "h1" style {
            fontSize(3.cssRem)
            color(rgb(45, 55, 72))
            marginBottom(1.cssRem)
        }
        
        "h2" style {
            fontSize(2.cssRem)
            color(rgb(45, 55, 72))
            marginBottom(1.cssRem)
        }
        
        ".code-block" style {
            backgroundColor(rgb(45, 55, 72))
            color(Color.white)
            padding(1.cssRem)
            borderRadius(8.px)
            fontFamily("Monaco", "monospace")
            property("white-space", "pre")
        }
    }
    
    Div(attrs = { classes("container") }) {
        // Sidebar
        Nav(attrs = { classes("sidebar") }) {
            H2 { Text("MaleficMobile") }
            P { Text("Kotlin Multiplatform Template") }
            
            NavLink("🏠 Introduction", "introduction", activeSection) { activeSection = it }
            NavLink("📋 Prerequisites", "prerequisites", activeSection) { activeSection = it }
            NavLink("🚀 Getting Started", "getting-started", activeSection) { activeSection = it }
            NavLink("📁 Project Structure", "project-structure", activeSection) { activeSection = it }
            NavLink("💻 Examples", "examples", activeSection) { activeSection = it }
            NavLink("❓ Help", "help", activeSection) { activeSection = it }
        }
        
        // Main content
        Main(attrs = { classes("content") }) {
            when (activeSection) {
                "introduction" -> IntroductionContent()
                "prerequisites" -> PrerequisitesContent()
                "getting-started" -> GettingStartedContent()
                "project-structure" -> ProjectStructureContent()
                "examples" -> ExamplesContent()
                "help" -> HelpContent()
                else -> IntroductionContent()
            }
        }
    }
}

@Composable
fun NavLink(text: String, section: String, activeSection: String, onSectionChange: (String) -> Unit) {
    Div(
        attrs = {
            classes("nav-link", if (activeSection == section) "active" else "")
            onClick { onSectionChange(section) }
        }
    ) {
        Text(text)
    }
}

@Composable
fun IntroductionContent() {
    H1 { Text("Welcome to MaleficMobile") }
    P { 
        Text("A comprehensive Kotlin Multiplatform template designed for UI developers who want to quickly build functional mobile applications with Compose Multiplatform.") 
    }
    
    H2 { Text("Features") }
    Ul {
        Li { Text("📱 Cross-Platform: Write once, run on both Android and iOS") }
        Li { Text("⚡ Fast Development: Get started in minutes with pre-configured project structure") }
        Li { Text("🧩 Modern UI: Built with Compose Multiplatform and Material 3") }
        Li { Text("🔧 Production-Ready: Includes theming, navigation, and architecture patterns") }
    }
}

@Composable
fun PrerequisitesContent() {
    H1 { Text("Prerequisites") }
    P { Text("Before you begin, ensure you have the following tools installed:") }
    
    Ul {
        Li { Text("☕ Java Development Kit (Java 17 or higher)") }
        Li { Text("🔗 Git for version control and project cloning") }
        Li { Text("💻 IntelliJ IDEA (Community or Ultimate Edition)") }
        Li { Text("🤖 Android SDK (SDK tools, platform tools, emulator)") }
    }
    
    H2 { Text("For iOS Development") }
    P { Text("If you want to build and run on iOS, you'll also need:") }
    Ul {
        Li { Text("🍎 macOS machine") }
        Li { Text("📱 Xcode (latest stable version)") }
        Li { Text("🔧 Xcode Command Line Tools") }
    }
}

@Composable
fun GettingStartedContent() {
    H1 { Text("Getting Started") }
    P { Text("Follow these step-by-step instructions to set up your development environment and run your first MaleficMobile app.") }
    
    H2 { Text("1. Clone the Repository") }
    P { Text("First, clone the MaleficMobile template repository to your local machine:") }
    
    Pre(attrs = { classes("code-block") }) {
        Text("""git clone https://github.com/OmyDaGreat/MaleficMobile.git
cd MaleficMobile""")
    }
    
    H2 { Text("2. Open in IntelliJ IDEA") }
    P { Text("Launch IntelliJ IDEA and open the project:") }
    Ol {
        Li { Text("Open IntelliJ IDEA") }
        Li { Text("Click Open or File → Open") }
        Li { Text("Navigate to and select the MaleficMobile folder") }
        Li { Text("Click OK to open the project") }
        Li { Text("Wait for Gradle to sync (this may take a few minutes on first run)") }
    }
    
    H2 { Text("3. Run the Application") }
    P { Text("Once the project is open and synced:") }
    Ol {
        Li { Text("For Android: Click the green play button next to 'composeApp' in the run configuration dropdown") }
        Li { Text("For iOS: Select the iOS simulator and run the project") }
    }
}

@Composable
fun ProjectStructureContent() {
    H1 { Text("Project Structure") }
    P { Text("Understanding the MaleficMobile project structure:") }
    
    Pre(attrs = { classes("code-block") }) {
        Text("""MaleficMobile/
├── 📁 composeApp/          # Main application code
│   ├── 📁 src/
│   │   ├── 📁 androidMain/   # Android-specific code
│   │   ├── 📁 commonMain/    # Shared code
│   │   └── 📁 iosMain/       # iOS-specific code
├── 📁 iosApp/              # iOS app wrapper
├── 📁 gradle/              # Gradle wrapper files
├── 📄 build.gradle.kts     # Project build configuration
└── 📄 settings.gradle.kts  # Project settings""")
    }
    
    H2 { Text("Key Directories") }
    Ul {
        Li { Text("📂 commonMain: Shared business logic, UI components, and data models") }
        Li { Text("📂 androidMain: Android-specific implementations and configurations") }
        Li { Text("📂 iosMain: iOS-specific implementations and configurations") }
    }
}

@Composable
fun ExamplesContent() {
    H1 { Text("Examples") }
    P { Text("Explore common patterns and implementations:") }
    
    H2 { Text("Simple Counter App") }
    Pre(attrs = { classes("code-block") }) {
        Text("""@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: ${'$'}count",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}""")
    }
    
    H2 { Text("Navigation Between Screens") }
    P { Text("Use Compose Navigation to navigate between different screens in your app.") }
    
    H2 { Text("Network Requests") }
    P { Text("Make HTTP requests with Ktor client configured for multiplatform use.") }
}

@Composable
fun HelpContent() {
    H1 { Text("Need Help?") }
    P { Text("Resources and support for MaleficMobile:") }
    
    H2 { Text("📚 Documentation") }
    Ul {
        Li { 
            A("https://www.jetbrains.com/help/kotlin-multiplatform-dev/") { 
                Text("Kotlin Multiplatform Documentation") 
            }
        }
        Li { 
            A("https://github.com/JetBrains/compose-multiplatform") { 
                Text("Compose Multiplatform") 
            }
        }
    }
    
    H2 { Text("🐛 Issues & Support") }
    Ul {
        Li { 
            A("https://github.com/OmyDaGreat/MaleficMobile/issues") { 
                Text("GitHub Issues") 
            }
        }
        Li { Text("📧 Community discussions and support") }
    }
    
    H2 { Text("🔧 Common Troubleshooting") }
    Ul {
        Li { Text("Gradle sync issues: Clear cache and restart IDE") }
        Li { Text("Android emulator problems: Update Android SDK") }
        Li { Text("iOS build issues: Update Xcode and command line tools") }
        Li { Text("Build errors: Clean and rebuild the project") }
    }
}