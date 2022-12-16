
const sideMenu = getElement("aside");
const menuBtn = getElement("#menu-btn");
const closeBtn = getElement("#close-btn");
const themeToggler = getElement(".theme-toggler");
//mostrar barra lateral
menuBtn.addEventListener('click', () => {
    sideMenu.style.display = 'block';
})

//fechar barra lateral
closeBtn.addEventListener('click', () =>{
    sideMenu.style.display = 'none';
})

//mudar tema
themeToggler.addEventListener('click', () =>{
    document.body.classList.toggle('dark-theme-variables');

    themeToggler.querySelector('span:nth-child(1)').classList.toggler('active')
    themeToggler.querySelector('span:nth-child(2)').classList.toggler('active')
})


// Função para reduzir a escrita na captura de elementos HTML
function getElement(element) {
  return document.querySelector(element);
}




