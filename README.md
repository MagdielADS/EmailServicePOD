EmailServicePOD
===============

Projeto criado na disciplina de Programação de Objetos Distribuídos, no IFPB - CZ, 2014.1

-O servidor é iniciado executando a classe EmailServer;
-O cliente é iniciado executando a classe EmailClient;
-Para enviar emails, execute o projeto normal para abrir a interface web;

--A interface web apenas salva o email na base de dados do cliente, os emails são enviados para o servidor por meio da 
classe EmailClient, onde é agendado o processamento. Os emails armazenados no servidor são enviados através da classe 
EmailServer, onde é agendado o processamento.

