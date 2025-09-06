#!/bin/bash

# MaleficMobile Documentation Development Helper
# This script helps with local development of the documentation site

set -e

DOCS_DIR="docs-site"
PORT=8080

echo "🚀 MaleficMobile Documentation Helper"
echo "====================================="

# Check if we're in the right directory
if [ ! -d "$DOCS_DIR" ]; then
    echo "❌ Error: docs-site directory not found"
    echo "Please run this script from the MaleficMobile root directory"
    exit 1
fi

# Function to start local server
start_server() {
    echo "🌟 Starting local documentation server..."
    cd "$DOCS_DIR"
    
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

# Function to validate HTML
validate_html() {
    echo "🔍 Validating HTML structure..."
    if command -v xmllint &> /dev/null; then
        xmllint --html --noout "$DOCS_DIR/index.html" 2>/dev/null && echo "✅ HTML is valid" || echo "⚠️ HTML validation warnings"
    else
        echo "⚠️ xmllint not found, skipping HTML validation"
    fi
}

# Function to check for broken links (basic)
check_links() {
    echo "🔗 Checking internal links..."
    if command -v grep &> /dev/null; then
        echo "Checking for internal anchor links..."
        grep -o 'href="#[^"]*"' "$DOCS_DIR/index.html" | sort | uniq
    fi
}

# Function to optimize images (if any exist)
optimize_images() {
    echo "🖼️ Checking for images to optimize..."
    if [ -d "$DOCS_DIR/images" ]; then
        find "$DOCS_DIR/images" -name "*.png" -o -name "*.jpg" -o -name "*.jpeg" | while read -r image; do
            echo "Found image: $image"
        done
    else
        echo "📁 No images directory found - create one when adding screenshots"
    fi
}

# Function to show help
show_help() {
    echo "Usage: $0 [command]"
    echo ""
    echo "Commands:"
    echo "  serve     Start local development server (default)"
    echo "  validate  Validate HTML structure"
    echo "  links     Check internal links"
    echo "  images    Check and optimize images"
    echo "  help      Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0                  # Start development server"
    echo "  $0 serve            # Start development server"
    echo "  $0 validate         # Validate HTML"
    echo "  $0 links            # Check links"
}

# Main logic
case "${1:-serve}" in
    "serve")
        start_server
        ;;
    "validate")
        validate_html
        ;;
    "links")
        check_links
        ;;
    "images")
        optimize_images
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