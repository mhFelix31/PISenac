const Pedidos = pedidosTemp;

var pedidosTemp;


window.onload = RequestGet(baseUrl);

// API endpoint --------------------------------------------
const baseUrl = 'http://localhost:8080/pedidos';


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
        Pedidos = data;
    })
    .catch(err => console.log(err));
}

// Função que faz a chamada das principais funções e inicia o app
function RequestGet() {
  requestInfo(baseUrl);
Pedidos = pedidosTemp;

  setTimeout(function () {
      container.innerHTML = createTR();
  }, 2000);
}

