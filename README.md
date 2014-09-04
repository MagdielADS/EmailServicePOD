EmailServicePOD
===============

Projeto criado na disciplina de Programação de Objetos Distribuídos, no IFPB - CZ, 2014.1
Equipe:
  -Fernandodof
  -Kelsonsd
  -MagdielADS
  
Pré-requisito: Baixar projeto compartilhado, link abaixo!
https://github.com/filipegermano/EmailSharedPOD.git
  
-Script do banco está no pacote script;
-O servidor é iniciado executando a classe EmailServer;
-O cliente é iniciado executando a classe EmailClient;
-Para enviar emails, execute o projeto normal para abrir a interface web;

--A interface web apenas salva o email na base de dados do cliente, os emails são enviados para o servidor por meio da 
classe EmailClient, onde está agendado o processamento. Os emails armazenados no servidor são enviados através da classe 
EmailServer, onde está agendado o processamento.



