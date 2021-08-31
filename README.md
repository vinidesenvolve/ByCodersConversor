# ByCodersConversor

## Descrição

API Rest para arquivos CNAB

Desenvolvida com Spring, JPA e PostgreSQL

## Índice
<p align="center"> - 
 <a href="#status">Status</a> - 
 <a href="#status"> Funcionalidades </a> - 
 <a href="#requisitos">Requisitos</a> - 
 <a href="#executando">Executando</a> - 
 <a href="#tecnologias">Tecnologias</a> - 
 <a href="#autor">Autor</a> - 
 <a href="#licença">Licença</a> - 
</p>

## Status 

Concluída

## Funcionalidades

- [x] Receber arquivo CNAB
- [x] Normalizar e persistir dados
- [x] Retornar dados normalizados

## Requisitos

### Ferramentas necessárias

Instale essas ferramnetas em sua máquina (caso não as tenha)

- [Git](https://git-scm.com)
- [Java 8+](https://www.java.com/en/)
- [PostgreSQL](https://www.postgresql.org/) instalar pgAdmin pode ajudar na manipulação* 
- [VSCode](https://code.visualstudio.com/) ou outra IDE da sua preferência com suporte para Java*
- [Insomnia](https://insomnia.rest/) ou Postman

Caso opte pelo VSCode instale a extensão Spring Boot Extension Pack

### Clone o repositório

Baixe o arquivo compactado ou faça um clone do git

No terminal ou prompt de comando dentro da pasta que deseja colocar o projeto

<code> $ git clone <https://github.com/vinidesenvolve/ByCodersConversor.git> </code>

## Executando

### Ambiente de Banco de Dados

  No Postgres crie um banco de dados CREATE DATABASE nomeDaBaseDeDados
  
  Em src/main/reources/application.properties configure esse arquivo com os
  dados do seu Postgre.
  
    spring.datasource.url=jdbc:postgresql://localhost:5432/nomeDaBaseDeDados
    spring.datasource.username=usuarioPostgre
    spring.datasource.password=senhaPostgre

    spring.jpa.hibernate.ddl-auto=create
    spring.jpa.show-sql=true
    
  * spring.jpa.hibernate.ddl-auto criar as tabelas através do mapeamento das models, 
    pequise pelas outras opções como update e create-drop
    
  * spring.jpa.show-sql não deve ser usada ambiente de produção

### Testando a API
  
  No VSCode vá para o Spring Dashboard suba a aplicação
  
  No Insomnia e faça uma requisição POST http://localhost:8080/upload, 
  coloque a opção Multipart no corpo do requisição, coloque o nome arquivo 
  e selecione o arquivo [CNAB.txt](https://github.com/vinidesenvolve/ByCodersConversor/blob/master/CNAB.txt) antes de enviar a requisição.
  
  Para receber os dados faça requisição GET http://localhost:8080/all
  
## Tecnologias

- [Spring](https://spring.io/)  
- [Java](https://www.java.com/en/)
- [PostgreSQL](https://www.postgresql.org/)
- [JPA](https://jakarta.ee/specifications/persistence/3.0/)
- [Lombok](https://projectlombok.org/)

## Autor

<p> <a href="https://github.com/vinidesenvolve">Vinicius Alves Rodrigues</a> </p>
<p> <a href="https://www.linkedin.com/in/vinidesenvolve/">Likedin</a> </p>
<p> <a href="vinidesenvolve@gmail.com">Email</a> </p>

## Licença

<p align="center">
MIT License

Copyright (c) 2021 Vinicius A. Rodrigues

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</p>
