/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.addEventListener("load", function () {
    let rawData = document.getElementById("form:usuariosPorRolData").value;
    let data = JSON.parse(rawData);

    let labels = data.map(item => item.rol);
    let values = data.map(item => item.cantidad);
    const backgroundColorsRole = ['#4bc0c0', '#ff6384', '#c9cbcf', '#ff8a80', '#2ecc71']


    new Chart(document.getElementById("usuariosPorRolChart"), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Usuarios',
                    data: values,
                    backgroundColor: backgroundColorsRole.slice(0, values.length),
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
        },
        options: {
            responsive: true,
            plugins: {
                title: {
                    display: true,
                    text: 'Usuarios Registrados por Rol',
                    color: '#1F2937',
                    font: {
                        size: 20,
                        weight: 'bold'
                    }
                },
                legend: {
                    labels: {
                        color: '#36a2eb',
                        font: {
                            weight: 'bold',
                            size: 14
                        }
                    }
                },
                tooltip: {
                    titleColor: '#36a2eb',
                    bodyColor: '#36a2eb'   
                }
            },
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});

window.addEventListener("load", function () {
    let rawData = document.getElementById("formedad:usuariosPorEdad").value;
    let data = JSON.parse(rawData);

    let labels = data.map(item => item.edad);
    let values = data.map(item => item.cantidad);
    const backgroundColorsRole = [
        '#5AD3D1',
        '#FF7394',
        '#D3D6D9',
        '#FF9AA2',
        '#27AE60'
    ];


    new Chart(document.getElementById("usuariosPorEdadChart"), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Edades',
                    data: values,
                    backgroundColor: backgroundColorsRole.slice(0, values.length),
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
        },
        options: {
            responsive: true,
             indexAxis: 'y',
            plugins: {
                title: {
                    display: true,
                    text: 'Usuarios Registrados por Edad',
                    color: '#1F2937',
                    font: {
                        size: 20,
                        weight: 'bold'
                    }
                },
                legend: {
                    labels: {
                        color: '#36a2eb',
                        font: {
                            weight: 'bold',
                            size: 14
                        }
                    }
                },
                tooltip: {
                    titleColor: '#36a2eb', // Color del título del tooltip
                    bodyColor: '#36a2eb'   // Color del cuerpo del tooltip
                }
            },
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});


window.addEventListener("load", function () {
    let rawData = document.getElementById("formesp:usuariosPorEspecialidad").value;
    let data = JSON.parse(rawData);

    let labels = data.map(item => item.especialidad);
    let values = data.map(item => item.cantidad);


    const backgroundColorsEspe = ['#36a2eb', '#ffcd56', '#9966ff', '#ff9f40', ' #1c6cc2'];

    new Chart(document.getElementById("usuariosPorEspecialidadChart"), {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Usuarios  por Especialidad',
                    data: values,
                    backgroundColor: backgroundColorsEspe.slice(0, values.length),
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
        },
        options: {
            responsive: true,
            plugins: {
                title: {
                    display: true,
                    text: 'Usuarios Registrados por Especialidad',
                    color: '#1F2937',
                    font: {
                        size: 20,
                        weight: 'bold'
                    }
                },
                legend: {
                    labels: {
                        color: '#36a2eb',
                        font: {
                            weight: 'bold',
                            size: 14
                        }
                    }
                },
                tooltip: {
                    titleColor: '#36a2eb',
                    bodyColor: '#36a2eb'   
                }
            },
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});



window.addEventListener("load", function () {
    let rawData = document.getElementById("formciu:UniverPorCiudad").value;
    let data = JSON.parse(rawData);

    let labels = data.map(item => item.ciudades);
    let values = data.map(item => item.cantidad);


    const backgroundColorsCiud = ['#36a2eb', '#ffcd56', '#9966ff', '#ff9f40', ' #1c6cc2'];

 new Chart(document.getElementById("UniverPorCiudadChart"), {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Universidades',
                    data: values,
                    backgroundColor: backgroundColorsCiud.slice(0, values.length),
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
        },
        options: {
            responsive: true,
            plugins: {
                title: {
                    display: true,
                    text: 'Universidades Registrados Por Ciudad',
                    color: '#1F2937',
                    font: {
                        size: 20,
                        weight: 'bold'
                    }
                },
                legend: {
                    labels: {
                        color: '#36a2eb',
                        font: {
                            weight: 'bold',
                            size: 14
                        }
                    }
                },
                tooltip: {
                    titleColor: '#36a2eb', // Color del título del tooltip
                    bodyColor: '#36a2eb'   // Color del cuerpo del tooltip
                }
            },
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
});


async function downloadDivAsPDF() {


    const {jsPDF} = window.jspdf;

    // Seleccionar el div
    const element = document.getElementById("graficContent");


    const canvas = await html2canvas(element);
    const imgData = canvas.toDataURL("image/png");

    
    const pdf = new jsPDF('p', 'mm', 'a4');
    pdf.setFont("helvetica", "bold");
    pdf.setFontSize(18);
    pdf.text(" Reporte Grafico", pdf.internal.pageSize.getWidth() / 2, 20, {align: "center"});

    let marginTop = 30;


    const canvasRol = await html2canvas(document.getElementById("usuariosPorRolChart"));
    const imgRol = canvasRol.toDataURL("image/png");
    pdf.addImage(imgRol, "PNG", 45, marginTop, 120, 100);

    marginTop += 100 + 10;
  
    const canvasEsp = await html2canvas(document.getElementById("usuariosPorEspecialidadChart"));
    const imgEsp = canvasEsp.toDataURL("image/png");
    pdf.addImage(imgEsp, "PNG", 45, marginTop, 120, 100);
 
 marginTop += 100 + 10;
 if (marginTop + 100 > pdf.internal.pageSize.getHeight()) {
    pdf.addPage();
    marginTop = 30;
}
    
    const canvasEdad = await html2canvas(document.getElementById("usuariosPorEdadChart"));
    const imgEdad = canvasEdad.toDataURL("image/png");
    pdf.addImage(imgEdad, "PNG", 45, marginTop, 120, 100);
    
    marginTop += 100 + 10;
 if (marginTop + 100 > pdf.internal.pageSize.getHeight()) {
    pdf.addPage();
    marginTop = 30;
}
       const canvasCiudad = await html2canvas(document.getElementById("UniverPorCiudadChart"));
    const imgCiudad = canvasCiudad.toDataURL("image/png");
    pdf.addImage(imgCiudad, "PNG", 45, marginTop, 120, 100);
  
    pdf.save("Reportes.pdf");
}