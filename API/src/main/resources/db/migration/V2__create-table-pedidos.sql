create table pedidos(
    id int not null auto_increment,
    status varchar(100) not null,
    data Date not null,
    id_cliente int,
    id_funcionario int,
    valor float,

    primary key(id)

);

create table produtos_in_pedido(

pedido_id INT NOT NULL,
produto_id INT NOT NULL,
PRIMARY KEY(pedido_id, produto_id),

constraint fk_produtos_in_pedido__produto
foreign key(pedido_id) references Produtos(id),

constraint fk_produtos_in_pedido__pedido
foreign key(produto_id) references Pedidos(id)

);