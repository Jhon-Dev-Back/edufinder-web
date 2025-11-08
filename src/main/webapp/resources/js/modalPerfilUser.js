/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

 function openModalContraseña() {
        document.getElementById("change").style.display = "block";
    }

    // Función para cerrar el modal
    function closeModalContraseña() {
        document.getElementById("change").style.display = "none";
    }

    // Cerrar si se hace clic fuera del contenido
    window.onclick = function(event) {
        var modal = document.getElementById("change");
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }

function confirmarCerrarSesion() {
    return Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás revertir esta acción!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#efb810',
        cancelButtonColor: '#3085d6',
        confirmButtonText: 'Sí, salir',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        return result.isConfirmed; 
    });
}


