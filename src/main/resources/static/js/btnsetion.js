document.getElementById('toggleSidebarBtn').addEventListener('click', function () {
    var section = document.querySelector('section');
    var mainContainer = document.querySelector('.main-container');

    if (section.style.display === 'none') {
        section.style.display = 'block';
        mainContainer.style.width = 'calc(100% - 300px)';
    } else {
        section.style.display = 'none';
        mainContainer.style.width = '100%';
    }
});
