drop table Promocao;
drop table Teatro;
drop table Site;
drop table Papel;
drop table Usuario;

create table Usuario (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null unique,
    senha varchar(100) not null,
    ativo smallint not null,
    CONSTRAINT Usuario_PK PRIMARY KEY (id)
);

create table Papel (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null unique,
    nome varchar(50) not null,
    constraint Usuario_FK FOREIGN KEY (email) REFERENCES Usuario(email) ON DELETE CASCADE,
    constraint Papel_PK PRIMARY KEY (id)
);

create table Site (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null unique,
    senha varchar(100) not null,
    url varchar(40) not null,
    nome varchar(50) not null,
    telefone integer not null,
    constraint Site_PK PRIMARY KEY (url)
);

create table Teatro (
    id integer not null generated always as identity (start with 1, increment by 1),
    email varchar(50) not null unique,
    senha varchar(100) not null,
    cidade varchar(40) not null,
    nome varchar(50) not null,
    cnpj integer not null,
    constraint Teatro_PK PRIMARY KEY (cnpj) 
);

create table Promocao (
    id integer not null generated always as identity (start with 1, increment by 1),
    url varchar(40) not null,    
    nome varchar(100) not null,
    preco decimal(6,2) not null,
    dia date not null,
    hora time not null,
    cnpj integer not null,
    constraint Promocao_PK PRIMARY KEY (id),
    constraint Site_FK FOREIGN KEY (url) REFERENCES Site(url) ON DELETE CASCADE,
    constraint Teatro_FK FOREIGN KEY (cnpj) REFERENCES Teatro(cnpj) ON DELETE CASCADE
);