document.addEventListener('DOMContentLoaded', () => {
    const universitiesPerPage = 10;
    const universityCards = Array.from(document.querySelectorAll('.university-card'));
    const filterButtons = document.querySelectorAll('.filter-btn');
    const paginationContainer = document.querySelector('.pagination');
    let currentPage = 1;
    let currentFilter = 'all';

    function getFilteredCards() {
        switch (currentFilter) {
            case 'all':
                return universityCards;
            case 'top10':
                return universityCards.filter(card => {
                    const rank = parseInt(card.className.match(/rank-(\d+)/)[1]);
                    return rank <= 10;
                });
            case 'public':
                return universityCards.filter(card => card.classList.contains('type-public'));
            case 'private':
                return universityCards.filter(card => card.classList.contains('type-private'));
            case 'careers':
                return universityCards.filter(card => {
                    const careers = parseInt(card.className.match(/careers-(\d+)/)[1]);
                    return careers > 20;
                });
            case 'students':
                return universityCards.filter(card => {
                    const students = parseInt(card.className.match(/students-(\d+)/)[1]);
                    return students > 10000;
                });
            default:
                return universityCards;
        }
    }

    function showPage(page) {
        const filteredCards = getFilteredCards();
        const startIndex = (page - 1) * universitiesPerPage;
        const endIndex = startIndex + universitiesPerPage;
        universityCards.forEach(card => card.style.display = 'none');
        filteredCards.slice(startIndex, endIndex).forEach(card => card.style.display = 'block');
    }

    function updatePagination() {
        const filteredCards = getFilteredCards();
        const totalPages = Math.ceil(filteredCards.length / universitiesPerPage);
        if (!paginationContainer) return;
        paginationContainer.innerHTML = '';

        if (totalPages <= 1) return;

        // Botón Anterior
        const prevButton = document.createElement('button');
        prevButton.textContent = '<';
        prevButton.className = 'page-btn prev-btn ' + (currentPage == 1 ? 'disabled' : '');
        prevButton.onclick = () => {
            if (currentPage > 1) {
                currentPage--;
                updatePagination();
                showPage(currentPage);
            }
        };
        paginationContainer.appendChild(prevButton);

        // Botones de páginas
        for (let i = 1; i <= totalPages; i++) {
            const btn = document.createElement('button');
            btn.textContent = i;
            btn.className = 'page-btn ' + (i === currentPage ? 'active' : '');
            btn.onclick = () => {
                currentPage = i;
                updatePagination();
                showPage(currentPage);
            };
            paginationContainer.appendChild(btn);
        }

        // Botón Siguiente
        const nextButton = document.createElement('button');
        nextButton.textContent = '>';
        nextButton.className = 'page-btn next-btn ' + (currentPage == totalPages ? 'disabled' : '');
        nextButton.onclick = () => {
            if (currentPage < totalPages) {
                currentPage++;
                updatePagination();
                showPage(currentPage);
            }
        };
        paginationContainer.appendChild(nextButton);
    }

    // Eventos de filtros
    filterButtons.forEach(btn => {
        btn.addEventListener('click', () => {
            document.querySelector('.filter-btn.active')?.classList.remove('active');
            btn.classList.add('active');
            currentFilter = btn.dataset.filter || 'all';
            currentPage = 1;
            updatePagination();
            showPage(currentPage);
        });
    });

    // Inicialización
    updatePagination();
    showPage(currentPage);
});
