# Calculate Shipping️

### API to search CEP coding and calculate shipping

## Desenvolved with:
    - Spring 2.7.9
    - Maven 3.8.6
    - Java 11
    - Swagger 2.9.2
    - Cocumber 6.9.1
    - JUnit 5


## About
Calculate Shipping is a simple Rest API to calculate shipping according to zip code region

- easy-to-use API
- Swagger docs (http://localhost:8080/swagger-ui.html)

## In constrution :construction:
- Increase test coverage with cucumber
- Testing error responses



### Download 📥
```sh
git clone https://github.com/Marquezv/CalculateShipping.git
```

## Start Server 🌐
 - In the project folder
```sh
cd CalculateShipping
```
 - Run
```sh
mvn spring-boot:run
```
### Config
 - Server start with local config (application-local.properties)
    - Main route: localhost:8080/v1/
    - Port: 8080

- Server start with config (application.yml)

# Project 🚧
### This project has 3 layers: controllers, services and repositories following the demand of the object

    ├── config                    # Configuration files
    ├── model                     # Controll models
    ├── exceptions                    # Exceptions trataments 
    ├── service                   # Executing logical business rules
    |
    └── CalculateShippingApplication.java       # Main Class

# Routes ⛕ -
## Find CEP
| Method | Route |
| ------------- | ------------- |
|POST           | /consulta-endereco | VOID

    {
        "cep" : "86060-410",
    }
#### Response
    {
    	"cep": "86060-410",
    	"rua": "Rua Fernando de Noronha",
    	"complemento": "de 815/816 ao fim",
    	"bairro": "Centro",
    	"cidade": "Londrina",
    	"estado": "PR",
    	"regiao": "Sul",
    	"frete": 17.30
    }


#### References
 - https://www.baeldung.com/
 - https://www.amazon.com.br/Desenvolvimento-Real-Software-projetos-fundamentos/dp/6555202017/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=21KH77H1NY4S6&keywords=desenvolvimento+java&qid=1671036453&sprefix=desenvolvimento+java%2Caps%2C208&sr=8-1

