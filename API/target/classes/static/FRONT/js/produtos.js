// API endpoint --------------------------------------------
const baseUrl = 'http://localhost:8080/pedidos';

// Get Elements --------------------------------------------
const searchInput = getElement('.search-input'),
      searchButton = getElement('.search-button'),
      container = getElement('.pokemon'),
      erroMessage = getElement('.error');

var pedidos; // Responsavel por guardar os dados recebidos da API

// Build Functions --------------------------------------------

// Função para reduzir a escrita na captura de elementos HTML
function getElement(element) {
  return document.querySelector(element);
}

// Função responsavel por fazer requisições para a API e inserir as respostas na variavel pokemon
function requestInfo(url) {
  fetch(url)
    .then(response => response.json())
    .then(data => {
      pedidos = data;
    })
    .catch(err => console.log(err));
}

// Função responsavel por montar o HTML exibido na pagina
function createTR () {
  card = `
    <td>${pedido.id}</td>
    <td>${pedido.valor}</td>
    <td>${pedido.data}</td>
    <td class="${pedido.status === 'CANCELADO' ? 'danger' : pedido.status === 'AGUARDANDO' ? 'warning': 'primary' }">${pedido.status}</td>
    `;

    
  return card;
}

pedidos.forEach(pedido => {
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

// Função que faz a chamada das principais funções e inicia o app
function RequestGet() {
  requestInfo(baseUrl);


  setTimeout(function () {
      container.innerHTML = createTR();
  }, 2000);
}
