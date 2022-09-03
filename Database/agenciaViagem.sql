create database agenciaViagem;

use agenciaViagem;

CREATE TABLE Permissões (
id_permissao INTEGER PRIMARY KEY auto_increment NOT NULL,
tipo_permissao VARCHAR(20) NOT NULL
);

CREATE TABLE Usuarios (
Id_usuario INTEGER PRIMARY KEY auto_increment,
nome_usuario VARCHAR(80) NOT NULL,
cpf VARCHAR(20) NOT NULL,
tel_usuario VARCHAR(20),
email VARCHAR(80)NOT NULL,
senha VARCHAR(10) NOT NULL,
id_permissao INTEGER,
FOREIGN KEY(id_permissao) REFERENCES Permissões (id_permissao)
);

CREATE TABLE Destino (
id_destino INTEGER PRIMARY KEY auto_increment,
tipo_destino VARCHAR(20) NOT NULL,
origem_destino VARCHAR(50) NOT NULL,
nome_destino VARCHAR(80) NOT NULL,
preco_destino DECIMAL(5,2) NOT NULL,
id_companhia INTEGER
);
CREATE TABLE Comapanhias (
id_companhia INTEGER PRIMARY KEY auto_increment ,
nome_companhia VARCHAR(30)NOT NULL
);

CREATE TABLE hospedagem (
id_hosped integer PRIMARY KEY auto_increment,
nome_hosped VARCHAR(50) NOT NULL,
tel_hosped VARCHAR(20),
cidade_estado VARCHAR(50)NOT NULL,
logradouro_hosped VARCHAR(80) NOT NULL,
preço_hosped decimal(5,2) NOT NULL
);

CREATE TABLE Passagem (
id_passagem INTEGER PRIMARY KEY auto_increment,
tipo_pacote VARCHAR(20) NOT NULL,
data_embarque DATE NOT NULL,
data_retorno DATE NOT NULL,
Qtd_dias VARCHAR(10) NOT NULL,
preco_compra DECIMAL(5,2)NOT NULL,
Id_usuario INTEGER,
id_destino INTEGER,
id_hosped INTEGER,
FOREIGN KEY(Id_usuario) REFERENCES Usuarios (Id_usuario),
FOREIGN KEY(id_destino) REFERENCES Destino (id_destino),
FOREIGN KEY(id_hosped) REFERENCES Hospedagem (id_hosped)
);
ALTER TABLE destino ADD FOREIGN KEY(id_companhia) REFERENCES Comapanhias (id_companhia);


alter table destino add foreign key(id_passagem) references passagem (id_passagem);

alter table li add foreign key(id_editora) references editoras (id_editora);
alter table usuarios add FOREIGN KEY(id_permissao) references permissoes (id_permissao);


insert into permissoes (tipo) values 
('comum'), 
('administrador');

insert into usuarios (nome_usuario, cpf, usuario_tel, email, senha, id_permissao) values
('Maria', '00023432412', '(75)98800-1212', 'maria@email','234123','1'), 
('Marcos', '024020232412', '(75)98300-0243', 'marcos@email','134240','1'),
('Marcela', '001432232452', '(75)98121-5243', 'marcela@email','134444','1'),
('Roberto', '003402130430', '(75)98220-3257', 'roberto@email','1034202','2');

INSERT INTO companhias (nome_companhia) values
('Gol'),
('Latam'),
('Air Europa'),
('Azul'),
('Gol'),
('Tap'),
('American Airlines');

 insert into destino (tipo_destino, origem_destino, nome_destino, preco_destino, id_companhia) values
 ('Nacional', 'Rio de Janeiro', 'Salvador', 'R$ 2.061', '4'),
  ('Internacional', 'São Paulo', 'Berlim', 'R$ 8.757,97', '2'),
  ('Nacional', 'Rio de Janeiro', 'Gramado', 'R$ 1.583', '2'),
  ('Nacional', 'São Paulo','Fortaleza', 'R$ 1.694', '1'),
   ('internacional', 'Rio de Janeiro','Orlando', 'R$ 3.400','7'),
   ('Nacional', 'São Paulo','Natal', 'R$ 1.694', '1'),
   ('internacional', 'Salvador','Lisboa', 'R$ 12.147', '4'),
   ('Nacional', 'São Paulo','Porto Seguro', 'R$ 1.030', '2');
   
INSERT INTO hospedagem (nome_hosped, tel_estado, cidade_estado, logradouro_hosped, preco_hosped ) values
('Seara Praia Hotel', '85 4011 2200','Fortaleza-CE','Av.Beira Mar 3080','R$ 411,00'),
('Esmeralda Praia Hotel',' 84 4005 0000','Ponta Negra Natal RN',' R.Francisco Gurgel 1160 ','R$ 606,00'),
('Ibis Lisboa Liberdade', '35 121330 0630','Lisboa Portugal','R.Barata Salgueiro','R$ 452,00'),
('Hôtel Le A', '33 14256-9999','Paris França','A 3,54 km do centro,Rue d Artois','R$1.568'),
('Sol Barra Hotel','71 3418-7000','Salvador-BA','Av.Sete de Setembro,Barra','R$ 140,00'),
('Carmel Cumbuco Resort','85 3266-6100','Caucaia-CE','Av.dos Coqueiros S/N Praia do Cumbuco','R$ 606,00'),
('Hyatt Regency Orlando','1 407-641 2224',' Orlando, Florida EUA','International Dr Orlando, FL 32819','R$ 1075,00'),
('Pousada Habitue', '54 3286-6497','Gramado RS','Av.das Hortênsias, 849 Centro','R$ 461,00'),
('H2 Hotel Berlin-Alexanderplatz', '49 30 24088010','Comparar preços','Berlim Alemanha','Karl Liebknecht Str.32a Mitte 10178','R$ 650,00');

 
 
 
 
 
select * from destino;
select * from passagem;
select * from hospedagem;
select * from usuario;
















