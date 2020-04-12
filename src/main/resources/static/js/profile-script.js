
/*function proJoFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

function validateForm() {
    var x = document.forms["personal"]["name"].value;
    if (x == "") {
        alert("Name must be filled out.");
        return false;
    }
}*/

const body = document.body;
const menuLinks = document.querySelectorAll(".user-menu a");
const collapseBtn = document.querySelector(".user-menu .collapse-btn");
const toggleMenu = document.querySelector(".toggle-menu");
const collapsedClass = "collapse";

collapseBtn.addEventListener("click", function () {
    this.getAttribute("aria-expanded") == "true"
        ? this.setAttribute("aria-expanded", "false")
        : this.setAttribute("aria-expanded", "true");
    this.setAttribute("aria-label") == "collapse menu"
        ? this.setAttribute("aria-label", "expand menu")
        : this.setAttribute("aria-label", "collapse menu");
    body.classList.toggle(collapsedClass);
});

toggleMenu.addEventListener("click", function () {
    this.getAttribute("aria-expanded") == "true"
        ? this.setAttribute("aria-expanded", "false")
        : this.setAttribute("aria-expanded", "true");
    this.getAttribute("aria-label") == "open menu"
        ? this.setAttribute("aria-label", "close menu")
        : this.setAttribute("aria-label", "open menu");
    body.classList.toggle("menu-opened");
});

for (const link of menuLinks) {
    link.addEventListener("mouseenter", function () {
        body.classList.contains(collapsedClass) &&
            window.matchMedia("(min-width: 768px)").matches
            ? this.setAttribute("title", this.textContent)
            : this.removeAttribute("title");
    });
}
