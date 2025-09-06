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
                NavLink("💻 Examples", "examples", activeSection) { activeSection = it }
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
                "examples" -> ExamplesContent()
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
            Text("Before you begin, make sure you have the following tools installed:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Text("Required Software")
        }
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
            } 
        }) {
            Li { Text("📝 IntelliJ IDEA or Android Studio") }
            Li { Text("☕ JDK 17 or higher") }
            Li { Text("🤖 Android SDK (for Android development)") }
            Li { Text("🍎 Xcode (for iOS development, macOS only)") }
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
            Text("Follow these steps to get your MaleficMobile project up and running:")
        }
    }
    
    Section {
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Text("Step 1: Clone the Template")
        }
        Pre(attrs = { 
            style { 
                backgroundColor(Color("#f4f4f4"))
                padding(1.cssRem)
                borderRadius(0.5.cssRem)
                property("overflow", "auto")
            } 
        }) {
            Code { Text("git clone https://github.com/OmyDaGreat/MaleficMobile.git") }
        }
        
        H2(attrs = { 
            style { 
                fontSize(2.cssRem)
                fontWeight("bold")
                marginTop(2.cssRem)
                marginBottom(1.cssRem)
            } 
        }) {
            Text("Step 2: Open in IDE")
        }
        P(attrs = { style { lineHeight("1.6") } }) {
            Text("Open the cloned project in IntelliJ IDEA or Android Studio and let it sync the Gradle dependencies.")
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
            Text("Understanding the project layout and organization:")
        }
    }
    
    Section {
        P { Text("Detailed project structure documentation is being migrated...") }
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
            Text("Practical code examples to help you get started:")
        }
    }
    
    Section {
        P { Text("Code examples are being migrated...") }
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
            Text("Need help? Here are the best resources:")
        }
    }
    
    Section {
        Ul(attrs = { 
            style { 
                lineHeight("1.8")
                fontSize(1.1.cssRem)
            } 
        }) {
            Li { Text("🐛 Report issues on GitHub") }
            Li { Text("💬 Join the community discussions") }
            Li { Text("📖 Check the official Kotlin Multiplatform docs") }
        }
    }
}