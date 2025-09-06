# MaleficMobile Documentation Site

This directory contains the documentation website for MaleficMobile, built with **Compose HTML**.

## 🚀 Quick Start

### Local Development
```bash
# From the project root
./docs-dev.sh serve
```

This will:
1. Build the documentation using Gradle
2. Start a local development server
3. Open the site at http://localhost:8080

### Available Commands

```bash
./docs-dev.sh build    # Build documentation only
./docs-dev.sh watch    # Watch for changes and rebuild
./docs-dev.sh clean    # Clean build artifacts
./docs-dev.sh info     # Show build information
./docs-dev.sh help     # Show help
```

## 🏗️ Technology Stack

- **Framework**: Compose HTML (Kotlin/JS)
- **Build Tool**: Gradle with Kotlin DSL
- **Styling**: CSS-in-Kotlin with Compose Web CSS API
- **Deployment**: GitHub Pages with automated builds

## 📁 Project Structure

```
docs-site/
├── src/jsMain/
│   ├── kotlin/com/maleficmobile/docs/
│   │   └── Main.kt              # Main application logic
│   └── resources/
│       └── index.html           # HTML template
├── build.gradle.kts             # Build configuration
└── README.md                    # This file
```

## 🎨 Features

- **Responsive Design**: Mobile-first approach with desktop enhancements
- **Interactive Navigation**: Single-page application with smooth section switching
- **Modern Styling**: Professional gradient themes and typography
- **Code Syntax Highlighting**: Readable code examples with proper formatting
- **Accessible**: Semantic HTML and proper contrast ratios

## 🔧 Development

### Making Changes

1. Edit source files in `src/jsMain/kotlin/`
2. Run `./docs-dev.sh build` to rebuild
3. Or use `./docs-dev.sh watch` for automatic rebuilds

### Adding Content

The documentation content is defined in the Kotlin source file. To add new sections:

1. Add a new function for your content (e.g., `MyNewSection()`)
2. Add navigation item in the sidebar
3. Add case in the `when` statement in `Main.kt`

### Styling

Styles are defined using Compose Web CSS API in the `Style` block. The design uses:
- Professional gradients (purple to blue)
- Modern typography (system fonts)
- Responsive grid layouts
- Smooth transitions and hover effects

## 🚀 Deployment

The site is automatically deployed to GitHub Pages when changes are pushed to the `main` branch.

### Manual Deployment

```bash
# Build for production
./gradlew :docs-site:jsBrowserProductionWebpack

# Files will be in build/distributions/
```

## 🧪 Testing

```bash
# Build and test locally
./docs-dev.sh serve

# Check build artifacts
./docs-dev.sh info

# Clean and rebuild
./docs-dev.sh clean && ./docs-dev.sh build
```

## 💡 Tips

- The site is a single-page application with client-side navigation
- All content is bundled into a single JavaScript file for fast loading
- The design is mobile-first and works well on all screen sizes
- Code examples use monospace fonts and proper syntax highlighting

## 📖 Content Coverage

The documentation includes:

- **Getting Started**: Step-by-step setup instructions for complete beginners
- **Prerequisites**: Detailed requirements and installation guides
- **Project Structure**: In-depth explanation of the KMP project layout
- **Customization**: How to personalize your app (name, icon, theme, screens)
- **Code Examples**: Ready-to-use code snippets for common patterns
- **Advanced Topics**: Navigation, state management, dependency injection
- **Troubleshooting**: FAQ and common issue resolution

## 🎯 Target Audience

This documentation is specifically designed for:

- **Complete Beginners**: New to Kotlin Multiplatform or mobile development
- **UI Developers**: Familiar with mobile development but new to KMP
- **Quick Starters**: Developers who want to get up and running fast