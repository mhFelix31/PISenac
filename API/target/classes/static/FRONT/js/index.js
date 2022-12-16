const sideMenu = document.querySelector("aside");
const menuBtn = document.querySelector("#menu-btn");
const closeBtn = document.querySelector("#close-btn");
const themeToggler = document.querySelector(".theme-toggler");

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

Pedidos.forEach(pedido => {
    const tr = document.createElement('tr');
    const trContent = `
    <td>${pedido.id}</td>
    <td>${pedido.valor}</td>
    <td>${pedido.data}</td>
    <td class="${pedido.status === 'CANCELADO' ? 'danger' : pedido.status === 'AGUARDANDO' ? 'warning': 'primary' }">${pedido.status}</td>
    `;
        tr.innerHTML = trContent;
     document.querySelector('table tbody').appendChild(tr);
});