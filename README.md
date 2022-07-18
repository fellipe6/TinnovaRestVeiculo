# Projeto API JSON RESTfull Veículos TINNOVA
Desafio de uma aplicação de um cadastro de veículo finalizado para o processo seletivo Tinnova.

Entidade Veículo como especificado abaixo:

Especificação da Entidade Veiculo

{

    veiculo : String,    
    marca : String,    
    ano : Integer,    
    descricao : text,    
    vendido : boolean,    
    created : datetime,    
    updated : datetime
    
}


## Tecnologias utilizadas no Projeto:

  -  Java
  -  Spring Boot
  -  JPA / Hibernate
  -  Maven
  -  MySql
  -  Postman
  -  OpenApi
  -  Heroku
  ### Link da documentação Swagger
  - https://tinnova.herokuapp.com/swagger-ui.html
  
  ###Exemplo POST
  
  {
  
  "ano": 2022,  
  "descricao": "R$25.000",  
  "fornecedor": "ex.FORD",  
  "fornecedores": "FIAT",  
  "veiculo": "Fiesta",
  "venda": true  
}

*Campo venda e fornecedor são obrigatórios!
Para fornecedor serão aceitos: FIAT, FORD,VOLKSWAGEN,CHEVROLET

  ###Exemplo PATCH

{       "veiculo": "Celta, Cor: AMARELO",
        "fornecedor":"CHEVROLET"       
}

*Campo fornecedor é obrigatório e só serão aceitos apenas: FIAT, FORD,VOLKSWAGEN,CHEVROLET.
