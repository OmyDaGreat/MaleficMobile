// Navigation functionality
document.addEventListener('DOMContentLoaded', function() {
    // Smooth scrolling for navigation links
    const navLinks = document.querySelectorAll('.nav-link');
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const targetId = this.getAttribute('href');
            const targetElement = document.querySelector(targetId);
            
            if (targetElement) {
                // Update active nav link
                navLinks.forEach(nav => nav.classList.remove('active'));
                this.classList.add('active');
                
                // Smooth scroll to target
                targetElement.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
                
                // Update URL hash
                history.pushState(null, null, targetId);
            }
        });
    });

    // Update active nav link based on scroll position
    const sections = document.querySelectorAll('.section');
    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const id = entry.target.getAttribute('id');
                    const activeLink = document.querySelector(`a[href="#${id}"]`);
                    if (activeLink) {
                        navLinks.forEach(nav => nav.classList.remove('active'));
                        activeLink.classList.add('active');
                    }
                }
            });
        },
        { threshold: 0.3 }
    );

    sections.forEach(section => {
        observer.observe(section);
    });

    // Set active nav link on page load based on hash
    const hash = window.location.hash;
    if (hash) {
        const activeLink = document.querySelector(`a[href="${hash}"]`);
        if (activeLink) {
            navLinks.forEach(nav => nav.classList.remove('active'));
            activeLink.classList.add('active');
        }
    }
});

// Expandable sections functionality
function toggleSection(sectionId) {
    const section = document.getElementById(sectionId);
    const button = section.previousElementSibling;
    const icon = button.querySelector('i');
    
    if (section.style.display === 'none' || section.style.display === '') {
        section.style.display = 'block';
        icon.style.transform = 'rotate(90deg)';
        button.classList.add('expanded');
    } else {
        section.style.display = 'none';
        icon.style.transform = 'rotate(0deg)';
        button.classList.remove('expanded');
    }
}

// Example tabs functionality
function showExample(exampleId) {
    // Hide all examples
    const examples = document.querySelectorAll('.example-content');
    examples.forEach(example => {
        example.classList.remove('active');
    });
    
    // Remove active state from all tab buttons
    const tabButtons = document.querySelectorAll('.tab-btn');
    tabButtons.forEach(btn => {
        btn.classList.remove('active');
    });
    
    // Show selected example
    const selectedExample = document.getElementById(exampleId + '-example');
    if (selectedExample) {
        selectedExample.classList.add('active');
    }
    
    // Add active state to clicked tab button
    const activeTab = document.querySelector(`button[onclick="showExample('${exampleId}')"]`);
    if (activeTab) {
        activeTab.classList.add('active');
    }
}

// FAQ functionality
function toggleFaq(faqId) {
    const answer = document.getElementById(faqId);
    const question = answer.previousElementSibling;
    const icon = question.querySelector('i');
    
    if (answer.style.display === 'none' || answer.style.display === '') {
        answer.style.display = 'block';
        icon.style.transform = 'rotate(180deg)';
        question.classList.add('expanded');
    } else {
        answer.style.display = 'none';
        icon.style.transform = 'rotate(0deg)';
        question.classList.remove('expanded');
    }
}

// Copy code functionality
document.addEventListener('DOMContentLoaded', function() {
    // Add copy button to code blocks
    const codeBlocks = document.querySelectorAll('.code-block');
    codeBlocks.forEach(block => {
        const copyButton = document.createElement('button');
        copyButton.className = 'copy-btn';
        copyButton.innerHTML = '<i class="fas fa-copy"></i> Copy';
        copyButton.style.cssText = `
            position: absolute;
            top: 12px;
            right: 12px;
            background: rgba(255, 255, 255, 0.1);
            color: #e2e8f0;
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 4px;
            padding: 4px 8px;
            font-size: 12px;
            cursor: pointer;
            transition: background 0.2s ease;
        `;
        
        block.style.position = 'relative';
        block.appendChild(copyButton);
        
        copyButton.addEventListener('click', function() {
            const code = block.querySelector('code').textContent;
            navigator.clipboard.writeText(code).then(function() {
                copyButton.innerHTML = '<i class="fas fa-check"></i> Copied!';
                setTimeout(() => {
                    copyButton.innerHTML = '<i class="fas fa-copy"></i> Copy';
                }, 2000);
            });
        });
        
        copyButton.addEventListener('mouseenter', function() {
            copyButton.style.background = 'rgba(255, 255, 255, 0.2)';
        });
        
        copyButton.addEventListener('mouseleave', function() {
            copyButton.style.background = 'rgba(255, 255, 255, 0.1)';
        });
    });
});

