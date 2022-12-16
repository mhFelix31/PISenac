var xhr = new XMLHttpRequest();


function Data(id,status,date,idCliente,idFuncionario,valor){
    var data = {
        "id":$id,
        "status":$status,
        "data":$date,
        "valor":$valor
    }
    return data;
}

function OpenXHR(method,id){
    xhr.open(method,"http://localhost:8080/pedidos"+id);
    // Set the request headers
    xhr.setRequestHeader("Content-Type", "application/json");
}

window.onload = Read();

function Post(id,status,date,idCliente,idFuncionario,valor){
    OpenXHR("POST",'');
    var data = {
        "status": status,
        "date": date,
        "valor": valor
    }
    var JSONData = JSON.stringify(data);
    console.log(JSONData);
    // Send the request to the server
    xhr.send(JSONData);
    // Wait for the server to respond, then handle the response
    xhr.onload = function () {
        if (xhr.status != 200) {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
    Refresh()
}

function Read(){
    OpenXHR("GET","");   
    
    xhr.send();
    // Wait for the server to respond, then handle the response
    xhr.onload = function() {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);
            

            responseData.content.forEach(pedido => {
                const tr = document.createElement('tr');
                const trContent = `
                <td>${pedido.id}</td>
                <td>${pedido.status}</td>
                <td>${pedido.valor}</td>
                `;
                tr.innerHTML = trContent;
                getElement(".ReadTable").appendChild(tr);
            });
            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
}

function ReadWithID(id){
    OpenXHR("GET",'/'+id);   
    
    xhr.send();
    // Wait for the server to respond, then handle the response
    xhr.onload = function() {
        if (xhr.status == 200) {
            // If the response is successful, do something with the data
            var responseData = JSON.parse(xhr.response);
            
                const trContent = `
                <td>${responseData.id}</td>
                <td>${responseData.status}</td>
                <td>${responseData.valor}</td>
                `;
                getElement(".pesquisaRead").innerHTML = trContent;
            
            // ...
        } else {
            // If the response is not successful, handle the error
            console.error("An error occurred: " + xhr.status);
        }
    }
}

function Put(id,status,date,idCliente,idFuncionario,valor){
    OpenXHR("PUT",id);
    
    var data = {
        "id": id,
        "status": status,
        "date": date,
        "idCliente": idCliente,
        "idFuncionario": idFuncionario,
        "valor": valor
    }

    // Send the request to the server
    xhr.send(JSON.stringify(data));
    // Wait for the server to respond, then handle the response
    xhr.onload = function() {
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
    Refresh()
}

function Delete(id){
    OpenXHR("DELETE",id);
    xhr.send();
    // Wait for the server to respond, then handle the response
    xhr.onload = function() {
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
    
    Refresh()
}


function Refresh(){
    document.location.reload(true);
}

;