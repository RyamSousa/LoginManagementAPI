# LoginManagementAPI

## Sobre o projeto
É um projetinho simples de uma API REST, desenvolvida em java com spring boot e spring data. O objetivo é fazer um CRUD de uma entidade do banco de dados, utilizando as melhores práticas
da programação em java. A entidade é chamada de Login, e possui e-mail e senha como atributos.

## Tecnologias utilizadas
- Java 14
- Spring boot
- JPA
- Maven
- PostgreSQL


## Funcionalidades
> Concluído: :heavy_check_mark: <br>
> Em desenvolvimento: :warning: <br>
> Não iniciado ainda: :x: <br>

 - Salvar :heavy_check_mark:
 - Deletar :heavy_check_mark:
 - Listar por ID :heavy_check_mark:
 - Listar todos :heavy_check_mark:
 - Atualizar :heavy_check_mark:
 - Validação de dados :heavy_check_mark:
 - Tratamento de exceções :warning:
 - Sessão de login :x:
 - Testes unitários :x:
 
 ## Sobre o desenvolvimento
 Foi utilizado a biblioteca MessageDigest para criar um hash de senha, como uma forma de deixar a aplicação mais segura, criando uma forma de criptografar as 
 senhas cadastradas na base de dados. Também foi utilizado expressões regulares para validar os e-mails cadastrados. O lombok foi uma alternativa utilizado para 
 deixar o código mais limpo e menos verboso. Algumas anotações do pacote Validation do java foram utilizadas para validar os dados enviados pelo cliente.
 
 ## Códigos
 
 Código DDL utilizado no do banco;
```
 CREATE TABLE tb_login(
	id NUMERIC(9) NOT NULL PRIMARY KEY,
	"email" VARCHAR(100) NOT NULL,
	"password" VARCHAR(100) NOT NULL
 );
 CREATE SEQUENCE hibernate_sequence START 1;
```
