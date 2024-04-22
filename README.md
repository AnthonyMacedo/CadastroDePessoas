# Cadastro De Pessoas

Sistema simples de cadastro e listagem de pessoas.

# Sobre o projeto

- Solução do desafio de cadastro de pessoas, foi feito algumas alterações nas tabelas, adicionando cidade e estado. 
- Foi feito um layout simples com Primefaces para o front onde foi criado template e um composite box para reutilizar nos formulários.
- Foi utilizado arquitetura MVC, foi separado nas seguintes camadas para separação de responsabilidades:
  * Model
  * Repository
  * Services
  * Controller
  * DTO

## Instruções de uso
O sistema possui 3 telas, Cadastro de Pessoas, Listagem de Pessoa e Listagem de Endereços:
- Tela de cadastro de pessoa, Nome é um campo obrigatório,
- Ao clicar em adicionar endereço, alguns campos também são obrigatórios, depois de adicionado a lista de endereços é atualziada permitindo editar ou excluir o endereço informado.
- Tela de pesquisa de pessoas, possui pesquisa de 3 campos, código, nome e cpf. No campo nome é indiferente estar maiúscula ou minúscula.
- Listagem de clientes também possui botões de edição de cadastro e exclusão.
- Listagem de endereços consulta endereços por nome da pessoa informada.

## Layout web
View Cadastro de Pessoas
![cadastro-pessoas-view](https://github.com/AnthonyMacedo/CadastroDePessoas/assets/47399385/dbdbb33b-e946-42d2-a660-25f4885e5236)


View Dialog Endereço
![view-endereco-dialog](https://github.com/AnthonyMacedo/CadastroDePessoas/assets/47399385/f57e96b3-4b94-4e9d-8d2d-e9059ec0df2c)


View Listagem de Pessoas
![listagem-pessoas-view](https://github.com/AnthonyMacedo/CadastroDePessoas/assets/47399385/637d5ac3-7028-4883-a73f-10eac4cca2c9)


View Listagem de Enderecos
![listagem-endereco-view](https://github.com/AnthonyMacedo/CadastroDePessoas/assets/47399385/cd2c2c18-fdd4-4541-9d5e-eec86a6973e3)


## Diagrama Entidade-Relacionamento
![DER](https://github.com/AnthonyMacedo/CadastroDePessoas/assets/47399385/1b3a0ba9-3695-4f23-859f-c441b5aa0ee0)


## Tecnologias utilizadas
- Java 8
- JPA / Hibernate
- JSF 2.2
- CDI
- Maven
- Primefaces 12
- Log4J
- Docker
  
## Banco de Dados
- PostgresSQL 10


# Como executar o projeto

## Back end
Pré-requisitos: Java 8 e Tomcat 8.5

```bash
# clonar repositório
git clone https://github.com/AnthonyMacedo/CadastroDePessoas.git

# compilar projeto com mvn package em seguida adicionar arquivo war na pasta SEU_DIR_TOMCAT\webapp do tomcat e depois executar na pasta SEU_DIR_TOMCAT\bin\startup.bat

## Banco de dados
Pré-requisitos: PostgresSQL 10

Segue link dos scripts a serem executados e sem seguida a ordem à serem executados.
https://github.com/AnthonyMacedo/CadastroDePessoas/blob/main/db-estrutura-script.sql
https://github.com/AnthonyMacedo/CadastroDePessoas/blob/main/inserts-cidade-estado-script.sql

## Ordem do scripts
- Primeiro passo criar uma role dbamaster no postgres.
- Segundo passo criar banco de dados db_cadastro_pessoas.
- Terceiro passo criar schema sch_desafio.
- Quarto passo criar tabelas e fazer inserts de cidades e estados.

# Autor

Anthony Jefferson Sousa Macedo


