# NovaBot API

API para recebimento de mensagens do slack pela slash /novaquotes

Feito com:

+ Java Spring Boot e Rest
+ JPA e Spring Data.

OBS: Nao versionar codigos compilados, temporarios ou especificos de alguma IDE. Esses arquivos nao precisam serem versionados, e podem dar problema entre IDEs distintas nos desenvolvedores da equipe. Por exemplo:

+ a pasta build ou settings do eclipse.
+ os arquivos .project ou .classpath do eclipse.
+ o arquivo nb-configuration.xml do netbeans.
+ a pasta target do maven.

Usar encoding UTF-8 em todos os arquivos.

# Configurações iniciais

+ faça o git clone
+ por linha de comando, faça "mvn clean install" na raiz do projeto.
+ por linha de comando, faça "java -jar novabot-api-0.1.jar" dentro da pasta "target".
+ acesse url http://localhost:8080/teste
+ após sucesso, abra na sua IDE favorita.
+ seja feliz :)
 
+ Para acessar os arquivos por ambiente, use essa propriedade tanto na execução quanto ao instalar: -Dspring.profiles.active=desenv

# Arquitetura

Existem quatro pacotes básicos centrais:
+ controller: são as configurações de acessos web REST.
+ modelo: as classes de domínio, com configurações sobre entidades JPA.
+ servico: classes intermediaria entre o dominio e o endpoint para possibilitar a injeção de dependência. Contem algumas validações.
+ util: classes utilirárias gerais.

Foi utilizado JPA simples sem configurações extras. A base de dados contém um identificador autoincremento, para facilitar o mapeamento (e o cacheamento) JPA. Chaves naturais podem ser substituidos por configurações de unicidades. Foi também diminuído ao máximo configurações de mapeamento reversos e cascade, deixando a cargo das regras fazerem o necessário.

Apesar de REST, usamos somente dois verbos HTTP:
+ GET: para buscar dados, seja unico por id ou listagens.
+ POST: qualquer alterações de dados.
