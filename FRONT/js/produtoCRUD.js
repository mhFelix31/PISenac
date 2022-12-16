var xhr = new XMLHttpRequest();



function OpenXHR(method, id) {
    xhr.open(method, "http://localhost:8080/produtos" + id);
    // Set the request headers
    xhr.setRequestHeader("Content-Type", "application/json");
}

window.onload = Read();

function Post(id, nome, preco, descricao, materiaPrima, idCategoria, idCobranca, fullimage) {
    OpenXHR("POST");
    var data = {
        "nome": $nome,
        "preco": $preco,
        "descricao": $descricao,
        "materiaPrima": $materiaPrima,
        "idCategoria": $idCategoria,
        "idCobranca": $idCobranca,
        "fullimage": $fullimage
    }

    // Send the request to the server
    xhr.send(JSON.stringify(data));
    // Wait for the server to respond, then handle the response
    xhr.onload = function () {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);

            //Dizer q deu

            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
    Read();
}

function Read() {
    OpenXHR("GET", '');

    xhr.send();
    // Wait for the server to respond, then handle the response
    xhr.onload = function () {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);

            responseData.content.forEach(produto => {
                const tr = document.createElement('tr');
                const trContent = `
      <td>${produto.id}</td>
      <td>${produto.nome}</td>
      <td>${produto.preco}</td>
      <td>${produto.materiaPrima}</td>
      `;
                tr.innerHTML = trContent;
                document.querySelector('table tbody').appendChild(tr);
            });

            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
}

function Put(id, nome, preco, descricao, materiaPrima, idCategoria, idCobranca, fullimage) {
    OpenXHR("PUT", id);
    var data = {
        "nome": $nome,
        "preco": $preco,
        "descricao": $descricao,
        "materiaPrima": $materiaPrima,
        "idCategoria": $idCategoria,
        "idCobranca": $idCobranca,
        "fullimage": $fullimage
    }

    // Send the request to the server
    xhr.send(JSON.stringify(data));
    // Wait for the server to respond, then handle the response
    xhr.onload = function () {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);

            //Dizer q deu

            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
    
    Read();
}

function Delete(id) {
    OpenXHR("DELETE", id);
    xhr.send();
    // Wait for the server to respond, then handle the response
    xhr.onload = function () {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);

            //Dizer q deu

            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
    
    Read();
}

;