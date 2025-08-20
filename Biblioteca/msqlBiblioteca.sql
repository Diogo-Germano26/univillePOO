create table USUARIO(
	id_usuario int auto_increment  primary key,
    nome varchar(255) not null,
    email varchar(255)not null
);
create table LIVRO(
	id_livro int auto_increment primary key,
    titulo varchar(255) not null
);
create table EMPRESTIMO(
	id_emprestimo int auto_increment primary key,
    id_usuario int not null,
    id_livro int not null,
    data_emprestimo datetime not null,
	data_prevista_devolucao datetime not null,
    data_efetiva_devolucao datetime default null,	
    foreign key (id_usuario) references USUARIO(id_usuario),
    foreign key (id_livro) references LIVRO(id_livro)
);

insert into Usuario(nome, email) 
	VALUES('Leticia Germano', 'leticia@germano.com');
select*from usuario;    
INSERT INTO LIVRO(titulo)
	values('Código Completo');
    
delete from usuario 
where id_usuario = 2;

select * from emprestimo;

insert into emprestimo(id_usuario,id_livro,data_emprestimo,data_prevista_devolucao)
	values(3,1,now(),date_add(now(),interval 1 MONTH));
    
    