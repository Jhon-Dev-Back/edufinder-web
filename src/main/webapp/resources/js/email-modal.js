function openEmailModal() {
    const modal = document.querySelector(".cont-email");
    modal.style.display = "flex";
    localStorage.setItem("modalOpen", "true");

    const checkboxes = document.querySelectorAll(".user-checkbox:checked");
    const correos = Array.from(checkboxes).map(cb => cb.value);

  
    const destinatariosInput = document.querySelector('[id$="destinatarios"]');
    if (destinatariosInput) {
        destinatariosInput.value = correos.join(", ");
    }
}

function closeEmailModal() {
    const modal = document.querySelector(".cont-email");
    modal.style.display = "none";
    localStorage.setItem("modalOpen", "false");
}

// Cierra si hacen clic fuera del modal
window.onclick = function (event) {
    const modal = document.querySelector(".cont-email");
    if (event.target === modal) {
        closeEmailModal();
    }
}




