document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('loginForm');
    const btn = form.querySelector('input[type="submit"]');

    btn.addEventListener('click', function (e) {
        const usuario = form.querySelector('#loginForm\\:login-username').value.trim();
        const email = form.querySelector('#loginForm\\:login-email').value.trim();
        const clave = form.querySelector('#loginForm\\:login-password').value.trim();

        if (usuario === '' || clave === '' || email === '') {
            e.preventDefault(); // evita que se envíe el formulario
            Swal.fire({
                icon: 'warning',
                title: 'Campos vacíos',
                text: 'Por favor, complete todos los campos antes de continuar.',
                confirmButtonColor: '#f00'
            });
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('registroForm');
    const btn = form.querySelector('input[type="submit"]');


    btn.addEventListener('click', function (e) {
        const nombre = form.querySelector('#registroForm\\:nombre').value.trim();
        const primerA = form.querySelector('#registroForm\\:primerA').value.trim();
        const segundoA = form.querySelector('#registroForm\\:segundoA').value.trim();
        const usuario = form.querySelector('#registroForm\\:usuario').value.trim();
        const edad = form.querySelector('#registroForm\\:edad').value.trim();
        const numeroDocumento = form.querySelector('#registroForm\\:numeroDocumento').value.trim();
        const email = form.querySelector('#registroForm\\:email').value.trim();
        const clave = form.querySelector('#registroForm\\:contraseña').value.trim();

        if (nombre === '' || primerA === '' || segundoA === '' || usuario === '' ||
            edad === '' || numeroDocumento === '' || email === '' || clave === '') {
            
            e.preventDefault(); // detiene envío
            Swal.fire({
                icon: 'warning',
                title: 'Campos vacíos',
                text: 'Por favor, complete todos los campos antes de continuar.',
                confirmButtonColor: '#f00'
            });
          
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const eliminarBtns = document.querySelectorAll('.btn-elim');

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
                confirmButtonText: 'Sí, eliminar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    btn.closest('form').submit(); // 🔑 submit manual del form JSF
                }
            });
        });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const edits = document.querySelectorAll('#edits');

    edits.forEach(btn => {
        btn.addEventListener('click', function (e) {
            e.preventDefault();
            Swal.fire({
                title: '¿Estás seguro?',
                text: "¡No podrás revertir esta acción!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#efb810',
                cancelButtonColor: '#3085d6',
                confirmButtonText: 'Sí, Editar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    btn.closest('form').submit();
                }
            });
        });
    });
});

