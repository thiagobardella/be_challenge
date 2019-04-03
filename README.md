# Solução #


## Autor: Thiago Bardella ##
 
 A implementação desta tarefa tem como pré-requisitos as seguintes tecnologias:
 
 *   Java 8
 *   Spring Boot Framework
 *   Gradle build tool
 
 Para rodar essa aplicação, basta
  
 *   clonar o repositório do git correspondente
 *   importar esse projeto como projeto gradle em sua IDE favorita
 *   executar as tasks do gradle 

    build
    bootRun -Pargs=input-routes.csv
  
  ou então, via terminal 
  
    gradle build
    gradle bootRun -Pargs=input-routes.csv
    
 sendo que o parâmetro passado deve ser o caminho do arquivo, que está em formato csv, que contém as rotas cadastradas. Se nenhum path for passado, então o arquivo csv utilizado será "input-routes.csv", fornecido com o enunciado.
 
 Assim que a aplicação estiver rodando, solicitará a rota através do terminal:
 
 
    Please enter the route (or writes 'esc' to keep application on Background): 
    GRU CDG
    GRU - BRC - SCL - ORL - CDG > $40
    Please enter the route (or writes 'esc' to keep application on Background): 
    esc
 
 Se selecionado a opção "esc", o programa passa a parar de solicitar rotas via terminal e entra em "brackground", apenas aceitando chamadas de API REST conforme definidas abaixo.
 
 ### API /routes/add
 
 Esta API deve ser chamada para cadastro de uma nova rota. Esta API deve receber como parâmetro a rota no formato CSV fornecido pelo enunciado. Um exemplo de chamada desta API é:
    
    curl -X POST \
      'http://localhost:8080/map/routes/add?route=th1,tgh,1' \
      -H 'Content-Type: application/x-www-form-urlencoded' \
      -H 'Postman-Token: d7238e39-abca-4a19-be8c-352b646a277a' \
      -H 'cache-control: no-cache'
    
 Caso a rota já exista, portanto origem e destinos já existem, nada acontecerá.  
 
 ### API /routes/all
 
 Esta API apenas retorna o conteúdo do arquivo csv que armazena todas as rotas já cadastradas. Um exemplo de chamada desta API é:
 
    curl -X GET \
        http://localhost:8080/map/routes/all \
        -H 'Postman-Token: 9b2906ad-12cd-4182-9755-00df2bfe6baf' \
        -H 'cache-control: no-cache'
   
 ### API /routes/get
 
 Esta API retorna o melhor rota que liga 2 pontos passados por parâmetros.
 
 Parâmetros:
 *  <b>from</b>: ponto de partida.
 *  <b>to</b>: destino.
    
    
    curl -X GET \
      'http://localhost:8080/map/routes/get?from=GRU&to=BRC' \
      -H 'Postman-Token: 6f7f5e73-e3be-4bd9-a707-34e99ac688e8' \
      -H 'cache-control: no-cache'
 

 ###    Testes unitários
 
 Antes de executar qualquer teste unitário, reinicializar o arquivo 'input-routes.csv' que encontra-se na raiz do projeto. para isso basta ser uma cópia do conteúdo do arquivo csv-unit-tests-file.txt. Pararodas os testes unitários basta executar a tarefa "test" do gradle ou executar via terminal:
    
    gradle test