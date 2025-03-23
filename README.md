
# Pós-Graduaçã em Software Architecture

Este projeto é uma API RESTful desenvolvida em Spring Boot, projetada para gerenciar os pedidos de uma lanchonete. O sistema permite criar, atualizar, listar e excluir produtos, bem como buscar produtos por categoria, realizar checkout de pagamento e listar os pedidos. A aplicação é containerizada com Docker, garantindo portabilidade e facilidade de implantação.

Este projeto foi desenvolvido como parte do Tech Challenge da Pós-Graduação em Arquitetura de Software, com foco em boas práticas de desenvolvimento, design orientado a microsserviços e escalabilidade.


### Tecnologias utilizadas:

- Java 17
- Framework: Spring Boot
    - Spring Web  
    - Spring Validation
    - Spring Security
    - Java JWT - Auth0
    - JPA/Hibernate
    - Maven 
    - Flyway
    - Lombok
    - Mysql Connector
    - Springdoc
- Banco de Dados: MySql
- Containerização: Kubernetes
- Documentação da API: Swagger/OpenAPI
- Sistema de Gerenciamento de Base de Dados Relacional (SGBDR): phpMyAdmin

*******

## Instalação e Execução Local

### Pré-requisitos

- Docker e Docker Compose
- Minikube
- Git

### Passos para Configuração

Confirme se o Minikube está em execução utilizando o comando abaixo

`minikube status`

Caso não esteja, inicie o Minikube com 

`minikube start`

Clone o projeto em sua máquina

`git clone https://github.com/cormus/fiap-software-architecture.git`

`cd fiap-software-architecture`

Para testes com imagens Docker criadas localmente, vamos tilizando VM Host como Docker host

`eval $(minikube docker-env)`

Agora execute a aplicação com os comandos abaixo

`kubectl apply -f metrics.yaml`\
`kubectl apply -f mysql-storage.yaml`\
`kubectl apply -f mysql-secret.yaml`\
`kubectl apply -f mysql-configmap.yaml`\
`kubectl apply -f mysql-deployment.yaml`\
`kubectl apply -f phpmyadmin-deployment.yaml`\
`kubectl apply -f spring-deployment.yaml`\
`kubectl apply -f spring-hpa.yaml`

# Acessos

Verifique qualo o IP que o Minikube está em execução

`minikube ip`

### Documentação da API

A API possui uma documentação interativa gerada com Swagger. Após iniciar a aplicação, acesse:

http://\<utilize o ip minikube\>:30080/swagger-ui/index.html

### Acesso ao phpMyAdmin

Tammbém estará disponível acesso ao **phpMyAdmin**, permitindo a visualização das bases de dados e tabelas do projeto, acesse:

http://\<utilize o ip minikube\>:30081/

Dados de acesso

**Servidor:** mysql  
**Usuário:** root  
**Senha:** root

###  Event Storming

https://miro.com/app/board/uXjVLB4ecdM=/

### Desenho da arquitetura

https://miro.com/app/board/uXjVINORgl0=/

###  Vídeo de apresentação

https://drive.google.com/file/d/1IhN1DiGmlfhD6Fm65LS9tnTqPBxo4LDZ/view

# Autores

Alex Ribeiro de Lima (alexprodutor.com@gmail.com) - RM359957 

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/alex-ribeiro-de-lima)

