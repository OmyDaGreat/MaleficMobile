#!/bin/bash

# MaleficMobile Documentation Development Helper
# This script helps with local development of the Compose HTML documentation site

set -e

DOCS_DIR="docs-site"
PORT=8080
BUILD_DIR="build/distributions"

echo "🚀 MaleficMobile Documentation Helper (Compose HTML)"
echo "===================================================="

# Check if we're in the right directory
if [ ! -d "$DOCS_DIR" ]; then
    echo "❌ Error: docs-site directory not found"
    echo "Please run this script from the MaleficMobile root directory"
    exit 1
fi

# Function to build the documentation
build_docs() {
    echo "🔨 Building documentation with Gradle..."
    ./gradlew :docs-site:jsBrowserDevelopmentWebpack
    echo "✅ Documentation built successfully"
}

# Function to start local server
start_server() {
    echo "🌟 Building and starting local documentation server..."
    
    # Build first
    build_docs
    
    # Navigate to the built documentation
    cd "$DOCS_DIR/$BUILD_DIR"
    
    # Try different methods to start a local server
    if command -v python3 &> /dev/null; then
        echo "📡 Using Python 3 HTTP server on port $PORT"
        echo "🌐 Open http://localhost:$PORT in your browser"
        echo "📝 Press Ctrl+C to stop the server"
        python3 -m http.server $PORT
    elif command -v python &> /dev/null; then
        echo "📡 Using Python 2 HTTP server on port $PORT"
        echo "🌐 Open http://localhost:$PORT in your browser"
        echo "📝 Press Ctrl+C to stop the server"
        python -m SimpleHTTPServer $PORT
    elif command -v php &> /dev/null; then
        echo "📡 Using PHP built-in server on port $PORT"
        echo "🌐 Open http://localhost:$PORT in your browser"
        echo "📝 Press Ctrl+C to stop the server"
        php -S localhost:$PORT
    elif command -v ruby &> /dev/null; then
        echo "📡 Using Ruby WEBrick server on port $PORT"
        echo "🌐 Open http://localhost:$PORT in your browser"
        echo "📝 Press Ctrl+C to stop the server"
        ruby -run -e httpd . -p $PORT
    else
        echo "❌ No suitable HTTP server found"
        echo "Please install Python, PHP, or Ruby to run a local server"
        echo "Alternatively, use any other static file server of your choice"
        exit 1
    fi
}

# Function to watch and rebuild
watch_docs() {
    echo "👀 Starting watch mode..."
    echo "🔄 This will rebuild documentation when source files change"
    echo "📝 Press Ctrl+C to stop watching"
    
    # Simple file watching (requires inotify-tools on Linux)
    if command -v inotifywait &> /dev/null; then
        while true; do
            inotifywait -r -e modify,create,delete "$DOCS_DIR/src" && {
                echo "🔄 Changes detected, rebuilding..."
                build_docs
            }
        done
    else
        echo "⚠️ File watching not available (install inotify-tools on Linux)"
        echo "💡 Manually run '$0 build' after making changes"
    fi
}

# Function to clean build artifacts
clean_build() {
    echo "🧹 Cleaning build artifacts..."
    ./gradlew :docs-site:clean
    echo "✅ Build artifacts cleaned"
}

# Function to show build info
show_build_info() {
    echo "📊 Documentation Build Information:"
    echo "=====================================:"
    echo "Source directory: $DOCS_DIR/src"
    echo "Build directory: $DOCS_DIR/$BUILD_DIR"
    echo "Kotlin/JS target: Browser"
    echo "Framework: Compose HTML"
    
    if [ -f "$DOCS_DIR/$BUILD_DIR/index.html" ]; then
        echo "✅ Documentation is built"
        echo "📂 Built files:"
        ls -la "$DOCS_DIR/$BUILD_DIR/"
    else
        echo "❌ Documentation not built yet"
        echo "💡 Run '$0 build' to build the documentation"
    fi
}

# Function to show help
show_help() {
    echo "Usage: $0 [command]"
    echo ""
    echo "Commands:"
    echo "  serve     Build and start local development server (default)"
    echo "  build     Build documentation only"
    echo "  watch     Watch for changes and rebuild automatically"
    echo "  clean     Clean build artifacts"
    echo "  info      Show build information"
    echo "  help      Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0                  # Build and start development server"
    echo "  $0 serve            # Build and start development server"
    echo "  $0 build            # Build documentation only"
    echo "  $0 watch            # Watch and rebuild on changes"
    echo "  $0 clean            # Clean build artifacts"
}

# Main logic
case "${1:-serve}" in
    "serve")
        start_server
        ;;
    "build")
        build_docs
        ;;
    "watch")
        watch_docs
        ;;
    "clean")
        clean_build
        ;;
    "info")
        show_build_info
        ;;
    "help"|"--help"|"-h")
        show_help
        ;;
    *)
        echo "❌ Unknown command: $1"
        show_help
        exit 1
        ;;
esac