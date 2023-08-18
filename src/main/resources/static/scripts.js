let darkTheme = localStorage.getItem('dark');
const switchElement = document.querySelector('.switch');

const enableDarkMode() => {
document.body.classList.toggle('dark')
localStorage.setItem('dark','enabled' )
}

const disableDarkMode = () => {
  document.body.classList.remove('dark');
  localStorage.setItem('dark', null);
}

if(dark === 'enabled'){
enableDarkMode();
}

switchElement.addEventListener('click', () => {
darkTheme = localStorage.getItem('dark');
    if('dark' !== 'enabled'){
    enableDarkMode();
    } else {
     disableDarkMode();
    }
   });






/*const switchElement = document.querySelector('.switch')


document.addEventListener('click', (event) => {
    if(event.target && event.target.matches('.switch')){
    document.body.classList.toggle('dark');
       }
});*/



