CREATE TABLE autor (
	cpf varchar(20) primary key,
	nome varchar(30) not null,
	email varchar(30) not null
);

CREATE TABLE livro (
	isbn varchar(20) primary key,
	descricao varchar(30) not null,
	edicao int not null	 
);

CREATE TABLE livroAutor(
	isbn varchar(20),
	cpf varchar(20),
	primary key(cpf, isbn),
	foreign key (isbn) REFERENCES livro (isbn) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key (cpf) REFERENCES autor (cpf) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE emprestimo (
	nomeCliente varchar(40),
	data Date not null,
	situacao varchar(15) not null,
	isbn varchar(20) primary key,
	foreign key(isbn) REFERENCES livro(isbn) ON DELETE CASCADE ON UPDATE CASCADE
);
