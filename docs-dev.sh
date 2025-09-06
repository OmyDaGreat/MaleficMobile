#!/bin/bash

# MaleficMobile Documentation Development Helper
# This script helps with local development of the Kobweb documentation site

set -e

DOCS_DIR="docs-site"
PORT=8080

echo "🚀 MaleficMobile Documentation Helper (Kobweb)"
echo "=============================================="

# Check if we're in the right directory
if [ ! -d "$DOCS_DIR" ]; then
    echo "❌ Error: docs-site directory not found"
    echo "Please run this script from the MaleficMobile root directory"
    exit 1
fi

# Function to build the documentation
build_docs() {
    echo "🔨 Building documentation with Kobweb..."
    cd "$DOCS_DIR"
    ../gradlew kobwebExport
    cd ..
    echo "✅ Documentation built successfully"
}

# Function to start local development server
start_server() {
    echo "🌟 Starting local Kobweb development server..."
    
    cd "$DOCS_DIR"
    echo "📡 Starting Kobweb server on port $PORT"
    echo "🌐 Open http://localhost:$PORT in your browser"
    echo "📝 Press Ctrl+C to stop the server"
    ../gradlew kobwebRun --continuous
    cd ..
}

# Function to watch and rebuild (Kobweb has built-in watching)
watch_docs() {
    echo "👀 Starting Kobweb watch mode..."
    echo "🔄 This will rebuild documentation when source files change"
    echo "📝 Press Ctrl+C to stop watching"
    
    cd "$DOCS_DIR"
    ../gradlew kobwebRun --continuous
    cd ..
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
    echo "==================================="
    echo "Source directory: $DOCS_DIR/src"
    echo "Config directory: $DOCS_DIR/.kobweb"
    echo "Framework: Kobweb"
    
    if [ -d "$DOCS_DIR/.kobweb/site" ]; then
        echo "✅ Documentation is built"
        echo "📂 Built files in: $DOCS_DIR/.kobweb/site"
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
    echo "  serve     Start local Kobweb development server (default)"
    echo "  build     Build documentation only"
    echo "  watch     Start development server with auto-reload"
    echo "  clean     Clean build artifacts"
    echo "  info      Show build information"
    echo "  help      Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0                  # Start development server"
    echo "  $0 serve            # Start development server"
    echo "  $0 build            # Build documentation only"
    echo "  $0 watch            # Start with auto-reload"
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