--Criem um banco chamado pod

CREATE TABLE pessoa(
   id serial, 
   nome varchar(80) NOT NULL, 
   email varchar(80) NOT NULL,

   PRIMARY KEY(id)
);

CREATE TABLE email(
   id serial,
   remetente varchar(80) NOT NULL,
   destinatarios varchar NOT NULL,
   assunto varchar(80),
   status BOOLEAN DEFAULT FALSE,
   mensagem text,
   ipServidor VARCHAR(80) NOT NULL,
 
   PRIMARY KEY(id)
);

CREATE TABLE emailCliente(
   id serial,
   remetente varchar(80) NOT NULL,
   destinatarios varchar NOT NULL,
   assunto varchar(80),
   status BOOLEAN DEFAULT FALSE,
   mensagem text,
   ipServidor VARCHAR(80) NOT NULL,
 
   PRIMARY KEY(id)
);

