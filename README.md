# DSW-T1
Primeiro projeto da disciplina de Desenvolvimento de Software para a Web. Universidade Federal de São Carlos. 2019.
Instruções: ver Roteiro.txt

## TELAS

* Tela de cadastro de sites de venda de ingressos
  * E-mail, senha, url, nome e telefone
  * CRUD
  * Login de administrador
* Tela de listagem de sites de venda de ingressos
  * Não requer login
* Tela de cadastro de salas de teatro
  * E-mail, senha, CNPJ, nome e cidade
  * CRUD
  * Login de administrador
* Tela de listagem de salas de teatro
  * Listar todas as salas
  * Filtro por cidade
  * Não requer login
* Tela de criação de promoção
  * Login de teatro
  * Escolher site
  * Nome da peça, preço, dia, horário, CNPJ
* Tela de listagem de promoções por sala
  * Listar promoções por sala de teatro
  * Não requer login
* Tela de listagem de promoções por site
  * Login de sala de teatro


## OBSERVAÇÕES
* Não deve ser possível uma sala cadastrar no mesmo site duas promoções no mesmo dia e horário;
* O sistema deve ser internacionalizado em português e mais um outro idioma;
* O sistema deve impedir cadastros duplicados;
* O sistema deve mostrar uma página para problemas técnicos (404 e 500);
* O sistema deve logar os erros no console;
* O sistema deve implementar o MVC;
* O sistema deve usar apenas JSP, Servlets, JDBC, CSS e Javascript;

## PREPARANDO O AMBIENTE
* Criar banco de dados Trabalho1 (usuario: root, senha: root);
* Limpar o banco e colocar o valor 'create' para a persistencia de dados no arquivo persistence.xml;
* Executar script CriaUsuarios.java para criar os usuários e respectivos papeis (presente na pasta de códigos fonte login);