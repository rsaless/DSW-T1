create table Usuario(
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null,
    senha varchar(100) not null,
    ativo smallint not null,
    CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

create table Papel (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null,
    nome varchar(50) not null,
    constraint Papel_PK PRIMARY KEY (id)
);

create table Site (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null,
    senha varchar(100) not null,
    url varchar(40) not null,
    nome varchar(50) not null,
    telefone integer not null,
    constraint Site_PK PRIMARY KEY (id)
);

create table Teatro (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null,
    senha varchar(100) not null,
    cidade varchar(40) not null,
    nome varchar(50) not null,
    cnpj integer not null,
    constraint Teatro_PK PRIMARY KEY (id)
);

create table Promocao (
    id integer not null generated always as identity (start with 1, increment by 1),
    url varchar(40) not null,    
    nome varchar(100) not null,
    preco float(6,2) not null,
    dia date not null,
    hora time not null,
    cnpj integer not null,
    constraint Teatro_PK PRIMARY KEY (id),
    constraint Site_FK FOREIGN KEY (url) REFERENCES Site(url),
    constraint Teatro_FK FOREIGN KEY (cnpj) REFERENCES Teatro(cnpj)
);