select * from usuario;

create database conexao360;
Use conexao360;
create table Usuario(
ID int primary key auto_increment,
Nome varchar(30),
RG varchar(15),
CPF varchar(15),
DataNascimento date,
Email varchar(50),
Senha varchar(10),
Telefone varchar(20),
Estado varchar(2),
CEP varchar(10),
Cidade varchar(10),
Endereco varchar(50),
Complemento varchar(200),
Administrador boolean
);



create table Doacao_Equipamento(
ID int primary key auto_increment,
ID_Usuario int not null,
foreign key (id_Usuario) references Usuario(ID),
Tipo_Equipamento integer not null,
Estado_Equipamento integer not null,
TipoColeta boolean not null,
DataColeta date not null,
Equipamento_Disponivel boolean not null,
Equipamento_Doado boolean not null,
Comentario varchar(200) not null
);



create table Requisicao_Equipamento(
ID int primary key auto_increment,
ID_Usuario int not null,
foreign key (id_Usuario) references Usuario(ID),
Necessidade int not null,
Tipo_Equipamento int not null,
Possui_Equipamento boolean not null,
Divide_Equipamento boolean not null,
Renda_Familiar integer not null,
Tipo_Entrega boolean not null,
DataEntrega date,
Complemento varchar(200),
Comentario varchar(200)
);



create table Doacao(
ID int primary key auto_increment,
ID_RequisicaoEquipamento int,
foreign key (id_RequisicaoEquipamento) references Requisicao_Equipamento(id),
ID_DoacaoEquipamento int,
foreign key (id_DoacaoEquipamento) references Doacao_Equipamento(id)
);