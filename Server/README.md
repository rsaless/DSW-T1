# GRAILS API
API criada usando o framework Grails para atuar em conjunto com o cliente em Angular.

A documentação completa da API também está disponível neste enredeço:  
https://documenter.getpostman.com/view/5675736/S1TZwa72?version=latest#intro

Para acessar o ambiente de testes (postman) utilizando na confecção da API, e realizar testes localmente acesse:  
https://www.getpostman.com/collections/34741cf63f9d0f9e00bf 

## A API  
Dentre as funcionalidades da API estão:
* acesso ao banco de dados  
* cadasto, manipulação e remoção de Usuários  
* cadasto, manipulação e remoção de Sites  
* cadastro, manipulação e remoção de Teatros
* cadasto, manipulação e remoção de Promoções    
* sistema de login  

## Executando o projeto da API 
Para executar o projeto:

> git clone https://github.com/rsaless/DSW  
> cd Server  
> grails run-app  

## Rotas disponíveis  
URL base: http://localhost:8090/ServerT3

| Método    | Rota                                                          | Implementação      | Integração | Descrição                                                |
|:----------|:--------------------------------------------------------------|:------------------:|:----------:|:---------------------------------------------------------|
| POST      | `user/login`                                                  |:x:                 |:x:         | Efetuar login na aplicação                               |
| GET       | `/user/(username)/`                                           |:x:                 |:x:         | Listar dados de um usuário                               |
| POST      | `/user/cadastro`                                              |:x:                 |:x:         | Cadastrar um novo usuário                                |
| PUT       | `/user/(ID)/atualiza`                                         |:x:                 |:x:         | Atualizar dados de um usuário                            |
| DELETE    | `/user/(ID)/remove`                                           |:x:                 |:x:         | Remover um usuário da aplicação                          |
| GET       | `/user/(ID)/produtos`                                         |:x:                 |:x:         | Retornar os produtos de um usuário                       |
| GET       | `/user/(ID)/produtos/(produto)`                               |:x:                 |:x:         | Retornar os dados de um produto                          |
| PUT       | `/user/(ID)/produtos/(produto)/edita`                         |:x:                 |:x:         | Editar os dados de um produto                            |
| DELETE    | `/user/(ID)/produtos/(produto)/remove`                        |:x:                 |:x:         | Remover um produto da aplicação                          |
| POST      | `/user/(ID)/produtos/cadastra`                                |:x:                 |:x:         | Cadastrar um novo produto                                |
| GET       | `/user/(ID)/propostas/feitas`                                 |:x:                 |:x:         | Listar propostas feitas pelo usuário                     |
| GET       | `/user/(ID)/propostas/recebidas`                              |:x:                 |:x:         | Listar propostas recebidas pelo usuário                  |
| GET       | `/user/(ID)/produtos/(produto)/propostas`                     |:x:                 |:x:         | Retornar os dados de uma proposta                        |
| GET       | `/user/(ID)/produtos/(produto)/propostas/(proposta)`          |:x:                 |:x:         | Retornar os dados de uma proposta                        |
| POST      | `/user/(ID)/produtos/(produto)/propostas/(proposta)/aceitar`  |:x:                 |:x:         | Aceitar uma proposta                                     |
| POST      | `/user/(ID)/produtos/(produto)/propostas/(proposta)/recusar`  |:x:                 |:x:         | Recusar uma proposta                                     |
| POST      | `/user/(ID)/produtos/(produto)/propostas/nova/(ID2)/(oferta)` |:x:                 |:x:         | 'ID2' oferece 'oferta' para 'ID' em troca de 'produto'   |


:x:
 :heavy_check_mark: