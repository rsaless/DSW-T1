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