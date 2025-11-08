/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const questions = [
    {
        text: "¿Qué actividad disfrutas más?",
        options: [
            {text: "Resolver problemas matemáticos", area: "ciencias"},
            {text: "Ayudar a otras personas", area: "social"},
            {text: "Crear arte o música", area: "arte"},
            {text: "Investigar y experimentar", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué tipo de lectura prefieres?",
        options: [
            {text: "Libros científicos", area: "ciencias"},
            {text: "Novelas y poesía", area: "arte"},
            {text: "Estudios sociales", area: "social"},
            {text: "Artículos de investigación", area: "investigacion"}
        ]
    },
    {
        text: "¿En qué materia destacabas más en el colegio?",
        options: [
            {text: "Matemáticas o física", area: "ciencias"},
            {text: "Historia o filosofía", area: "social"},
            {text: "Arte o literatura", area: "arte"},
            {text: "Química o biología", area: "investigacion"}
        ]
    },
    {
        text: "Si pudieras elegir un proyecto escolar, ¿qué preferirías?",
        options: [
            {text: "Un experimento de laboratorio", area: "investigacion"},
            {text: "Una obra de teatro o mural", area: "arte"},
            {text: "Un debate sobre temas sociales", area: "social"},
            {text: "Un modelo matemático", area: "ciencias"}
        ]
    },
    {
        text: "¿Qué ambiente de trabajo prefieres?",
        options: [
            {text: "Un laboratorio con equipos", area: "investigacion"},
            {text: "Una oficina analizando datos", area: "ciencias"},
            {text: "Un estudio de arte o escenario", area: "arte"},
            {text: "Una comunidad con personas", area: "social"}
        ]
    },
    {
        text: "¿Qué te motiva más?",
        options: [
            {text: "Resolver enigmas complejos", area: "ciencias"},
            {text: "Expresarme de manera creativa", area: "arte"},
            {text: "Contribuir al bienestar social", area: "social"},
            {text: "Descubrir cosas nuevas", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué tipo de películas prefieres?",
        options: [
            {text: "Ciencia ficción", area: "ciencias"},
            {text: "Dramas sociales", area: "social"},
            {text: "Películas artísticas", area: "arte"},
            {text: "Documentales científicos", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué actividad harías en tu tiempo libre?",
        options: [
            {text: "Resolver acertijos o sudoku", area: "ciencias"},
            {text: "Participar en voluntariados", area: "social"},
            {text: "Pintar o componer música", area: "arte"},
            {text: "Leer sobre descubrimientos", area: "investigacion"}
        ]
    },
    {
        text: "¿Cómo te describen tus amigos?",
        options: [
            {text: "Lógico y analítico", area: "ciencias"},
            {text: "Empático y solidario", area: "social"},
            {text: "Creativo y sensible", area: "arte"},
            {text: "Curioso e investigador", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué prefieres en un grupo de trabajo?",
        options: [
            {text: "Liderar un debate social", area: "social"},
            {text: "Analizar los datos", area: "ciencias"},
            {text: "Diseñar la presentación creativa", area: "arte"},
            {text: "Buscar información nueva", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué sueño te parece más atractivo?",
        options: [
            {text: "Ser científico reconocido", area: "investigacion"},
            {text: "Ser un artista famoso", area: "arte"},
            {text: "Ser un líder social", area: "social"},
            {text: "Ser un gran matemático", area: "ciencias"}
        ]
    },
    {
        text: "Si tuvieras que dar una charla, sería sobre:",
        options: [
            {text: "Un descubrimiento científico", area: "investigacion"},
            {text: "La importancia de la empatía", area: "social"},
            {text: "La historia del arte", area: "arte"},
            {text: "Teorías matemáticas", area: "ciencias"}
        ]
    },
    {
        text: "¿Cuál de estas profesiones te atrae más?",
        options: [
            {text: "Ingeniero o matemático", area: "ciencias"},
            {text: "Sociólogo o psicólogo", area: "social"},
            {text: "Músico o pintor", area: "arte"},
            {text: "Biólogo o físico", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué preferirías desarrollar?",
        options: [
            {text: "Un nuevo algoritmo", area: "ciencias"},
            {text: "Un mural en la ciudad", area: "arte"},
            {text: "Un programa de ayuda social", area: "social"},
            {text: "Una vacuna", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué lugar prefieres visitar?",
        options: [
            {text: "Un museo de ciencia", area: "investigacion"},
            {text: "Una galería de arte", area: "arte"},
            {text: "Un centro comunitario", area: "social"},
            {text: "Un observatorio astronómico", area: "ciencias"}
        ]
    },
    {
        text: "Cuando trabajas en un proyecto, ¿qué valoras más?",
        options: [
            {text: "La creatividad y originalidad", area: "arte"},
            {text: "La precisión y lógica", area: "ciencias"},
            {text: "El impacto social", area: "social"},
            {text: "La innovación y descubrimiento", area: "investigacion"}
        ]
    },
    {
        text: "¿Cuál de estas asignaturas disfrutarías más?",
        options: [
            {text: "Química", area: "investigacion"},
            {text: "Artes plásticas", area: "arte"},
            {text: "Ciencias sociales", area: "social"},
            {text: "Matemáticas", area: "ciencias"}
        ]
    },
    {
        text: "¿Qué habilidad te gustaría perfeccionar?",
        options: [
            {text: "Pensamiento lógico", area: "ciencias"},
            {text: "Habilidades artísticas", area: "arte"},
            {text: "Liderazgo social", area: "social"},
            {text: "Métodos de investigación", area: "investigacion"}
        ]
    },
    {
        text: "¿Qué noticia te llama más la atención?",
        options: [
            {text: "Un avance médico", area: "investigacion"},
            {text: "Una reforma social", area: "social"},
            {text: "Una exposición de arte", area: "arte"},
            {text: "Un nuevo invento tecnológico", area: "ciencias"}
        ]
    },
    {
        text: "¿Cómo te gustaría ser recordado?",
        options: [
            {text: "Como un genio de la ciencia", area: "ciencias"},
            {text: "Como alguien que cambió la sociedad", area: "social"},
            {text: "Como un artista innovador", area: "arte"},
            {text: "Como un investigador brillante", area: "investigacion"}
        ]
    }
];


const careersByArea = {
    ciencias: ["Ingeniería", "Matemáticas", "Física", "Informática"],
    social: ["Psicología", "Trabajo Social", "Educación", "Sociología"],
    arte: ["Bellas Artes", "Diseño Gráfico", "Música", "Arquitectura"],
    investigacion: ["Biotecnología", "Investigación Científica", "Arqueología", "Química"]
};

let currentQuestion = 0;
let answers = { ciencias: 0, social: 0, arte: 0, investigacion: 0 };

function startTest() {
    document.getElementById('welcome').classList.remove('active');
    document.getElementById('test').classList.add('active');
    showQuestion();
}

function showQuestion() {
    const question = questions[currentQuestion];
    const container = document.getElementById('question-container');
    const progress = document.getElementById('progress');
    const errorMsg = document.getElementById('error-msg');

    progress.style.width = ((currentQuestion / questions.length) * 100) + "%";
    errorMsg.style.display = 'none';

    container.innerHTML =
        '<div class="question-card">' +
        '<h3>' + question.text + '</h3>' +
        '<div class="options">' +
        question.options.map(function (option) {
            return '<label>' +
                    '<input type="radio" name="q' + currentQuestion + '" value="' + option.area + '" /> ' +
                    option.text +
                    '</label>';
        }).join('') +
        '</div></div>';
}

function nextQuestion() {
    const selected = document.querySelector('input[name="q' + currentQuestion + '"]:checked');
    const errorMsg = document.getElementById('error-msg');

    if (!selected) {
        errorMsg.style.display = 'block';
        return;
    }

    answers[selected.value]++;
    currentQuestion++;

    if (currentQuestion < questions.length) {
        showQuestion();
    } else {
        showResults();
    }
}

function showResults() {
    document.getElementById('test').classList.remove('active');
    const results = document.getElementById('results');
    results.style.display = 'block';

    const total = Object.values(answers).reduce((a, b) => a + b, 0);
    const percentages = {};
    Object.keys(answers).forEach(area => {
        percentages[area] = (answers[area] / total) * 100;
    });

    const matches = document.getElementById('career-matches');
    matches.innerHTML = '';

    Object.keys(percentages)
        .sort((a, b) => percentages[b] - percentages[a])
        .forEach(area => {
            const careers = careersByArea[area];
            matches.innerHTML +=
                '<div class="career-match">' +
                '<h3>' + getAreaIcon(area) + ' ' + getAreaName(area) +
                ' <span class="percentage">' + percentages[area].toFixed(1) + '%</span></h3>' +
                '<p>Carreras recomendadas: ' + careers.join(', ') + '</p>' +
                '</div>';
        });

    createChart(percentages);
}

function getAreaIcon(area) {
    const icons = { ciencias: '🔬', social: '👥', arte: '🎨', investigacion: '🔍' };
    return icons[area];
}

function getAreaName(area) {
    const names = {
        ciencias: 'Ciencias y Tecnología',
        social: 'Ciencias Sociales',
        arte: 'Artes y Humanidades',
        investigacion: 'Investigación y Análisis'
    };
    return names[area];
}

function createChart(percentages) {
    const ctx = document.getElementById('resultsChart').getContext('2d');
    new Chart(ctx, {
        type: 'radar',
        data: {
            labels: Object.keys(percentages).map(getAreaName),
            datasets: [{
                label: 'Tus Intereses',
                data: Object.values(percentages),
                backgroundColor: 'rgba(52, 152, 219, 0.2)',
                borderColor: '#3498db',
                pointBackgroundColor: '#3498db',
                pointBorderColor: '#fff',
                pointHoverBackgroundColor: '#fff',
                pointHoverBorderColor: '#3498db'
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    labels: {
                        font: { family: "'Arial', sans-serif" }
                    }
                }
            },
            scales: {
                r: {
                    angleLines: { display: true },
                    suggestedMin: 0,
                    suggestedMax: 100,
                    ticks: { font: { family: "'Arial', sans-serif" } }
                }
            }
        }
    });
}
