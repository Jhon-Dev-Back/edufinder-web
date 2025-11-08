/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


  function openModalAdmin() {
        document.getElementById("modal_admin").style.display = "block";
    }

    function closeModalAdmin() {
        document.getElementById("modal_admin").style.display = "none";
    }

    // Opcional: cerrar modal si se hace clic fuera
    window.onclick = function(event) {
        const modal = document.getElementById("modal_admin");
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
    
    function abrirModalSiCompletadoAd(data) {
    if (data.status === 'success') {
        openModalAdmin(); // Tu función ya existente para mostrar el modal
    }
}
    
      function openModalPro() {
        document.getElementById("modales").style.display = "block";
    }

    function closeModalPro() {
        document.getElementById("modales").style.display = "none";
    }

    // Opcional: cerrar modal si se hace clic fuera
    window.onclick = function(event) {
        const modal = document.getElementById("modales");
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }