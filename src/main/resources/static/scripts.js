const switchElement = document.querySelector('.switch')

document.addEventListener('click', (event) => {
    if(event.target && event.target.matches('.switch')){
    document.body.classList.toggle('dark');
       }
});



