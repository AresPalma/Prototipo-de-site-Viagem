create database agenciaViagem;

use agenciaViagem;

CREATE TABLE Permissoes (
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
FOREIGN KEY(id_permissao) REFERENCES Permissoes (id_permissao)
);

CREATE TABLE Destino (
id_destino INTEGER PRIMARY KEY auto_increment,
tipo_destino VARCHAR(20) NOT NULL,
origem_destino VARCHAR(50) NOT NULL,
nome_destino VARCHAR(80) NOT NULL,
preco_destino DECIMAL(10) NOT NULL,
id_companhia INTEGER
);

CREATE TABLE Companhias (
id_companhia INTEGER PRIMARY KEY auto_increment,
nome_companhia VARCHAR(30)NOT NULL
);

CREATE TABLE hospedagem (
id_hospedagem integer PRIMARY KEY auto_increment,
nome_hosped VARCHAR(50) NOT NULL,
tel_hosped VARCHAR(20),
cidade_estado VARCHAR(50)NOT NULL,
logradouro_hosped VARCHAR(80) NOT NULL,
precoHosped decimal(10) NOT NULL
);

CREATE TABLE Passagem (
id_passagem INTEGER PRIMARY KEY auto_increment,
tipo_pacote VARCHAR(20) NOT NULL,
dataEmbarque DATE NOT NULL,
dataRetorno DATE NOT NULL,
Qtd_dias VARCHAR(10) NOT NULL,
preco_compra DECIMAL(10)NOT NULL,
Id_usuario INTEGER,
id_destino INTEGER,
id_hospedagem INTEGER,
FOREIGN KEY(Id_usuario) REFERENCES Usuarios (Id_usuario),
FOREIGN KEY(id_destino) REFERENCES Destino (id_destino),
FOREIGN KEY(id_hospedagem) REFERENCES Hospedagem (id_hospedagem)
);

ALTER TABLE destino ADD FOREIGN KEY(id_companhia) REFERENCES Companhias (id_companhia);

alter table usuarios add FOREIGN KEY(id_permissao) references permissoes (id_permissao);
ALTER TABLE passagem ADD FOREIGN KEY(id_destino) REFERENCES Destino (id_destino);
ALTER TABLE passagem ADD FOREIGN KEY(id_hospedagem) REFERENCES hospedagem (id_hospedagem);
ALTER TABLE passagem ADD FOREIGN KEY(id_usuario) REFERENCES usuarios (id_usuario);


insert into permissoes (tipo_permissao) values 
('comum'), 
('administrador');

insert into usuarios (nome_usuario, cpf, tel_usuario, email, senha, id_permissao) values
('Maria', '00023432412', '(75)98800-1212', 'maria@email','234123',1), 
('Marcos', '024020232412', '(75)98300-0243', 'marcos@email','134240',1),
('Marcela', '001432232452', '(75)98121-5243', 'marcela@email','134444',1),
('Roberto', '003402130430', '(75)98220-3257', 'roberto@email','1034202',2);

INSERT INTO companhias (nome_companhia) values
('Gol'),
('Latam'),
('Air Europa'),
('Azul'),
('Gol'),
('Tap'),
('American Airlines');

 insert into destino (tipo_destino, origem_destino, nome_destino, preco_destino, id_companhia) values
 ('Nacional', 'Rio de Janeiro', 'Salvador', 2061, 4),
  ('Internacional', 'São Paulo', 'Berlim', 8757, 2),
  ('Nacional', 'Rio de Janeiro', 'Gramado', 1583, 2),
  ('Nacional', 'São Paulo','Fortaleza', 1694, 1),
   ('internacional', 'Rio de Janeiro','Orlando', 3.400,7),
   ('Nacional', 'São Paulo','Natal', 1694, 1),
   ('internacional', 'Salvador','Lisboa', 12.147, 4),
   ('Nacional', 'São Paulo','Porto Seguro', 1.030, 2);
   
INSERT INTO hospedagem (nome_hosped, tel_hosped, cidade_estado, logradouro_hosped, precoHosped ) values
('Seara Praia Hotel', '85 4011 2200','Fortaleza-CE','Av.Beira Mar 3080','411.00'),
('Esmeralda Praia Hotel',' 84 4005 0000','Ponta Negra Natal RN',' R.Francisco Gurgel 1160 ',606.00),
('Ibis Lisboa Liberdade', '35 121330 0630','Lisboa Portugal','R.Barata Salgueiro',452.00),
('Hôtel Le A', '33 14256-9999','Paris França','A 3.54 km do centro,Rue d Artois', 1568.00),
('Sol Barra Hotel','71 3418-7000','Salvador-BA','Av.Sete de Setembro,Barra',140.00),
('Hotel Shangrilá','73 3162-6505','Porto Seguro BA','R.do Cajueiro 70',130.00),
('Hyatt Regency Orlando','1 407-641 2224',' Orlando, Florida EUA','International Dr Orlando FL 32819',1075.00),
('Pousada Habitue', '54 3286-6497','Gramado RS','Av.das Hortênsias, 849 Centro',461.00),
('H2 Hotel Berlin-Alexanderplatz', '49 30 24088010','Berlim Alemanha','Karl Liebknecht Str.32a Mitte 10178',650.00);





 INSERT INTO passagem (tipo_pacote, Qtd_dias, preco_compra,dataEmbarque,dataRetorno, id_usuario, id_destino, id_hospedagem)values
 ('voo(ida e volta) Hospedagem,café da manha','4','1.247','06/10/2022','10/10/2022', 1, 8, 6);
 
 
 
select * from destino;
select * from passagem;
select * from hospedagem;
select * from usuario;
















