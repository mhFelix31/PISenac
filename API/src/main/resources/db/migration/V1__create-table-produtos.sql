create table produtos(
    id int not null auto_increment,
    nome varchar(100) not null,
    preco FLOAT not null,
    descricao varchar(100),
    materia_prima boolean not null,
    id_categoria int,
    id_cobranca int,
    fullimage varchar(100),

    primary key(id)

);