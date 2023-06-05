# Módulo 3 - Projeto Avaliativo 1

## Descrição  
A LABSky Linhas Aéreas entrou em operação com uma aeronave para atender a um grupo seleto de clientes que fazem o trecho Florianópolis/SC - Santa Maria/RS diariamente.
Você foi escolhido para criar o back-end de uma aplicação para gerenciar os passageiros que irão no voo.

## Motivação
O projeto é uma aplicação relacionada à aviação, que oferece funcionalidades como reserva de assentos, emissão de bilhetes de passagem e consulta de informações de passageiros.
Ele utiliza controllers para lidar com as operações, serviços para executar a lógica de negócio e o ModelMapper para mapeamento de objetos. 
Através de uma API, os usuários podem acessar essas funcionalidades para obter informações sobre assentos, confirmar bilhetes e consultar dados de passageiros.

## Utilização
A API desse projeto permite consultar assentos disponíveis, confirmar bilhetes de passagem e obter informações sobre passageiros na aviação.
Através dos métodos disponíveis nos controllers, é possível realizar requisições para obter a lista de assentos, confirmar a reserva de bilhetes e consultar dados dos passageiros.
Essa API possibilita uma integração simplificada e uma experiência completa para os usuários da aplicação.

Para cada endpoint, é necessário passar os parâmetros correspondentes de acordo com a documentação da API.
Além disso, é necessário enviar os dados em formato JSON com as informações requeridas, de acordo com o formato especificado na documentação da API.(https://docs.google.com/document/d/1ZTHxHAZmpffV4guoa3a_8vTjCBsI7KdWWDqOB3HebMQ/edit)

## Tecnologias
Spring Boot: O projeto utiliza o framework Spring Boot como base, conforme especificado no elemento <parent>. O Spring Boot é um framework Java para criação de aplicativos e serviços robustos e escaláveis.

Spring Boot Starter: São utilizados diferentes starters do Spring Boot para facilitar a configuração e o uso de recursos específicos.
As dependências incluem spring-boot-starter-data-jpa para acesso a dados com JPA, spring-boot-starter-validation para validação de dados, spring-boot-starter-web para desenvolvimento de aplicativos web, e spring-boot-starter-test para testes.

Hibernate: O projeto utiliza o Hibernate como implementação do JPA (Java Persistence API).
O Hibernate é um framework de mapeamento objeto-relacional que permite o acesso e manipulação de dados em bancos de dados relacionais.

MapStruct: É utilizada a dependência do MapStruct para mapeamento de objetos.
O MapStruct é uma biblioteca que simplifica o processo de mapeamento entre diferentes objetos, reduzindo a necessidade de escrever código manualmente.

H2 Database: O projeto utiliza o H2 Database como uma dependência de tempo de execução, que é um banco de dados relacional em memória.
O H2 Database é amplamente utilizado para desenvolvimento e teste de aplicativos.

ModelMapper: É utilizado o ModelMapper como uma dependência para mapeamento de objetos.
O ModelMapper é uma biblioteca que facilita o mapeamento de objetos entre diferentes estruturas, ajudando a simplificar a conversão de dados.

Lombok: É utilizada a dependência do Lombok para gerar automaticamente o código repetitivo, como getters, setters e construtores, reduzindo a quantidade de código boilerplate necessário.

Essas tecnologias foram escolhidas para facilitar o desenvolvimento do projeto, fornecer recursos como acesso a dados, validação, mapeamento de objetos e simplificação do código.
O Spring Boot é o framework principal que integra essas tecnologias e permite a criação de uma aplicação eficiente e escalável.

## Possíveis Melhorias
* Adição de recursos de autenticação e autorização, para garantir a segurança e o controle de acesso ao sistema.
* Implantação de um sistema de backup e recuperação de dados, para evitar perda de informações e garantir a disponibilidade do sistema.
* Aimplementação de logs adequados na aplicação, registrando eventos relevantes e informações úteis para fins de depuração, monitoramento e análise de desempenho.
  
  




   Desenvolvido por:
   Pedro Lima do Nascimento
   <a href="https://www.linkedin.com/in/pedro-lima-12b92332/">Linkedin | <a href="https://github.com/GitdoPedro">Github
