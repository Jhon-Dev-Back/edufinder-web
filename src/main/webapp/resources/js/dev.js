    /* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
    $('.jsf-data-tables').DataTable({
        dom: 'Bfrtip', 
        language: {
            url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json"
        },
        pageLength: 50,
        buttons: [
            {
                extend: 'copy',
                text: 'Copiar',
                className: 'btn btn-copy',
                exportOptions: {
                     columns: [1, 2, 3, 4, 5] 
                }
            },
            {
                extend: 'csv',
                text: 'CSV',
                className: 'btn btn-info',
                exportOptions: {
                    columns: [1, 2, 3, 4, 5]  
                }
            },
            {
                extend: 'excel',
                text: 'Excel',
                className: 'btn btn-success',
                exportOptions: {
                     columns: [1, 2, 3, 4, 5]
                }
            },
            {
                extend: 'pdf',
                text: 'PDF',
                className: 'btn btn-danger',
                exportOptions: {
                    columns: [1, 2, 3, 4, 5] 
                },
                customize: function (doc) {
                    doc.pageMargins = [20, 20, 20, 20];
                    doc.defaultStyle.fontSize = 10;
                    doc.styles.tableHeader.fontSize = 12;
                }   
            },
            {
                extend: 'print',
                text: 'Imprimir',
                className: 'btn btn-imp',
                exportOptions: {
                    columns: [1, 2, 3, 4, 5] 
                }
            }
        ]
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const eliminarBtns = document.querySelectorAll('.closeSesion');

    eliminarBtns.forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            Swal.fire({
                title: '¿Estás seguro?',
                text: "¡No podrás revertir esta acción!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#efb810',
                cancelButtonColor: '#3085d6',
                confirmButtonText: 'Sí, Salir',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    btn.closest('form').submit(); // 🔑 submit manual del form JSF
                }
            });
        });
    });
});