// Mobile navigation toggle
document.addEventListener('DOMContentLoaded', function() {
    // Create mobile menu toggle button
    const mobileToggle = document.createElement('button');
    mobileToggle.className = 'mobile-nav-toggle';
    mobileToggle.innerHTML = '<i class="fas fa-bars"></i>';
    mobileToggle.style.cssText = `
        position: fixed;
        top: 1rem;
        left: 1rem;
        z-index: 1001;
        background: #667eea;
        color: white;
        border: none;
        border-radius: 6px;
        padding: 12px;
        font-size: 18px;
        cursor: pointer;
        display: none;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    `;
    
    document.body.appendChild(mobileToggle);
    
    // Show/hide mobile toggle based on screen size
    function checkScreenSize() {
        if (window.innerWidth <= 1024) {
            mobileToggle.style.display = 'block';
        } else {
            mobileToggle.style.display = 'none';
            document.querySelector('.sidebar').classList.remove('open');
        }
    }
    
    checkScreenSize();
    window.addEventListener('resize', checkScreenSize);
    
    // Toggle mobile navigation
    mobileToggle.addEventListener('click', function() {
        const sidebar = document.querySelector('.sidebar');
        sidebar.classList.toggle('open');
        
        // Change icon
        const icon = mobileToggle.querySelector('i');
        if (sidebar.classList.contains('open')) {
            icon.className = 'fas fa-times';
        } else {
            icon.className = 'fas fa-bars';
        }
    });
    
    // Close mobile nav when clicking outside
    document.addEventListener('click', function(e) {
        const sidebar = document.querySelector('.sidebar');
        if (!sidebar.contains(e.target) && !mobileToggle.contains(e.target)) {
            sidebar.classList.remove('open');
            mobileToggle.querySelector('i').className = 'fas fa-bars';
        }
    });
    
    // Close mobile nav when clicking on nav link
    const mobileNavLinks = document.querySelectorAll('.nav-link');
    mobileNavLinks.forEach(link => {
        link.addEventListener('click', function() {
            if (window.innerWidth <= 1024) {
                const sidebar = document.querySelector('.sidebar');
                sidebar.classList.remove('open');
                mobileToggle.querySelector('i').className = 'fas fa-bars';
            }
        });
    });
});

// Search functionality (if needed in the future)
function initializeSearch() {
    // This can be implemented later for searching through documentation
    console.log('Search functionality can be added here');
}

// Scroll to top functionality
document.addEventListener('DOMContentLoaded', function() {
    // Create scroll to top button
    const scrollTopBtn = document.createElement('button');
    scrollTopBtn.className = 'scroll-top-btn';
    scrollTopBtn.innerHTML = '<i class="fas fa-arrow-up"></i>';
    scrollTopBtn.style.cssText = `
        position: fixed;
        bottom: 2rem;
        right: 2rem;
        z-index: 1000;
        background: #667eea;
        color: white;
        border: none;
        border-radius: 50%;
        width: 50px;
        height: 50px;
        font-size: 18px;
        cursor: pointer;
        opacity: 0;
        visibility: hidden;
        transition: all 0.3s ease;
        box-shadow: 0 4px 12px rgba(102, 126, 234, 0.3);
    `;
    
    document.body.appendChild(scrollTopBtn);
    
    // Show/hide scroll to top button
    window.addEventListener('scroll', function() {
        if (window.pageYOffset > 500) {
            scrollTopBtn.style.opacity = '1';
            scrollTopBtn.style.visibility = 'visible';
        } else {
            scrollTopBtn.style.opacity = '0';
            scrollTopBtn.style.visibility = 'hidden';
        }
    });
    
    // Scroll to top when clicked
    scrollTopBtn.addEventListener('click', function() {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    });
    
    // Hover effects
    scrollTopBtn.addEventListener('mouseenter', function() {
        scrollTopBtn.style.background = '#5a67d8';
        scrollTopBtn.style.transform = 'scale(1.1)';
    });
    
    scrollTopBtn.addEventListener('mouseleave', function() {
        scrollTopBtn.style.background = '#667eea';
        scrollTopBtn.style.transform = 'scale(1)';
    });
});

// Analytics (placeholder for future implementation)
function trackEvent(category, action, label) {
    // Google Analytics or other tracking can be implemented here
    console.log('Event tracked:', category, action, label);
}

// Performance monitoring
document.addEventListener('DOMContentLoaded', function() {
    // Log page load time
    window.addEventListener('load', function() {
        const loadTime = performance.now();
        console.log(`Documentation page loaded in ${Math.round(loadTime)}ms`);
    });
});

// Keyboard navigation
document.addEventListener('keydown', function(e) {
    // Press 'Ctrl + /' to focus search (if implemented)
    if (e.ctrlKey && e.key === '/') {
        e.preventDefault();
        console.log('Search shortcut triggered');
    }
    
    // Press 'Escape' to close mobile nav
    if (e.key === 'Escape') {
        const sidebar = document.querySelector('.sidebar');
        const mobileToggle = document.querySelector('.mobile-nav-toggle');
        if (sidebar && sidebar.classList.contains('open')) {
            sidebar.classList.remove('open');
            if (mobileToggle) {
                mobileToggle.querySelector('i').className = 'fas fa-bars';
            }
        }
    }
});

console.log('MaleficMobile Documentation - Interactive features loaded');