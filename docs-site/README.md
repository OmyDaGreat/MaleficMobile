# MaleficMobile Documentation

This directory contains a comprehensive documentation website for the MaleficMobile Kotlin Multiplatform template.

## 📖 What's Included

The documentation covers:

- **Getting Started**: Step-by-step setup instructions for complete beginners
- **Prerequisites**: Detailed requirements and installation guides
- **Project Structure**: In-depth explanation of the KMP project layout
- **Customization**: How to personalize your app (name, icon, theme, screens)
- **Code Examples**: Ready-to-use code snippets for common patterns
- **Advanced Topics**: Navigation, state management, dependency injection
- **Troubleshooting**: FAQ and common issue resolution

## 🎨 Design Features

- **Modern UI**: Clean, professional design inspired by popular documentation sites
- **Responsive**: Works perfectly on desktop, tablet, and mobile devices
- **Interactive**: Expandable sections, tabbed examples, and smooth navigation
- **Code Highlighting**: Syntax-highlighted code blocks with copy buttons
- **Progressive Enhancement**: Works without JavaScript but enhanced with it

## 🚀 Local Development

To run the documentation locally:

```bash
cd docs-site
python3 -m http.server 8080
```

Then open http://localhost:8080 in your browser.

## 📁 Structure

```
docs-site/
├── index.html              # Main documentation page
├── styles/
│   └── main.css            # All styling (responsive, modern)
├── js/
│   └── main.js             # Interactive features
├── visual-guide.html       # Example of visual guide structure
└── README.md               # This file
```

## 🎯 Target Audience

This documentation is specifically designed for:

- **Complete Beginners**: New to Kotlin Multiplatform or mobile development
- **UI Developers**: Familiar with mobile development but new to KMP
- **Quick Starters**: Developers who want to get up and running fast

## 🔧 Deployment

The documentation is set up to deploy automatically to GitHub Pages when changes are pushed to the main branch. See `.github/workflows/deploy-docs.yml` for the deployment configuration.

## 📝 Contributing

To improve the documentation:

1. Edit the HTML content in `index.html`
2. Modify styles in `styles/main.css`
3. Add interactive features in `js/main.js`
4. Test locally before committing

## 🖼️ Adding Visual Content

The documentation is designed to include screenshots and diagrams. To add visual content:

1. Create an `images/` directory
2. Add screenshots of:
   - IDE setup process
   - Emulator configuration
   - Running app examples
   - Code editor views
   - Build processes

3. Update the HTML to reference the images
4. Ensure images are optimized for web (WebP format recommended)

## 📋 TODO / Future Enhancements

- [ ] Add actual screenshots for all setup steps
- [ ] Create animated GIFs for complex processes
- [ ] Add search functionality
- [ ] Implement dark mode toggle
- [ ] Add print-friendly styles
- [ ] Create PDF export option
- [ ] Add multi-language support
- [ ] Integrate with project's actual code examples

## 📄 License

This documentation is part of the MaleficMobile project and follows the same MIT license.