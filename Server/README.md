# GRAILS API
API criada usando o framework Grails para atuar em conjunto com o cliente em Angular.

A documentação completa da API também está disponível neste enredeço:  
https://documenter.getpostman.com/view/5675736/S1TZwa72?version=latest#intro

Para obter o ambiente de testes (postman) utilizando na confecção da API, e realizar testes localmente acesse:  
https://www.getpostman.com/collections/34741cf63f9d0f9e00bf 

## A API  
Dentre as funcionalidades da API estão:
* acesso ao banco de dados  
* sistema de login  
* cadasto, manipulação e remoção de Usuários  
* cadasto, manipulação e remoção de Sites  
* cadastro, manipulação e remoção de Teatros
* cadastro, manipulação e remoção de Promoções    

## Executando o projeto da API 
Para executar o projeto:

> git clone https://github.com/rsaless/DSW  
> cd Server  
> grails run-app  

## Rotas disponíveis  
URL base: http://localhost:8090/ServerT3

| Método    | Rota                          | Implementação      | Integração | Descrição                     |
|:----------|:------------------------------|:------------------:|:----------:|:------------------------------|
| `GET`     | /sites                        |:heavy_check_mark:  |:x:         | Listar sites                  |
| `POST`    | /sites                        |:heavy_check_mark:  |:x:         | Cadastrar site                |
| `PUT`     | /sites/(ID)                   |:heavy_check_mark:  |:x:         | Atualizar site específico     |
| `DELETE`  | /sites/(ID)                   |:heavy_check_mark:  |:x:         | Deletar site especifico       |
| `GET`     | /sites/(ID)                   |:heavy_check_mark:  |:x:         | listar site específico        |
| `GET`     | /teatros                      |:heavy_check_mark:  |:x:         | Listar teatros                |
| `POST`    | /teatros                      |:heavy_check_mark:  |:x:         | Cadastrar teatro              |
| `PUT`     | /teatros/(ID)                 |:heavy_check_mark:  |:x:         | Atualizar teatro específico   |
| `DELETE`  | /teatros/(ID)                 |:heavy_check_mark:  |:x:         | Deletar teatro especifico     |
| `GET`     | /teatros/(ID)                 |:heavy_check_mark:  |:x:         | listar teatro específico      |
| `GET`     | /promocoes                    |:heavy_check_mark:  |:x:         | Listar promocoes              |
| `POST`    | /promocoes                    |:heavy_check_mark:  |:x:         | Cadastrar promocao            |
| `PUT`     | /promocoes/(ID)               |:heavy_check_mark:  |:x:         | Atualizar promocao específico |
| `DELETE`  | /promocoes/(ID)               |:heavy_check_mark:  |:x:         | Deletar promocao especifico   |
| `GET`     | /promocoes/(ID)               |:heavy_check_mark:  |:x:         | listar promocao específico    |
| `GET`     | /usuarios                     |:heavy_check_mark:  |:x:         | Listar usuarios               |
| `POST`    | /usuarios                     |:heavy_check_mark:  |:x:         | Cadastrar usuario             |
| `PUT`     | /usuarios/(ID)                |:heavy_check_mark:  |:x:         | Atualizar usuario específico  |
| `DELETE`  | /usuarios/(ID)                |:heavy_check_mark:  |:x:         | Deletar usuario especifico    |
| `GET`     | /usuarios/(ID)                |:heavy_check_mark:  |:x:         | listar usuario específico     |
| `GET`     | /papeis                       |:heavy_check_mark:  |:x:         | Listar papeis                 |
| `POST`    | /papeis                       |:heavy_check_mark:  |:x:         | Cadastrar papel               |
| `PUT`     | /papeis/(ID)                  |:heavy_check_mark:  |:x:         | Atualizar papel específico    |
| `DELETE`  | /papeis/(ID)                  |:heavy_check_mark:  |:x:         | Deletar papel especifico      |
| `GET`     | /papeis/(ID)                  |:heavy_check_mark:  |:x:         | listar papel específico       |
| `GET`     | /teatros/cidade/(cidade)      |:heavy_check_mark:  |:x:         | Listar teatros por cidade     |
| `GET`     | /promocoes/teatro/(cnpj)      |:heavy_check_mark:  |:x:         | Listar promocoes por teatro   |
| `GET`     | /promocoes/teatro/(nome_site) |:heavy_check_mark:  |:x:         | Listar promocoes por site     |
