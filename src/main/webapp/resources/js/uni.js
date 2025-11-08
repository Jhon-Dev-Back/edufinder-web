

function openModal() {
   const modal = document.getElementById('modales').style.display = 'block';
    modal.style.display = 'block';
    const content = modal.querySelector('.modal-content');
    if (content)
        content.scrollTop = 0;
}

function abrirModalSiCompletado(data) {
    if (data.status === 'success') {
        openModal(); // Tu función ya existente para mostrar el modal
    }
}

// Cerrar modal
function closeModal() {
    document.getElementById('modales').style.display = 'none';
    const form = document.getElementById('modalForm');
    if (form) {
        form.reset();
    }
}


let tablaUniversidade;

$(document).ready(function () {
    tablaUniversidade = $('.jsf-data-table').DataTable({
        dom: 'Bfrtip',
        language: {
            url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json"
        },
        pageLength: 50,
        buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
    });
});
